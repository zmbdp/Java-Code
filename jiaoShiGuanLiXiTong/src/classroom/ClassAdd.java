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

public class ClassAdd extends JFrame {
    private JTextField d教室名;
    private JTextField d教学楼地址;
    private JComboBox<String> d教室类别;
    private JComboBox<String> d空闲状态;
    private JTextField d最大学生数;

    public ClassAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("添加教室数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel 教室名 = new JLabel("教室名:");
        d教室名 = new JTextField();

        JLabel 教学楼地址 = new JLabel("教学楼地址:");
        d教学楼地址 = new JTextField();

        JLabel 教室类别 = new JLabel("教室类别:");
        String[] types = {"普通教室", "多媒体教室", "实验室"};
        d教室类别 = new JComboBox<>(types);

        JLabel 空闲状态 = new JLabel("教室空闲状态:");
        String[] statuses = {"空闲", "非空闲"};
        d空闲状态 = new JComboBox<>(statuses);

        JLabel 最大学生数 = new JLabel("最大学生数:");
        d最大学生数 = new JTextField();

        JButton submitJB = new JButton("提交");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClassroomData();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Classroom(); // 返回教室表操作菜单
                dispose();
            }
        });

        panel.add(教室名);
        panel.add(d教室名);
        panel.add(教学楼地址);
        panel.add(d教学楼地址);
        panel.add(教室类别);
        panel.add(d教室类别);
        panel.add(空闲状态);
        panel.add(d空闲状态);
        panel.add(最大学生数);
        panel.add(d最大学生数);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void addClassroomData() {
        String 教室名 = d教室名.getText();
        String 教学楼地址 = d教学楼地址.getText();
        String 教室类别 = (String) d教室类别.getSelectedItem();
        boolean 空闲状态 = d空闲状态.getSelectedItem().equals("空闲");
        int 最大学生数;
        if (教室名.isEmpty() || 教学楼地址.isEmpty() || 教室类别.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            最大学生数 = Integer.parseInt(d最大学生数.getText());
            if (最大学生数 <= 0) {
                throw new NumberFormatException("最大学生数必须大于0");
            }

            // 创建数据源
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            // 建立数据库连接
            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            // 准备 SQL 语句
            String sql = "insert into 教室表 values (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, 教室名);
            statement.setInt(2, 最大学生数);
            statement.setString(3, 教学楼地址);
            statement.setString(4, 教室类别);
            statement.setBoolean(5, 空闲状态);

            // 执行更新操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已插入。");

            // 关闭资源
            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "最大学生数必须是一个正整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "插入失败，该教室号已存在或数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
