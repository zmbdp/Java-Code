package School;
import School.students.Student;
import School.teachers.Teacher;

import javax.swing.*;
import java.awt.*;

public class AHXSchoolManageSystem extends JFrame {
    private JButton studentButton;
    private JButton teacherButton;

    public AHXSchoolManageSystem() {
        initUI();
    }

    private void initUI() {

        setTitle("学校管理系统");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentButton = new JButton("学生");
        studentButton.addActionListener(e -> new Student().addInformation());

        teacherButton = new JButton("教师");
        teacherButton.addActionListener(e -> new Teacher().addInformation());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(studentButton);
        panel.add(teacherButton);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AHXSchoolManageSystem();


    }
}