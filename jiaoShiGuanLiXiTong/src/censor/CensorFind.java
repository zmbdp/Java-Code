package censor;

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

public class CensorFind extends JFrame {
    private JTextField idField;

    public CensorFind() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("查找检查员数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        // 设置窗口居中显示
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("检查员id:");
        idField = new JTextField();

        JButton submitJB = new JButton("查找");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findCensor();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Censor();
                dispose();
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void findCensor() {
        String id = idField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入检查员id！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idInt = Integer.parseInt(id);

            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                GetConnec getConnec = new GetConnec();
                connection = getConnec.getConnection(source);

                String sql = "select * from 检查员表 where 检查员id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idInt);

                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int censorId = resultSet.getInt("检查员id");
                    String censorName = resultSet.getString("检查员姓名");
                    int censorAge = resultSet.getInt("检查员年龄");
                    String censorGender = resultSet.getString("检查员性别");
                    boolean censorStatus = resultSet.getBoolean("检查员空闲状态");

                    String message = "检查员id: " + censorId + "\n" +
                            "检查员姓名: " + censorName + "\n" +
                            "检查员年龄: " + censorAge + "\n" +
                            "检查员性别: " + censorGender + "\n" +
                            "检查员空闲状态: " + (censorStatus ? "空闲" : "忙碌");
                    JOptionPane.showMessageDialog(this, message, "查询结果", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "未找到该检查员。", "查找结果", JOptionPane.INFORMATION_MESSAGE);
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
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "检查员id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "查找数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
