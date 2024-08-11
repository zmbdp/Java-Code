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
import java.sql.SQLException;

public class TeacherDel extends JFrame {

    private JTextField teacherIdField;

    public TeacherDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除教师信息");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null); // 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel 教师id = new JLabel("教师id:");
        teacherIdField = new JTextField();

        JButton deleteJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        deleteJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteTeacher();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "删除操作出现异常: " + ex.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
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
        panel.add(deleteJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void deleteTeacher() throws SQLException {
        String teacherId = teacherIdField.getText();

        // 创建数据源
        GetSource getSource = new GetSource();
        DataSource source = getSource.getDataSource();

        // 建立数据库连接
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            GetConnec getConnec = new GetConnec();
            connection = getConnec.getConnection(source);

            // 准备 SQL 语句
            String sql = "delete from 教师表 where 教师id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, teacherId);

            // 执行删除操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已删除。");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "删除失败，教师id不存在或删除操作出现异常: " + e.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 关闭资源
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
