package student;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRevise extends JFrame {

    private JTextField d老学生id;
    private JTextField d新学生id;
    private JTextField d新学生名;
    private JTextField d新学生年龄;
    private JComboBox<String> d新学生性别;

    public StudentRevise() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("修改学生数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel 老学生id = new JLabel("学生id:");
        d老学生id = new JTextField();

        JLabel 新学生id = new JLabel("新学生id:");
        d新学生id = new JTextField();

        JLabel 新学生名 = new JLabel("新学生名:");
        d新学生名 = new JTextField();

        JLabel 新学生年龄 = new JLabel("新学生年龄:");
        d新学生年龄 = new JTextField();

        JLabel 新学生性别 = new JLabel("新学生性别:");
        String[] genders = {"男", "女"};
        d新学生性别 = new JComboBox<>(genders);

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReviseStudent();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Student(); // 返回学生表操作菜单
            }
        });

        panel.add(老学生id);
        panel.add(d老学生id);
        panel.add(新学生id);
        panel.add(d新学生id);
        panel.add(新学生名);
        panel.add(d新学生名);
        panel.add(新学生年龄);
        panel.add(d新学生年龄);
        panel.add(新学生性别);
        panel.add(d新学生性别);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // 窗体居中显示
        setVisible(true); // 确保窗体可见
    }

    private void ReviseStudent() {
        String 学生idCur = d老学生id.getText();
        String nameCur = d新学生名.getText();
        String ageCur = d新学生年龄.getText();
        String 新性别 = (String) d新学生性别.getSelectedItem();
        // 新学生 id 可以为空
        String 新学生idCur = d新学生id.getText();

        if (学生idCur.isEmpty() || nameCur.isEmpty() || ageCur.isEmpty()) {
            JOptionPane.showMessageDialog(null, "学生id、新姓名、新年龄不可为空！",
                    "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(学生idCur);
        // 直接等于老id，不为空再等于新 id
        int newId = Integer.parseInt(学生idCur);
        int newAge;

        // 尝试转换输入的学生 id 和新学生 id 为整数
        if (!新学生idCur.isEmpty()){
            try {
                id = Integer.parseInt(学生idCur);
                newId = Integer.parseInt(新学生idCur);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "学生id和新学生id必须是整数。",
                        "输入错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // 尝试转换输入的新学生年龄为整数
        try {
            newAge = Integer.parseInt(ageCur);
            if (newAge <= 0) {
                throw new NumberFormatException("学生年龄必须大于0");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "新学生年龄必须是一个正整数。",
                    "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 创建数据源
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            // 建立数据库连接
            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            // 首先查询是否存在该学生id的记录
            String findSql = "select * from 学生表 where 学生id = ?";
            PreparedStatement queryStatement = connection.prepareStatement(findSql);
            queryStatement.setInt(1, id);
            ResultSet resultSet = queryStatement.executeQuery();

            if (resultSet.next()) {
                // 存在该学生id的记录，执行更新操作
                String updateSql = "update 学生表 set 学生id = ?, 学生名 = ?, 学生年龄 = ?, 学生性别 = ? where 学生id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setInt(1, newId);
                updateStatement.setString(2, nameCur);
                updateStatement.setInt(3, newAge);
                updateStatement.setString(4, 新性别);
                updateStatement.setInt(5, id);

                int n = updateStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, n + " 条记录已修改。");

                updateStatement.close();
            } else {
                JOptionPane.showMessageDialog(null, "未找到该学生id的记录。",
                        "修改失败", JOptionPane.ERROR_MESSAGE);
            }

            // 关闭资源
            resultSet.close();
            queryStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "修改失败，新学生id已存在。",
                    "学生id错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
