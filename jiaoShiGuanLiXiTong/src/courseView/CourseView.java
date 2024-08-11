package courseView;

import Information.GetConnec;
import Information.GetSource;
import initialize.CourseViewInitialize;
import mainBao.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseView extends JFrame {
    private JTextField d学生id;

    public CourseView() throws SQLException {
        // 调用初始化类来创建视图
        new CourseViewInitialize();
        CourseViewUI();
    }

    // 创建查看视图的窗口
    private void CourseViewUI() throws SQLException {
        setTitle("查找检查表数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel 学生idLabel = new JLabel("学生id:");
        this.d学生id = new JTextField();

        JButton submitJB = new JButton("查询");
        JButton retJB = new JButton("返回");

        panel.add(学生idLabel);
        panel.add(d学生id);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findView();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "查找操作出现异常: " + ex.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu();
                dispose();
            }
        });

        // 设置窗口可见
        setVisible(true);
    }

    private void findView() throws SQLException {
        String 学生idCur = d学生id.getText();

        if (学生idCur.isEmpty()) {
            JOptionPane.showMessageDialog(null, "学生id不能为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int 学生id;
        try {
            学生id = Integer.parseInt(学生idCur);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "学生id必须是整数！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            GetSource getSource = new GetSource();
            GetConnec getConnec = new GetConnec();
            connection = getConnec.getConnection(getSource.getDataSource());
            String findSql = "select * from 学生课程表 where 学生id = ?";
            statement = connection.prepareStatement(findSql);
            statement.setInt(1, 学生id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String result = "该学生的课程信息为:" +
                        "\n学生id: " + resultSet.getInt("学生id") +
                        "\n课程名: " + resultSet.getString("课程名") +
                        "\n课程id: " + resultSet.getInt("课程id") +
                        "\n教室名: " + resultSet.getString("教室名") +
                        "\n教师名: " + resultSet.getString("教师名") +
                        "\n教师id: " + resultSet.getInt("教师id") +
                        "\n上课时间: " + resultSet.getTimestamp("上课时间") +
                        "\n下课时间: " + resultSet.getTimestamp("下课时间");
                JOptionPane.showMessageDialog(null, result, "查询结果", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "未找到匹配数据", "查询结果", JOptionPane.INFORMATION_MESSAGE);
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
    }
}
