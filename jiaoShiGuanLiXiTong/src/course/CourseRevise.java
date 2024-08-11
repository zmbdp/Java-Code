package course;

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
import java.util.Objects;

public class CourseRevise extends JFrame {
    private JTextField 老课程id; // 用于显示原始课程ID
    private JTextField 新课程id; // 用于输入新的课程ID
    private JTextField 新教室名;
    private JTextField 新教师id;
    private JTextField 新学生id;
    private JTextField 新课程名;
    private JComboBox<String> 新s年, 新s月, 新s日, 新s时, 新s分, 新s秒;
    private JComboBox<String> 新x年, 新x月, 新x日, 新x时, 新x分, 新x秒;

    public CourseRevise() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("修改课程");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中显示

        JPanel panel = new JPanel(new GridLayout(9, 2));

        panel.add(new JLabel("老课程id:"));
        老课程id = new JTextField();
        panel.add(老课程id);

        panel.add(new JLabel("新课程id:"));
        新课程id = new JTextField();
        panel.add(新课程id);

        panel.add(new JLabel("新教室名:"));
        新教室名 = new JTextField();
        panel.add(新教室名);

        panel.add(new JLabel("新教师id:"));
        新教师id = new JTextField();
        panel.add(新教师id);

        panel.add(new JLabel("新学生id:"));
        新学生id = new JTextField();
        panel.add(新学生id);

        panel.add(new JLabel("新课程名:"));
        新课程名 = new JTextField();
        panel.add(新课程名);

        panel.add(new JLabel("新上课时间:"));
        JPanel 新上课时间 = new JPanel(new GridLayout(1, 6));
        新s年 = new JComboBox<>(generateNumbers(YearMonth.now().getYear() - 10, YearMonth.now().getYear() + 100));
        新s月 = new JComboBox<>(generateNumbers(1, 12));
        新s日 = new JComboBox<>(generateNumbers(1, 31));
        新s时 = new JComboBox<>(generateNumbers(0, 23));
        新s分 = new JComboBox<>(generateNumbers(0, 59));
        新s秒 = new JComboBox<>(generateNumbers(0, 59));
        新上课时间.add(新s年);
        新上课时间.add(新s月);
        新上课时间.add(新s日);
        新上课时间.add(新s时);
        新上课时间.add(新s分);
        新上课时间.add(新s秒);
        panel.add(新上课时间);

        panel.add(new JLabel("新下课时间:"));
        JPanel 新下课时间 = new JPanel(new GridLayout(1, 6));
        新x年 = new JComboBox<>(generateNumbers(YearMonth.now().getYear() - 10, YearMonth.now().getYear() + 100));
        新x月 = new JComboBox<>(generateNumbers(1, 12));
        新x日 = new JComboBox<>(generateNumbers(1, 31));
        新x时 = new JComboBox<>(generateNumbers(0, 23));
        新x分 = new JComboBox<>(generateNumbers(0, 59));
        新x秒 = new JComboBox<>(generateNumbers(0, 59));
        新下课时间.add(新x年);
        新下课时间.add(新x月);
        新下课时间.add(新x日);
        新下课时间.add(新x时);
        新下课时间.add(新x分);
        新下课时间.add(新x秒);
        panel.add(新下课时间);

        // 监听年份和月份选择，动态更新日期选项
        新s年.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(新s年, 新s月, 新s日);
            }
        });
        新s月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(新s年, 新s月, 新s日);
            }
        });
        新x年.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(新x年, 新x月, 新x日);
            }
        });
        新x月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(新x年, 新x月, 新x日);
            }
        });

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reviseCourse();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Course(); // 返回课程表操作菜单
            }
        });

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

    private void updateDayComboBox(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day) {
        int 年 = Integer.parseInt((String) Objects.requireNonNull(year.getSelectedItem()));
        int 月 = Integer.parseInt((String) Objects.requireNonNull(month.getSelectedItem()));

        YearMonth yearMonthObject = YearMonth.of(年, 月);
        int 日 = yearMonthObject.lengthOfMonth();

        String[] daysArray = generateNumbers(1, 日);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(daysArray);
        day.setModel(model);
    }

    public void reviseCourse() {
        if (isInputValid()) {
            GetSource getSource = new GetSource();
            GetConnec getConnec = new GetConnec();
            try (Connection conn = getConnec.getConnection(getSource.getDataSource())) {
                String sql = "update 课程表 set 课程id = ?, 教室名 = ?, 教师id = ?, 学生id = ?, 课程名 = ?, 上课时间 = ?, 下课时间 = ? where 课程id = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, Integer.parseInt(新课程id.getText())); // 使用新的课程ID
                    statement.setString(2, 新教室名.getText());
                    statement.setInt(3, Integer.parseInt(新教师id.getText()));
                    statement.setInt(4, Integer.parseInt(新学生id.getText()));
                    statement.setString(5, 新课程名.getText());
                    statement.setString(6, getFormattedDate(新s年, 新s月, 新s日, 新s时, 新s分, 新s秒));
                    statement.setString(7, getFormattedDate(新x年, 新x月, 新x日, 新x时, 新x分, 新x秒));
                    statement.setInt(8, Integer.parseInt(老课程id.getText())); // WHERE clause使用原始课程ID
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "课程修改成功！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "数据库错误：" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "请完整填写所有字段！");
        }
    }

    private boolean isInputValid() {
        return !新课程id.getText().isEmpty() &&
                !新教室名.getText().isEmpty() &&
                !新教师id.getText().isEmpty() &&
                !新学生id.getText().isEmpty() &&
                !新课程名.getText().isEmpty();
    }

    private String getFormattedDate(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day, JComboBox<String> hour, JComboBox<String> minute, JComboBox<String> second) {
        return String.format("%s-%s-%s %s:%s:%s",
                year.getSelectedItem(),
                month.getSelectedItem(),
                day.getSelectedItem(),
                hour.getSelectedItem(),
                minute.getSelectedItem(),
                second.getSelectedItem());
    }
}
