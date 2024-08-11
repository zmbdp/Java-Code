package course;


import mainBao.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Course extends JFrame {
    public Course() {
        inspectionUI();
    }

    private void inspectionUI() {
        setTitle("课程表操作");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("请选择检查表的操作：");
        panel.add(label);

        JButton addJB = new JButton("增加数据");
        JButton deleteJB = new JButton("删除数据");
        JButton searchJB = new JButton("查找数据");
        JButton updateJB = new JButton("修改数据");
        JButton retJB = new JButton("返回主菜单");

        addJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CourseAdd(); // 打开增加数据的窗体
                dispose(); // 关闭当前窗体
            }
        });

        deleteJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CourseDel();// 打开删除数据的窗体
                dispose();
            }
        });

        searchJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现查找数据逻辑
                new CourseFind();
                dispose();
            }
        });

        updateJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现修改数据逻辑
                new CourseRevise();
                dispose();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(); // 返回主菜单
                dispose();
            }
        });

        panel.add(addJB);
        panel.add(deleteJB);
        panel.add(searchJB);
        panel.add(updateJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true); // 确保窗体可见
    }
}
