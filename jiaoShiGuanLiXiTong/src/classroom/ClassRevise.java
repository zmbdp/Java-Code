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

public class ClassRevise extends JFrame {

    private JTextField nameField;
    private JTextField newNameField;
    private JTextField maxStudentsField;
    private JTextField locationField;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> statusComboBox;

    public ClassRevise() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("修改教室数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel 教室名 = new JLabel("请输入要修改的教室名:");
        nameField = new JTextField();

        JLabel new教室名 = new JLabel("新的教室名:");
        newNameField = new JTextField();

        JLabel 最大学生数 = new JLabel("最大学生数:");
        maxStudentsField = new JTextField();

        JLabel 教学楼地址 = new JLabel("教学楼地址:");
        locationField = new JTextField();

        JLabel 教室类别 = new JLabel("教室类别:");
        String[] types = {"多媒体教室", "实验室", "普通教室"};
        typeComboBox = new JComboBox<>(types);

        JLabel 空闲状态 = new JLabel("教室空闲状态:");
        String[] statuses = {"空闲", "非空闲"};
        statusComboBox = new JComboBox<>(statuses);

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reviseClassroomData();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Classroom(); // 返回教室表操作菜单
            }
        });

        panel.add(教室名);
        panel.add(nameField);
        panel.add(new教室名);
        panel.add(newNameField);
        panel.add(最大学生数);
        panel.add(maxStudentsField);
        panel.add(教学楼地址);
        panel.add(locationField);
        panel.add(教室类别);
        panel.add(typeComboBox);
        panel.add(空闲状态);
        panel.add(statusComboBox);

        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void reviseClassroomData() {
        String 教室名 = nameField.getText();
        String 新教室名 = newNameField.getText();
        int 最大学生数 = Integer.parseInt(maxStudentsField.getText());
        String 教学楼地址 = locationField.getText();
        String 教室类别 = (String) typeComboBox.getSelectedItem();
        boolean 教室空闲状态 = statusComboBox.getSelectedItem().equals("空闲");

        // 检查输入数据是否完整
        if (新教室名.isEmpty() || 教学楼地址.isEmpty() || 教室类别.isEmpty() || maxStudentsField.getText().isEmpty()) {
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

            // 创建更新语句
            String sql = "update 教室表 set 教室名 = ?, 最大学生数 = ?, 教学楼地址 = ?, 教室类别 = ?, 教室空闲状态 = ? where 教室名 = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, 新教室名);
            statement.setInt(2, 最大学生数);
            statement.setString(3, 教学楼地址);
            statement.setString(4, 教室类别);
            statement.setBoolean(5, 教室空闲状态);
            statement.setString(6, 教室名);

            // 执行更新操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已修改。");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "修改操作出现异常: " + e.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
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
