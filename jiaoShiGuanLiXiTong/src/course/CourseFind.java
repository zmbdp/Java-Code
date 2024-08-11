package course;

import Information.GetConnec;
import Information.GetSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseFind extends JFrame {
    private JTextField d课程id;

    public CourseFind() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("查找课程数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel 课程id = new JLabel("课程id:");
        d课程id = new JTextField();

        JButton submitJB = new JButton("查找");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findCourse();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Course(); // 返回教室表操作菜单
            }
        });

        panel.add(课程id);
        panel.add(d课程id);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void findCourse() {
        if (!d课程id.getText().isEmpty()) {
            GetSource getSource = new GetSource();
            GetConnec getConnec = new GetConnec();
            try (Connection conn = getConnec.getConnection(getSource.getDataSource())) {
                String sql = "select * from 课程表 where 课程id = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, Integer.parseInt(d课程id.getText()));
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        String result = "课程id: " + rs.getInt("课程id") + "\n" +
                                "教室名: " + rs.getString("教室名") + "\n" +
                                "教师id: " + rs.getInt("教师id") + "\n" +
                                "学生id: " + rs.getInt("学生id") + "\n" +
                                "课程名: " + rs.getString("课程名") + "\n" +
                                "上课时间: " + rs.getString("上课时间") + "\n" +
                                "下课时间: " + rs.getString("下课时间");
                        JOptionPane.showMessageDialog(null, result, "查询结果", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "未找到匹配数据", "查询结果", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "数据库错误：" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "请填写课程id！");
        }
    }

    private void showResultInNewWindow(String result) {
        JFrame resultFrame = new JFrame("查询结果");
        resultFrame.setSize(400, 300);
        resultFrame.setLocationRelativeTo(null);

        JTextArea resultArea = new JTextArea(result);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        resultFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        resultFrame.setVisible(true);
    }
}
