package School.students;

import School.SchoolManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Student implements SchoolManager {
    private String major;
    private String className;
    private String specialty;
    private String studentNumber;
    private String name;
    private int age;

    public Student () {}

    @Override
    public void showInformation() {
        System.out.println("院系: " + major);
        System.out.println("专业: " + specialty);
        System.out.println("班级: " + className);
        System.out.println("学号: " + studentNumber);
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
    }

    @Override
    public void addInformation() {
        JFrame jf = new JFrame("学生信息录入");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jb1.addActionListener(e -> {
            if (jtf.getText().isEmpty() || jtf2.getText().isEmpty() || jtf3.getText().isEmpty()
                    || jtf4.getText().isEmpty() || jtf5.getText().isEmpty() || jtf6.getText().isEmpty()) {
                jl7.setText("请填写所有信息");
            }
            else {
                major = jtf.getText();
                className = jtf2.getText();
                specialty = jtf3.getText();
                studentNumber = jtf4.getText();
                name = jtf5.getText();
                age = Integer.parseInt(jtf6.getText());;
                try {
                    saveToFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                jl7.setText("已录入");
                jf.revalidate();
                jf.repaint();
            }
        });

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

        jf.setLayout(new GridLayout(8, 1));
        jf.setSize(400, 300);
        jf.setVisible(true);
    }

    private void saveToFile() throws IOException {
        File file = new File("d:/student.txt");
        file.createNewFile();
        try (
                FileWriter writer = new FileWriter(file, true);

        ) {
            writer.write("院系：" + this.major + "；专业：" +
                    this.className + "；班级：" +
                    this.specialty + "；学号：" +
                    this.studentNumber + "；姓名：" +
                    this.name + "；年龄" +
                    this.age + "\n");
            System.out.println("学生信息保存成功.");
        } catch (IOException ex) {
            System.out.println("学生信息保存失败: " + ex.getMessage());

        }
    }
}