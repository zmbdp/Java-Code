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
import java.util.stream.IntStream;

public class InspectionDel extends JFrame {
    private static final GetSource source = new GetSource();
    private static final GetConnec connec = new GetConnec();
    private JTextField d设备id;
    private JTextField d检查员id;
    private JComboBox<Integer> 年份列表;
    private JComboBox<Integer> 月份列表;
    private JComboBox<Integer> 日期列表;

    public InspectionDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除检查表数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出当前窗体

        setLocationRelativeTo(null); // 设置窗口居中显示

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel 设备id = new JLabel("设备id:");
        d设备id = new JTextField(15);

        JLabel 检查员id = new JLabel("检查员id:");
        d检查员id = new JTextField(15);

        JLabel 检查时间 = new JLabel("检查时间:");
        年份列表 = new JComboBox<>();
        月份列表 = new JComboBox<>();
        日期列表 = new JComboBox<>();

        JLabel 年 = new JLabel("年:");
        JLabel 月 = new JLabel("月:");
        JLabel 日 = new JLabel("日:");

        // 填充年份下拉列表
        IntStream.range(YearMonth.now().getYear() - 10, YearMonth.now().getYear() + 100)
                .forEach(年份列表::addItem);

        // 设置月份列表监听器，根据选择的年份更新月份和日期列表
        年份列表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update月份列表();
            }
        });

        // 设置日期列表监听器，根据选择的年份和月份更新日期列表
        月份列表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update日期列表();
            }
        });

        JButton submitJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteInspectionData();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inspection();
                dispose();
            }
        });

        // 添加组件到面板中，使用GridBagConstraints控制布局
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(设备id, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(d设备id, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(检查员id, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(d检查员id, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(检查时间, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(年, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(年份列表, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(月, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(月份列表, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(日, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        panel.add(日期列表, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(submitJB, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        panel.add(retJB, constraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true); // 确保窗体可见
    }

    private void update月份列表() {
        Object selectedYearObj = 年份列表.getSelectedItem();
        if (selectedYearObj == null) {
            return; // 如果没有选中任何年份，直接返回，不执行后续逻辑
        }

        int year = (int) selectedYearObj;
        月份列表.removeAllItems();
        IntStream.rangeClosed(1, 12).forEach(月份列表::addItem);
    }

    private void update日期列表() {
        Object selectedYearObj = 年份列表.getSelectedItem();
        if (selectedYearObj == null) {
            return; // 如果没有选中任何年份，直接返回，不执行后续逻辑
        }

        int year = (int) selectedYearObj;
        Object selectedMonthObj = 月份列表.getSelectedItem();
        if (selectedMonthObj == null) {
            return; // 如果没有选中任何月份，直接返回，不执行后续逻辑
        }

        int month = (int) selectedMonthObj;

        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        日期列表.removeAllItems();
        IntStream.rangeClosed(1, daysInMonth).forEach(日期列表::addItem);
    }


    private void deleteInspectionData() {
        String 设备cur = d设备id.getText();
        String 检查员cur = d检查员id.getText();
        int 年份 = (int) 年份列表.getSelectedItem();
        int 月份 = (int) 月份列表.getSelectedItem();
        int 日期 = (int) 日期列表.getSelectedItem();

        if (设备cur.isEmpty() || 检查员cur.isEmpty()) {
            JOptionPane.showMessageDialog(null, "数据不可为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int 设备id = Integer.parseInt(设备cur);
        int 检查员id = Integer.parseInt(检查员cur);

        try (
                Connection connection = connec.getConnection(source.getDataSource());
                PreparedStatement statement = connection.prepareStatement(
                        "delete from 检查表 where 设备id = ? and 检查员id = ? and 检查时间 = ?")) {
            statement.setInt(1, 设备id);
            statement.setInt(2, 检查员id);
            statement.setDate(3, java.sql.Date.valueOf(年份 + "-" + 月份 + "-" + 日期));
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "数据删除成功");
            } else {
                JOptionPane.showMessageDialog(null, "未找到匹配数据");
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "数据删除失败：" + ex.getMessage(),
                    "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
