package censor;

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

public class CensorRevise extends JFrame {
    private JTextField d老检查员id;
    private JTextField d新检查员id;
    private JTextField d新检查员姓名;
    private JTextField d新检查员年龄;
    private JComboBox<String> d新检查员性别;
    private JComboBox<String> d新检查员空闲状态;

    public CensorRevise() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("修改检查员数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        // 设置窗口居中显示
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel 老检查员id = new JLabel("老检查员id:");
        d老检查员id = new JTextField();

        JLabel 新检查员id = new JLabel("新检查员id:");
        d新检查员id = new JTextField();

        JLabel 新检查员姓名 = new JLabel("新检查员姓名:");
        d新检查员姓名 = new JTextField();

        JLabel 新检查员年龄 = new JLabel("新检查员年龄:");
        d新检查员年龄 = new JTextField();

        JLabel 新检查员性别 = new JLabel("新检查员性别:");
        String[] genders = {"男", "女"};
        d新检查员性别 = new JComboBox<>(genders);

        JLabel 新检查员空闲状态 = new JLabel("新检查员空闲状态:");
        String[] statusOptions = {"空闲", "非空闲"};
        d新检查员空闲状态 = new JComboBox<>(statusOptions);

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reviseCensor();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Censor();
                dispose();
            }
        });

        panel.add(老检查员id);
        panel.add(d老检查员id);
        panel.add(新检查员id);
        panel.add(d新检查员id);
        panel.add(新检查员姓名);
        panel.add(d新检查员姓名);
        panel.add(新检查员年龄);
        panel.add(d新检查员年龄);
        panel.add(新检查员性别);
        panel.add(d新检查员性别);
        panel.add(新检查员空闲状态);
        panel.add(d新检查员空闲状态);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void reviseCensor() {
        String 老检查员id = d老检查员id.getText();
        String 新检查员id = d新检查员id.getText();
        String 新检查员姓名 = d新检查员姓名.getText();
        String 新检查员年龄 = d新检查员年龄.getText();
        String 新检查员性别 = (String) d新检查员性别.getSelectedItem();
        String 新检查员空闲状态 = (String) d新检查员空闲状态.getSelectedItem();

        if (老检查员id.isEmpty() || 新检查员id.isEmpty() || 新检查员姓名.isEmpty() || 新检查员年龄.isEmpty() || 新检查员性别 == null || 新检查员空闲状态 == null) {
            JOptionPane.showMessageDialog(this, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int oldIdInt = Integer.parseInt(老检查员id);
            int newIdInt = Integer.parseInt(新检查员id);
            int ageInt = Integer.parseInt(新检查员年龄);

            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            Connection connection = null;
            PreparedStatement statement = null;

            try {
                GetConnec getConnec = new GetConnec();
                connection = getConnec.getConnection(source);

                String sql = "update 检查员表 set 检查员id = ?, 检查员姓名 = ?, 检查员年龄 = ?, 检查员性别 = ?, 检查员空闲状态 = ? where 检查员id = ?";
                statement = connection.prepareStatement(sql.toLowerCase());
                statement.setInt(1, newIdInt);
                statement.setString(2, 新检查员姓名);
                statement.setInt(3, ageInt);
                statement.setString(4, 新检查员性别);
                statement.setBoolean(5, 新检查员空闲状态.equals("空闲"));
                statement.setInt(6, oldIdInt);

                int n = statement.executeUpdate();
                JOptionPane.showMessageDialog(this, n + " 条记录已修改。");

            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "检查员id和年龄必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "修改数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
