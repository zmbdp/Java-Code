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

public class CensorAdd extends JFrame {
    private JTextField d检查员id;
    private JTextField d检查员姓名;
    private JTextField d检查员年龄;
    private JComboBox<String> d检查员性别;
    private JComboBox<String> d检查员空闲状态;

    public CensorAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("增加检查员数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null); // 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel 检查员id = new JLabel("检查员id:");
        d检查员id = new JTextField();

        JLabel 检查员姓名 = new JLabel("检查员姓名:");
        d检查员姓名 = new JTextField();

        JLabel 检查员年龄 = new JLabel("检查员年龄:");
        d检查员年龄 = new JTextField();

        JLabel 检查员性别 = new JLabel("检查员性别:");
        String[] genders = {"男", "女"};
        d检查员性别 = new JComboBox<>(genders);

        JLabel 检查员空闲状态 = new JLabel("检查员空闲状态:");
        String[] statusOptions = {"空闲", "非空闲"};
        d检查员空闲状态 = new JComboBox<>(statusOptions);

        JButton submitJB = new JButton("增加");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCensor();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Censor(); // 返回检查员表操作菜单
                dispose(); // 关闭当前窗口
            }
        });

        panel.add(检查员id);
        panel.add(d检查员id);
        panel.add(检查员姓名);
        panel.add(d检查员姓名);
        panel.add(检查员年龄);
        panel.add(d检查员年龄);
        panel.add(检查员性别);
        panel.add(d检查员性别);
        panel.add(检查员空闲状态);
        panel.add(d检查员空闲状态);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addCensor() {
        String 检查员idCur = d检查员id.getText();
        String 检查员姓名 = d检查员姓名.getText();
        String 检查员年龄Cur = d检查员年龄.getText();
        String 检查员性别 = (String) d检查员性别.getSelectedItem();
        boolean 检查员空闲状态 = d检查员空闲状态.getSelectedItem().equals("空闲");

        if (检查员idCur.isEmpty() || 检查员姓名.isEmpty() || 检查员年龄Cur.isEmpty() || 检查员性别 == null) {
            JOptionPane.showMessageDialog(null, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int 检查员id = Integer.parseInt(检查员idCur);
        int 检查员年龄 = Integer.parseInt(检查员年龄Cur);
        if (检查员年龄 < 0) {
            JOptionPane.showMessageDialog(this, "年龄必须大于0！");
            return;
        }

        try {

            GetSource getSource = new GetSource();
            DataSource dataSource = getSource.getDataSource();

            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(dataSource);

            String sql = "insert into 检查员表 values (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 检查员id);
            statement.setString(2, 检查员姓名);
            statement.setInt(3, 检查员年龄);
            statement.setString(4, 检查员性别);
            statement.setBoolean(5, 检查员空闲状态);

            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(this, n + " 条记录已增加。");

            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "检查员的id和年龄必须是一个正整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "插入失败，该教室号已存在或数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
