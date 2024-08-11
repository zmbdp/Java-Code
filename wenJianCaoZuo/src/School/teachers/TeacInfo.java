package School.teachers;

import javax.swing.*;
import java.awt.*;

public class TeacInfo extends JFrame {
    public TeacInfo() {
        setTitle("教师信息录入界面");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFrame jf = new JFrame("教师信息录入");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        JPanel jp4=new JPanel();
        JPanel jp5=new JPanel();
        JPanel jp6=new JPanel();
        JPanel jp7=new JPanel();

        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);
        jf.add(jp5);
        jf.add(jp6);
        jf.add(jp7);

        JLabel jl = new JLabel("院系:");
        JLabel jl2 = new JLabel("专业:");
        JLabel jl3 = new JLabel("工号:");
        JLabel jl4 = new JLabel("姓名:");
        JLabel jl5 = new JLabel("授课程:");
        JLabel jl6 = new JLabel("提示");

        JTextField jtf = new JTextField(15);
        JTextField jtf2 = new JTextField(15);
        JTextField jtf3 = new JTextField(15);
        JTextField jtf4 = new JTextField(15);
        JTextField jtf5 = new JTextField(15);


        JButton jb1 = new JButton("录入");


        jp1.add(jl);
        jp1.add(jtf);
        jp2.add(jl2);
        jp2.add(jtf2);
        jp3.add(jl3);
        jp3.add(jtf3);
        jp4.add(jl4);
        jp4.add(jtf4);
        jp5.add(jl5);
        jp5.add(jtf5);
        jp6.add(jb1);
        jp7.add(jl6);


        jf.setLayout(new GridLayout(8,1));
        jf.setBounds(100,100,400,300);
        jf.setVisible(true);

    }
}