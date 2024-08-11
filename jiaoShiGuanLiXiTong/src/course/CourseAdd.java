package course;

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
import java.time.YearMonth;

public class CourseAdd extends JFrame {
    private JTextField 课程id;
    private JTextField 教室名;
    private JTextField 教师id;
    private JTextField 学生id;
    private JTextField 课程名;
    private JComboBox<String> s年, s月, s日, s时, s分, s秒;
    private JComboBox<String> x年, x月, x日, x时, x分, x秒;

    public CourseAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("添加课程");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中显示

        JPanel panel = new JPanel(new GridLayout(8, 2));

        panel.add(new JLabel("课程id:"));
        课程id = new JTextField();
        panel.add(课程id);

        panel.add(new JLabel("教室名:"));
        教室名 = new JTextField();
        panel.add(教室名);

        panel.add(new JLabel("教师id:"));
        教师id = new JTextField();
        panel.add(教师id);

        panel.add(new JLabel("学生id:"));
        学生id = new JTextField();
        panel.add(学生id);

        panel.add(new JLabel("课程名:"));
        课程名 = new JTextField();
        panel.add(课程名);

        panel.add(new JLabel("上课时间(年月日时分秒):"));
        JPanel 上课时间 = new JPanel(new GridLayout(1, 6));
        s年 = new JComboBox<>(generateNumbers(YearMonth.now().getYear() - 10, YearMonth.now().getYear() + 100));
        s月 = new JComboBox<>(generateNumbers(1, 12));
        s日 = new JComboBox<>(generateNumbers(1, 31)); // 初始设为31天，后续根据年月动态更新
        s时 = new JComboBox<>(generateNumbers(0, 23));
        s分 = new JComboBox<>(generateNumbers(0, 59));
        s秒 = new JComboBox<>(generateNumbers(0, 59));
        上课时间.add(s年);
        上课时间.add(s月);
        上课时间.add(s日);
        上课时间.add(s时);
        上课时间.add(s分);
        上课时间.add(s秒);
        panel.add(上课时间);

        panel.add(new JLabel("下课时间(年月日时分秒):"));
        JPanel 下课时间 = new JPanel(new GridLayout(1, 6));
        x年 = new JComboBox<>(generateNumbers(YearMonth.now().getYear() - 10, YearMonth.now().getYear() + 100));
        x月 = new JComboBox<>(generateNumbers(1, 12));
        x日 = new JComboBox<>(generateNumbers(1, 31));
        x时 = new JComboBox<>(generateNumbers(0, 23));
        x分 = new JComboBox<>(generateNumbers(0, 59));
        x秒 = new JComboBox<>(generateNumbers(0, 59));
        下课时间.add(x年);
        下课时间.add(x月);
        下课时间.add(x日);
        下课时间.add(x时);
        下课时间.add(x分);
        下课时间.add(x秒);
        panel.add(下课时间);

        // 监听年份和月份选择，动态更新日期选项
        s年.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(s年, s月, s日);
            }
        });
        s月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(s年, s月, s日);
            }
        });
        x年.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(x年, x月, x日);
            }
        });
        x月.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDayComboBox(x年, x月, x日);
            }
        });

        JButton submitJB = new JButton("添加");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourse();
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

    private void updateDayComboBox(JComboBox<String> yearComboBox, JComboBox<String> monthComboBox, JComboBox<String> dayComboBox) {
        int year = Integer.parseInt((String) yearComboBox.getSelectedItem());
        int month = Integer.parseInt((String) monthComboBox.getSelectedItem());

        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        String[] daysArray = generateNumbers(1, daysInMonth);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(daysArray);
        dayComboBox.setModel(model);
    }

    public void addCourse() {
        if (isInputValid()) {
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();
            GetConnec getConnec = new GetConnec();
            try (Connection connection = getConnec.getConnection(source)) {
                String sql = "insert into 课程表 values (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, Integer.parseInt(课程id.getText()));
                    statement.setString(2, 教室名.getText());
                    statement.setInt(3, Integer.parseInt(教师id.getText()));
                    statement.setInt(4, Integer.parseInt(学生id.getText()));
                    statement.setString(5, 课程名.getText());
                    statement.setString(6, getFormattedDate(s年, s月, s日, s时, s分, s秒));
                    statement.setString(7, getFormattedDate(x年, x月, x日, x时, x分, x秒));
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "课程添加成功！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "数据库错误：" + "教室名/教师id/学生id已存在 或数据库错误！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "请完整填写所有字段！");
        }
    }

    private boolean isInputValid() {
        return !课程id.getText().isEmpty() &&
                !教室名.getText().isEmpty() &&
                !教师id.getText().isEmpty() &&
                !学生id.getText().isEmpty() &&
                !课程名.getText().isEmpty();
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
