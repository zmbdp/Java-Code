package course;

import Information.GetConnec;
import Information.GetSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDel extends JFrame {
    private JTextField d课程id;

    public CourseDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除课程");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中显示

        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("课程id:"));
        d课程id = new JTextField();
        panel.add(d课程id);

        JButton submitJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delCourse();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Course(); // 返回课程表操作菜单
            }
        });

        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void delCourse() {
        if (!d课程id.getText().isEmpty()) {
            GetSource getSource = new GetSource();
            GetConnec getConnec = new GetConnec();
            try (Connection connection = getConnec.getConnection(getSource.getDataSource())) {
                String sql = "delete from 课程表 where 课程id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, Integer.parseInt(d课程id.getText()));
                    int rowsAffected = statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, rowsAffected > 0 ? "课程删除成功！" : "未找到指定的课程！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "数据库错误：" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "请填写课程id！");
        }
    }
}

