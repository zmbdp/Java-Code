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

public class TeacherRevise extends JFrame {

    private JTextField teacherIdField;
    private JTextField teacherNameField;
    private JTextField officeLocationField;
    private JTextField newTeacherIdField;
    private JComboBox<String> genderComboBox;

    public TeacherRevise() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("修改教师信息");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel 教师id = new JLabel("教师id:");
        teacherIdField = new JTextField();

        JLabel 新教师id = new JLabel("新教师id:");
        newTeacherIdField = new JTextField();

        JLabel 新教师名 = new JLabel("新教师名:");
        teacherNameField = new JTextField();

        JLabel 新办公室地址 = new JLabel("新办公室地址:");
        officeLocationField = new JTextField();

        JLabel 新教师性别 = new JLabel("新教师性别:");
        String[] genders = {"男", "女"};
        genderComboBox = new JComboBox<>(genders);

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modifyTeacher();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "修改操作出现异常: " + ex.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
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
        panel.add(新教师id);
        panel.add(newTeacherIdField);
        panel.add(新教师名);
        panel.add(teacherNameField);
        panel.add(新办公室地址);
        panel.add(officeLocationField);
        panel.add(新教师性别);
        panel.add(genderComboBox);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void modifyTeacher() throws SQLException {
        int teacherId, newTeacherId;
        String teacherName = teacherNameField.getText();
        String officeLocation = officeLocationField.getText();
        String teacherGender = (String) genderComboBox.getSelectedItem();

        // 检查输入数据是否完整
        if (teacherName.isEmpty() || officeLocation.isEmpty() || newTeacherIdField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 尝试转换输入的教师id和新教师id为整数
        try {
            teacherId = Integer.parseInt(teacherIdField.getText());
            newTeacherId = Integer.parseInt(newTeacherIdField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "教师id和新教师id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        GetSource getSource = new GetSource();
        DataSource source = getSource.getDataSource();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            GetConnec getConnec = new GetConnec();
            connection = getConnec.getConnection(source);

            String sql = "update 教师表 set 教师id = ?, 教师名 = ?, 办公室地址 = ?, 教师性别 = ? where 教师id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, newTeacherId);
            statement.setString(2, teacherName);
            statement.setString(3, officeLocation);
            statement.setString(4, teacherGender);
            statement.setInt(5, teacherId);

            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已修改。");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "修改失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
