package student;

import mainBao.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame {
    public Student() {
        studentUI();
    }

    private void studentUI() {
        setTitle("学生表操作");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("请选择学生表的操作：");
        panel.add(label);

        JButton addJB = new JButton("增加数据");
        JButton deleteJB = new JButton("删除数据");
        JButton searchJB = new JButton("查找数据");
        JButton updateJB = new JButton("修改数据");
        JButton retJB = new JButton("返回主菜单");

        addJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentAdd(); // 打开增加数据的窗体
                dispose();
            }
        });

        deleteJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDel(); // 打开删除数据的窗体
                dispose();
            }
        });

        searchJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentFind(); // 打开查找数据的窗体
                dispose();
            }
        });

        updateJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRevise(); // 打开修改数据的窗体
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

        setVisible(true);
    }
}
