package Inspection;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;

public class InspectionFind extends JFrame {
    private static final GetSource source = new GetSource();
    private static final GetConnec connec = new GetConnec();

    private JTextField d设备id;
    private JTextField d检查员id;
    private JComboBox<String> d年;
    private JComboBox<String> d月;
    private JComboBox<String> d日;

    public InspectionFind() {
        findUI();
    }

    private void findUI() {
        setTitle("查找检查表数据");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel 设备idLabel = new JLabel("设备id:");
        d设备id = new JTextField();

        JLabel 检查员idLabel = new JLabel("检查员id:");
        d检查员id = new JTextField();

        JLabel 年Label = new JLabel("年:");
        d年 = new JComboBox<>();
        for (int year = Calendar.getInstance().get(Calendar.YEAR) - 10; year <= Calendar.getInstance().get(Calendar.YEAR) + 100; year++) {
            d年.addItem(String.valueOf(year));
        }

        JLabel 月Label = new JLabel("月:");
        d月 = new JComboBox<>();
        for (int month = 1; month <= 12; month++) {
            d月.addItem(String.valueOf(month));
        }

        JLabel 日Label = new JLabel("日:");
        d日 = new JComboBox<>(generateNumbers(1, 31)); // 初始化天数下拉框

        JButton submitJB = new JButton("查询");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    findInspection();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "查找操作出现异常: " + ex.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inspection();
                dispose();
            }
        });

        panel.add(设备idLabel);
        panel.add(d设备id);
        panel.add(检查员idLabel);
        panel.add(d检查员id);
        panel.add(年Label);
        panel.add(d年);
        panel.add(月Label);
        panel.add(d月);
        panel.add(日Label);
        panel.add(d日);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private String[] generateNumbers(int start, int end) {
        String[] numbers = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            numbers[i - start] = String.format("%02d", i);
        }
        return numbers;
    }

    private void findInspection() throws SQLException {
        String 设备idCur = d设备id.getText();
        String 检查员idCur = d检查员id.getText();

        if (设备idCur.isEmpty() || 检查员idCur.isEmpty() ||
                d年.getSelectedItem() == null || d月.getSelectedItem() == null ||
                d日.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "设备id、检查员id、日期不能为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int 设备id;
        int 检查员id;
        int 年 = Integer.parseInt((String) d年.getSelectedItem());
        int 月 = d月.getSelectedIndex() + 1;
        int 日 = Integer.parseInt((String) d日.getSelectedItem());

        try {
            设备id = Integer.parseInt(设备idCur);
            检查员id = Integer.parseInt(检查员idCur);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "设备id和检查员id必须是整数！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(年, 月 - 1, 日); // 设置检查时间

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            DataSource dataSource = source.getDataSource();
            connection = connec.getConnection(dataSource);

            statement = connection.prepareStatement("select * from 检查表 where 设备id = ? and 检查员id = ? and 检查时间 = ?");
            statement.setInt(1, 设备id);
            statement.setInt(2, 检查员id);
            statement.setDate(3, new Date(calendar.getTimeInMillis()));

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String result = "检查记录：" +
                        "\n设备id: " + resultSet.getInt("设备id") +
                        "\n检查员id: " + resultSet.getInt("检查员id") +
                        "\n检查时间: " + resultSet.getDate("检查时间") +
                        "\n设备状态: " + (resultSet.getBoolean("设备状态") ? "正常" : "异常");

                JOptionPane.showMessageDialog(null, result, "查询结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "未找到匹配数据", "查询结果", JOptionPane.INFORMATION_MESSAGE);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private int getMaxDays(int year, int month) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 28;
            }
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
