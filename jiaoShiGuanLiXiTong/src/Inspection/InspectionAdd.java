package Inspection;

import Information.GetConnec;
import Information.GetSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.Calendar;

public class InspectionAdd extends JFrame {
    private JTextField d设备id;
    private JTextField d检查员id;
    private JComboBox<String> d年;
    private JComboBox<String> d月;
    private JComboBox<String> d日;
    private JComboBox<String> d设备状态;

    private static final GetSource source = new GetSource();
    private static final GetConnec connec = new GetConnec();

    public InspectionAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("增加检查表数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        setLocationRelativeTo(null); // 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2)); // 增加间距

        JLabel 设备id = new JLabel("设备id:");
        d设备id = new JTextField();

        JLabel 检查员id = new JLabel("检查员id:");
        d检查员id = new JTextField();

        JLabel 年 = new JLabel("年:");
        d年 = new JComboBox<>();
        for (int year = YearMonth.now().getYear() - 10; year <= YearMonth.now().getYear() + 100; year++) {
            d年.addItem(String.valueOf(year));
        }

        JLabel 月 = new JLabel("月:");
        d月 = new JComboBox<>();
        for (int month = 1; month <= 12; month++) {
            d月.addItem(String.valueOf(month));
        }

        JLabel 日 = new JLabel("日:");
        d日 = new JComboBox<>();
        updateDaysComboBox(); // 初始化天数下拉框

        JLabel 设备状态 = new JLabel("设备状态:");
        String[] statusOptions = {"正常", "异常"};
        d设备状态 = new JComboBox<>(statusOptions);

        JButton submitJB = new JButton("提交");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInspectionData();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inspection(); // 返回检查表操作菜单
                dispose();
            }
        });

        panel.add(设备id);
        panel.add(d设备id);
        panel.add(检查员id);
        panel.add(d检查员id);
        panel.add(年);
        panel.add(d年);
        panel.add(月);
        panel.add(d月);
        panel.add(日);
        panel.add(d日);
        panel.add(设备状态);
        panel.add(d设备状态);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    // 更新天数下拉框的方法
    private void updateDaysComboBox() {
        d月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedYear = Integer.parseInt((String) d年.getSelectedItem());
                int selectedMonth = Integer.parseInt((String) d月.getSelectedItem());
                int maxDays = getMaxDays(selectedYear, selectedMonth);
                d日.removeAllItems();
                for (int day = 1; day <= maxDays; day++) {
                    d日.addItem(String.valueOf(day));
                }
            }
        });

        // 初始化时也更新天数
        int selectedYear = Integer.parseInt((String) d年.getSelectedItem());
        int selectedMonth = Integer.parseInt((String) d月.getSelectedItem());
        int maxDays = getMaxDays(selectedYear, selectedMonth);
        d日.removeAllItems();
        for (int day = 1; day <= maxDays; day++) {
            d日.addItem(String.valueOf(day));
        }
    }

    // 获取指定月份的最大天数，考虑闰年
    private int getMaxDays(int year, int month) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else {
            switch (month) {
                case 1:
                    return 31;
                case 3:
                    return 31;
                case 5:
                    return 31;
                case 7:
                    return 31;
                case 8:
                    return 31;
                case 10:
                    return 31;
                case 12:
                    return 31;
                case 2:
                    return 28;
                default:
                    return 30;
            }
        }
    }

    // 判断是否为闰年
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void addInspectionData() {
        // 判断是否为空
        String 设备Cur = d设备id.getText();
        String 检查员cur = d检查员id.getText();
        String 年cur = (String) d年.getSelectedItem();
        String 月cur = (String) d月.getSelectedItem();
        String 日cur = (String) d日.getSelectedItem();

        if (设备Cur.isEmpty() || 检查员cur.isEmpty() || 年cur.isEmpty() || 月cur.isEmpty() || 日cur.isEmpty()) {
            JOptionPane.showMessageDialog(null, "数据不可为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int 设备id = Integer.parseInt(设备Cur);
        int 检查员id = Integer.parseInt(检查员cur);
        int 年 = Integer.parseInt(年cur);
        int 月 = Integer.parseInt(月cur);
        int 日 = Integer.parseInt(日cur);
        boolean 设备状态 = d设备状态.getSelectedItem().equals("正常");

        Calendar calendar = Calendar.getInstance();
        calendar.set(年, 月 - 1, 日);

        try (Connection conn = connec.getConnection(source.getDataSource());
             PreparedStatement stmt = conn.prepareStatement("insert into 检查表 values (?, ?, ?, ?)")) {
            stmt.setInt(1, 设备id);
            stmt.setInt(2, 检查员id);
            stmt.setDate(3, new java.sql.Date(calendar.getTimeInMillis()));
            stmt.setBoolean(4, 设备状态);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "数据添加成功");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据添加失败：" + ex.getMessage(),
                    "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
