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

public class StudentDel extends JFrame {

    private JTextField idField;

    public StudentDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除学生数据");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("学生id:");
        idField = new JTextField();

        JButton deleteJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        deleteJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
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
        panel.add(deleteJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // 窗体居中显示
        setVisible(true); // 确保窗体可见
    }

    private void deleteStudent() {
        String idStr = idField.getText();

        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入学生id！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(idStr);

        try {
            // 创建数据源
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            // 建立数据库连接
            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            // 准备 SQL 语句
            String sql = "delete from 学生表 where 学生id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            // 执行删除操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已删除。");

            // 关闭资源
            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "学生id必须是一个整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "删除失败，该学生id不存在或数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
