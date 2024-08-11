package teacher;

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

public class TeacherFind extends JFrame {

    private JTextField teacherIdField;
    private JTextArea resultArea;

    public TeacherFind() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("查找教师信息");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        // 计算屏幕中心位置
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel 教师id = new JLabel("请输入需要查找的教师id:");
        teacherIdField = new JTextField();

        JButton searchJB = new JButton("查找");
        JButton retJB = new JButton("返回");

        searchJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findTeacher();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "查找操作出现异常: " + ex.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Teacher();
                dispose();
            }
        });

        panel.add(教师id);
        panel.add(teacherIdField);
        panel.add(searchJB);
        panel.add(retJB);
        panel.add(new JScrollPane(resultArea));

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void findTeacher() throws SQLException {
        String teacherIdCur = teacherIdField.getText();
        if (teacherIdCur.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入教师id", "输入错误", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            String teacherId = String.copyValueOf(teacherIdCur.toCharArray());
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

                // 准备 SQL 查询语句
                String sql = "select * from 教师表 where 教师id = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, teacherId);

                // 执行查询操作
                resultSet = statement.executeQuery();

                // 处理查询结果
                if (resultSet.next()) {
                    String message = "教师id：" + resultSet.getInt("教师id") + "\n" +
                            "教师名：" + resultSet.getString("教师名") + "\n" +
                            "办公室地址：" + resultSet.getString("办公室地址") + "\n" +
                            "教师性别：" + resultSet.getString("教师性别") + "\n";

                    JOptionPane.showMessageDialog(this, message, "查询结果", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "未找到该教师" + "查询结果" + JOptionPane.INFORMATION_MESSAGE);
                }

            } finally {
                // 关闭资源
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
            JOptionPane.showMessageDialog(this, "检查员id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "查找数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }

    }
}
