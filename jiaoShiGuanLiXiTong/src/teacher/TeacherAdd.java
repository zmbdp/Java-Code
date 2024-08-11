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

public class TeacherAdd extends JFrame {

    private JTextField idField, nameField, officeField;
    private JComboBox<String> genderBox;

    public TeacherAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("添加教师信息");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null); // 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel 教师id = new JLabel("教师id:");
        idField = new JTextField();

        JLabel 教师名 = new JLabel("教师名:");
        nameField = new JTextField();

        JLabel 办公室地址 = new JLabel("办公室地址:");
        officeField = new JTextField();

        JLabel 教师性别 = new JLabel("教师性别:");
        String[] genders = {"男", "女"};
        genderBox = new JComboBox<>(genders);

        JButton submitJB = new JButton("添加");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addTeacher();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "添加操作出现异常: " + ex.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Teacher();// 返回上一个菜单或界面
                dispose(); // 关闭当前窗口
            }
        });

        panel.add(教师id);
        panel.add(idField);
        panel.add(教师名);
        panel.add(nameField);
        panel.add(办公室地址);
        panel.add(officeField);
        panel.add(教师性别);
        panel.add(genderBox);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void addTeacher() throws SQLException {
        int teacherId = Integer.parseInt(idField.getText());
        String teacherName = nameField.getText();
        String officeLocation = officeField.getText();
        String teacherGender = (String) genderBox.getSelectedItem();

        if (idField.getText().isEmpty() || teacherName.isEmpty() || teacherGender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
            String sql = "insert into 教师表 values (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, teacherId);
            statement.setString(2, teacherName);
            statement.setString(3, officeLocation);
            statement.setString(4, teacherGender);

            // 执行更新操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已插入。");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "插入失败，该教师id已存在!!!", "数据库错误", JOptionPane.ERROR_MESSAGE);
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
