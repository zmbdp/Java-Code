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

public class StudentFind extends JFrame {

    private JTextField idFind;
    private JTextArea resultArea;

    public StudentFind() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("查找学生数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null); // 窗体居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel findId = new JLabel("请输入要查找的学生id:");
        idFind = new JTextField();

        JButton submitJB = new JButton("查找");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findStudent();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Student(); // 返回学生表操作菜单
            }
        });

        panel.add(findId);
        panel.add(idFind);
        panel.add(submitJB);
        panel.add(retJB);
        // 防止信息太多，添加滚动面板
        panel.add(new JScrollPane(resultArea));

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true); // 确保窗体可见
    }

    private void findStudent() {
        String findId = idFind.getText();

        if (findId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入学生id！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int id = Integer.parseInt(findId);

            try {
                // 创建数据源
                GetSource getSource = new GetSource();
                DataSource source = getSource.getDataSource();

                // 建立数据库连接
                GetConnec getConnec = new GetConnec();
                connection = getConnec.getConnection(source);

                // 准备 SQL 语句
                String sql = "select * from 学生表 where 学生id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);

                // 执行查询操作
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int studentId = resultSet.getInt("学生id");
                    String studentName = resultSet.getString("学生名");
                    int studentAge = resultSet.getInt("学生年龄");
                    String studentGender = resultSet.getString("学生性别");

                    String result = "学生id: " + studentId + "\n" +
                            "学生名: " + studentName + "\n" +
                            "学生年龄: " + studentAge + "\n" +
                            "学生性别: " + studentGender;
                    JOptionPane.showMessageDialog(null, result, "查询结果", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "未找到该学生id的记录。", "查找结果", JOptionPane.INFORMATION_MESSAGE);
                }

                // 关闭资源
                resultSet.close();
                statement.close();
                connection.close();
            } finally {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }  catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "学生id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "查找数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
