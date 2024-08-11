package myGUI;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame("super");
        jFrame.setSize(300, 300);// 设置大小
        jFrame.setLocation(300, 300);// 设置位置
        //jFrame.setBounds(a, b, width, height);// 设置位置，宽高
        jFrame.setVisible(true);// 设置窗口为可见
        jFrame.setResizable(false);// 设置窗口为不可调整

        JDialog jDialog = new JDialog(jFrame, "erZi");
        jDialog.setBounds(300, 250, 250, 250);
        jDialog.setVisible(true);

        // 添加按钮
        JButton jb1 = new JButton("按钮1");
        JButton jb2 = new JButton("按钮2");

        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.add(jb1);
        jPanel.add(jb2);

        jFrame.add(jPanel);

        jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
