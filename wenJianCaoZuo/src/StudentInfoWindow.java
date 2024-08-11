import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoWindow {
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("学生信息");

        // 创建面板
        JPanel panel = new JPanel();

        // 创建标签和文本框
        JLabel label1 = new JLabel("院系：");
        JTextField textField1 = new JTextField(20);
        JLabel label2 = new JLabel("专业：");
        JTextField textField2 = new JTextField(20);
        JLabel label3 = new JLabel("班级：");
        JTextField textField3 = new JTextField(20);
        JLabel label4 = new JLabel("学号：");
        JTextField textField4 = new JTextField(20);
        JLabel label5 = new JLabel("姓名：");
        JTextField textField5 = new JTextField(20);

        // 创建提交和取消按钮
        JButton submitButton = new JButton("提交");
        JButton cancelButton = new JButton("取消");

        // 给取消按钮添加监听器
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 退出应用程序
            }
        });

        // 将标签、文本框和按钮添加到面板
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(submitButton);
        panel.add(cancelButton);

        // 将面板添加到窗口
        frame.add(panel);

        // 设置窗口大小和可见性
        frame.setSize(300, 210);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
