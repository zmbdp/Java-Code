package student;

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

public class StudentAdd extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> genderComboBox;

    public StudentAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("添加学生数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("学生id:");
        idField = new JTextField();

        JLabel nameLabel = new JLabel("学生名:");
        nameField = new JTextField();

        JLabel ageLabel = new JLabel("学生年龄:");
        ageField = new JTextField();

        JLabel genderLabel = new JLabel("学生性别:");
        String[] genders = {"男", "女"};
        genderComboBox = new JComboBox<>(genders);

        JButton submitJB = new JButton("提交");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Student(); // 返回学生表操作菜单
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderComboBox);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // 窗体居中显示
        setVisible(true); // 确保窗体可见
    }

    private void addStudent() {
        String idStr = idField.getText();
        String name = nameField.getText();
        String ageStr = ageField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        int id = Integer.parseInt(idStr);
        int age = Integer.parseInt(ageStr);
        if (age < 0) {
            JOptionPane.showMessageDialog(null, "年龄必须大于0", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (idStr.isEmpty() || name.isEmpty() || ageStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }



        try {
            // 创建数据源
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            // 建立数据库连接
            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            // 准备 SQL 语句
            String sql = "insert into 学生表 values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, gender);

            // 执行更新操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已插入。");

            // 关闭资源
            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "学生id和年龄必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "插入失败，该学生id已存在或数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
