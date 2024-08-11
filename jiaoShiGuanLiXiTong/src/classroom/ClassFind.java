package classroom;

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

public class ClassFind extends JFrame {

    private JTextField nameField;
    private JTextArea resultArea;

    public ClassFind() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("查找教室数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel 待查教室名 = new JLabel("教室名:");
        nameField = new JTextField();

        JButton searchJB = new JButton("查找");
        JButton retJB = new JButton("返回");

        searchJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findClassroomData();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Classroom(); // 返回教室表操作菜单
            }
        });

        panel.add(待查教室名);
        panel.add(nameField);
        panel.add(searchJB);
        panel.add(retJB);
        panel.add(new JScrollPane(resultArea));

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void findClassroomData() {
        String 教室名 = nameField.getText();

        if (教室名.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入教室名！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String 教室名cur = String.copyValueOf(教室名.toCharArray());

            // 创建数据源
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            // 建立数据库连接
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                GetConnec getConnec = new GetConnec();
                connection = getConnec.getConnection(source);

                // 创建查询语句
                String sql = "select * from 教室表 where 教室名 = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, 教室名cur);

                // 执行查询操作
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String message = "教室名: " + resultSet.getString("教室名") + "\n" +
                            "最大学生数: " + resultSet.getInt("最大学生数") + "\n" +
                            "教学楼地址: " + resultSet.getString("教学楼地址") + "\n" +
                            "教室类别: " + resultSet.getString("教室类别") + "\n" +
                            "教室空闲状态: " + (resultSet.getBoolean("教室空闲状态") ? "空闲" : "忙碌") + "\n";

                    JOptionPane.showMessageDialog(this, message, "教室信息", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "未找到改教室。", "查找结果", JOptionPane.INFORMATION_MESSAGE);
                }

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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "查找数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
