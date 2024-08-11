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

public class InspectionRevise extends JFrame {
    private static final GetSource source = new GetSource();
    private static final GetConnec connec = new GetConnec();

    private JTextField d设备id;
    private JTextField newD设备id;
    private JTextField d检查员id;
    private JTextField d新检查员id;
    private JComboBox<String> d年;
    private JComboBox<String> d月;
    private JComboBox<String> d日;
    private JComboBox<String> d新年;
    private JComboBox<String> d新月;
    private JComboBox<String> d新日;
    private JComboBox<String> d设备状态;

    public InspectionRevise() {
        reviseUI();
    }

    private void reviseUI() {
        setTitle("修改检查表数据");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));

        JLabel 设备id = new JLabel("设备id:");
        d设备id = new JTextField();

        JLabel new设备id = new JLabel("新设备id:");
        newD设备id = new JTextField();

        JLabel 检查员id = new JLabel("检查员id:");
        d检查员id = new JTextField();

        JLabel 新检查员id = new JLabel("新检查员id:");
        d新检查员id = new JTextField();

        JLabel 年 = new JLabel("年:");
        d年 = new JComboBox<>();
        for (int year = YearMonth.now().getYear() - 10; year <= YearMonth.now().getYear() + 100; year++) {
            d年.addItem(String.valueOf(year));
        }
        d年.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update日期列表();
            }
        });

        JLabel 月 = new JLabel("月:");
        d月 = new JComboBox<>();
        d月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update日期列表();
            }
        });

        JLabel 日 = new JLabel("日:");
        d日 = new JComboBox<>();

        JLabel 新年 = new JLabel("新年:");
        d新年 = new JComboBox<>();
        for (int year = YearMonth.now().getYear() - 10; year <= YearMonth.now().getYear() + 100; year++) {
            d新年.addItem(String.valueOf(year));
        }
        d新年.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update新日期列表();
            }
        });

        JLabel 新月 = new JLabel("新月:");
        d新月 = new JComboBox<>();
        d新月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update新日期列表();
            }
        });

        JLabel 新日 = new JLabel("新日:");
        d新日 = new JComboBox<>();

        JLabel 设备状态 = new JLabel("设备状态:");
        String[] 设状Array = {"正常", "异常"};
        d设备状态 = new JComboBox<>(设状Array);

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reviseInspection();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inspection();
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

        panel.add(new设备id);
        panel.add(newD设备id);
        panel.add(新检查员id);
        panel.add(d新检查员id);

        panel.add(新年);
        panel.add(d新年);
        panel.add(新月);
        panel.add(d新月);
        panel.add(新日);
        panel.add(d新日);

        panel.add(设备状态);
        panel.add(d设备状态);

        panel.add(submitJB);
        panel.add(retJB);

        // 调整更新方法的调用顺序
        update月份列表();
        update日期列表();

        update新月份列表();
        update新日期列表();

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void update月份列表() {
        d月.removeAllItems();
        for (int month = 1; month <= 12; month++) {
            d月.addItem(String.valueOf(month));
        }
        update日期列表();
    }

    private void update日期列表() {
        d日.removeAllItems();
        int selectedYear = Integer.parseInt((String) d年.getSelectedItem());
        int selectedMonth = d月.getSelectedIndex() + 1;
        int maxDays = getMaxDays(selectedYear, selectedMonth);
        for (int day = 1; day <= maxDays; day++) {
            d日.addItem(String.valueOf(day));
        }
    }

    private void update新月份列表() {
        d新月.removeAllItems();
        for (int month = 1; month <= 12; month++) {
            d新月.addItem(String.valueOf(month));
        }
        update新日期列表();
    }

    private void update新日期列表() {
        d新日.removeAllItems();
        int selectedYear = Integer.parseInt((String) d新年.getSelectedItem());
        int selectedMonth = d新月.getSelectedIndex() + 1;
        int maxDays = getMaxDays(selectedYear, selectedMonth);
        for (int day = 1; day <= maxDays; day++) {
            d新日.addItem(String.valueOf(day));
        }
    }

    private void reviseInspection() {
        // 获取当前设备id和检查员id
        String 老设备id = d设备id.getText();
        String 老检查员id = d检查员id.getText();

        // 检查设备id和检查员id是否为空
        if (老设备id.isEmpty() || 老检查员id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "设备id和检查员id不能为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int 设备id;
        try {
            设备id = Integer.parseInt(newD设备id.getText().isEmpty() ? 老设备id : newD设备id.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "设备id必须是数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int 检查员;
        try {
            检查员 = Integer.parseInt(d新检查员id.getText().isEmpty() ? 老检查员id : d新检查员id.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "检查员id必须是数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 检查年、月、日、设备状态是否为空
        if (d年.getSelectedItem() == null || d月.getSelectedItem() == null || d日.getSelectedItem() == null || d设备状态.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "日期和设备状态不能为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (d新年.getSelectedItem() == null || d新月.getSelectedItem() == null || d新日.getSelectedItem() == null) {
            d新年 = d年;
            d新月 = d月;
            d新日 = d日;
        }

        int 年 = Integer.parseInt((String) d新年.getSelectedItem());
        int 月 = d新月.getSelectedIndex() + 1;
        int 日 = Integer.parseInt((String) d新日.getSelectedItem());

        int cur年 = Integer.parseInt((String) d年.getSelectedItem());
        int cur月 = d月.getSelectedIndex() + 1;
        int cur日 = Integer.parseInt((String) d日.getSelectedItem());

        // //

        boolean 设备状态 = d设备状态.getSelectedItem().equals("正常");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(年, 月 - 1, 日); // 月份从0开始，所以要减去1
        Calendar calendar2 = Calendar.getInstance();

        calendar2.set(cur年, cur月 - 1, cur日);
        try (Connection conn = connec.getConnection(source.getDataSource());
             PreparedStatement stmt = conn.prepareStatement("update 检查表 set 设备id = ?, 检查员id = ?, 检查时间 = ?, 设备状态 = ? where 设备id = ? and 检查员id = ? and 检查时间 = ?")) {
            stmt.setInt(1, 设备id);
            stmt.setInt(2, 检查员);
            stmt.setDate(3, new java.sql.Date(calendar1.getTimeInMillis()));
            stmt.setBoolean(4, 设备状态);

            stmt.setInt(5, Integer.parseInt(老设备id));
            stmt.setInt(6, Integer.parseInt(老检查员id));
            stmt.setDate(7, new java.sql.Date(calendar2.getTimeInMillis())); // 使用检查时间作为条件

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "数据修改成功");
            } else {
                JOptionPane.showMessageDialog(null, "未找到匹配数据");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据修改失败：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
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
