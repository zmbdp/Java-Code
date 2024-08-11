package mainBao;

import Inspection.Inspection;
import censor.Censor;
import classroom.Classroom;
import course.Course;
import courseView.CourseView;
import equipment.Equipment;
import student.Student;
import teacher.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainMenu extends JFrame {

    public MainMenu() {
        mainMenuUI();
    }

    private void mainMenuUI() {
        setTitle("主菜单");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel JL = new JLabel("                请选择操作图表 >>");
        panel.add(JL);

        JButton 学生表 = new JButton("学生表");
        JButton 教室表 = new JButton("教室表");
        JButton 教师表 = new JButton("教师表");
        JButton 检查员表 = new JButton("检查员表");
        JButton 检查表 = new JButton("检查表");
        JButton 设备表 = new JButton("设备表");
        JButton 课程表 = new JButton("课程表");
        JButton 查看视图 = new JButton("课程安排表");
        JButton 退出 = new JButton("退出");

        学生表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开学生表操作窗体
                new Student();
                dispose();
            }
        });
        教室表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Classroom(); // 打开教室表操作窗体
                dispose();
            }
        });

        教师表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Teacher(); // 打开教师表操作窗体
                dispose();
            }
        });

        检查员表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Censor(); // 打开检查员表操作窗体
                dispose();
            }
        });

        检查表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inspection(); // 打开检查表操作窗体
                dispose();
            }
        });

        设备表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Equipment();// 打开设备表操作窗体
                dispose();
            }
        });

        课程表.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Course();// 打开课程表操作窗体
                dispose();
            }
        });

        查看视图.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CourseView();// 打开视图操作窗体
                } catch (SQLException ex) {
                    e.paramString();
                }
                dispose();
            }
        });


        退出.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "程序将退出。", "警告", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });

        panel.add(学生表);
        panel.add(教室表);
        panel.add(教师表);
        panel.add(检查员表);
        panel.add(设备表);
        panel.add(检查表);
        panel.add(课程表);
        panel.add(查看视图);
        panel.add(退出);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true); // 确保窗体可见
    }
}
