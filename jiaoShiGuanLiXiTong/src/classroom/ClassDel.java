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
import java.sql.SQLException;

public class ClassDel extends JFrame {

    private JTextField nameField;

    public ClassDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除教室数据");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel 查询教室名 = new JLabel("教室名:");
        nameField = new JTextField();

        JButton submitJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClassroomData();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Classroom(); // 返回教室表操作菜单
            }
        });

        panel.add(查询教室名);
        panel.add(nameField);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void deleteClassroomData() {
        String 教室名 = nameField.getText();

        // 创建数据源
        GetSource getSource = new GetSource();
        DataSource source = getSource.getDataSource();

        // 建立数据库连接
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            GetConnec getConnec = new GetConnec();
            connection = getConnec.getConnection(source);

            // 创建删除语句
            String sql = "delete from 教室表 where 教室名 = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, 教室名);

            // 执行删除操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已删除。");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "删除操作出现异常: " + e.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "关闭数据库资源出现异常: " + e.getMessage(), "资源关闭错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
