package School.students;

import javax.swing.*;
import java.awt.*;

public class StuInfo extends JFrame {
    public StuInfo() {
        setTitle("学生信息录入界面");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFrame jf = new JFrame("学生信息录入");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        JPanel jp4=new JPanel();
        JPanel jp5=new JPanel();
        JPanel jp6=new JPanel();
        JPanel jp7=new JPanel();
        JPanel jp8=new JPanel();

        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);
        jf.add(jp5);
        jf.add(jp6);
        jf.add(jp7);
        jf.add(jp8);

        JLabel jl = new JLabel("院系:");
        JLabel jl2 = new JLabel("专业:");
        JLabel jl3 = new JLabel("班级:");
        JLabel jl4 = new JLabel("学号:");
        JLabel jl5 = new JLabel("姓名:");
        JLabel jl6 = new JLabel("年龄:");
        JLabel jl7 = new JLabel("提示");

        JTextField jtf = new JTextField(15);
        JTextField jtf2 = new JTextField(15);
        JTextField jtf3 = new JTextField(15);
        JTextField jtf4 = new JTextField(15);
        JTextField jtf5 = new JTextField(15);
        JTextField jtf6 = new JTextField(15);


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
        jp6.add(jl6);
        jp6.add(jtf6);
        jp7.add(jb1);
        jp8.add(jl7);

        jf.setLayout(new GridLayout(8,1));
        jf.setBounds(100,100,400,300);
        jf.setVisible(true);
    }
}