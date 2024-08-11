import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordInputForm extends JFrame {
    private JPasswordField passwordField;
    private JButton submitButton;

    public PasswordInputForm() {
        setTitle("输入密码");
        setSize(300, 150); // 调整窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10)); // 使用 FlowLayout 并设置间距

        JLabel label = new JLabel("请输入密码:");
        passwordField = new JPasswordField(15); // 设置密码框大小
        passwordField.setPreferredSize(new Dimension(150, 25)); // 设置密码框的首选大小

        submitButton = new JButton("确认");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                // TODO: 处理密码逻辑，例如验证密码等
                System.out.println("输入的密码是：" + password);
                // 清空密码框
                passwordField.setText("");
            }
        });

        panel.add(label);
        panel.add(passwordField);
        panel.add(submitButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordInputForm();
            }
        });
    }
}
