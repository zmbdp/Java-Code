package password;

import Information.GetConnec;
import Information.GetPassword;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class PasswordInput extends JFrame {
    private JPasswordField passwordField;
    private int attemptCount = 0;
    private static final int MAX_ATTEMPTS = 3;
    private PasswordCallback callback;

    public PasswordInput(PasswordCallback callback) {
        this.callback = callback;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("密码输入");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// 设置窗口居中显示

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));// 设置间距

        JLabel label = new JLabel("请输入数据库密码:");
        passwordField = new JPasswordField(15);// 设置密码框大小
        passwordField.setPreferredSize(new Dimension(50, 20));// 设置密码框的首选大小

        JButton submitJB = new JButton("提交");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptConnection();
            }
        });

        panel.add(label);
        panel.add(passwordField);
        panel.add(submitJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    int i = 3;
    private void attemptConnection() {
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        GetSource getSource = new GetSource();
        Connection connection = null;
        try {
            DataSource source = getSource.getDataSource(password);
            GetConnec getConnec = new GetConnec();
            connection = getConnec.getConnection(source);

            // 连接成功
            JOptionPane.showMessageDialog(this, "连接成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            GetPassword.password = password;
            callback.onPasswordCorrect();
            dispose(); // 关闭密码输入窗口
        } catch (SQLException e) {
            attemptCount++;
            if (attemptCount >= MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(this, "尝试次数过多，程序将退出。", "错误", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "密码错误，请重试。", "还有" + --i + "次机会", JOptionPane.ERROR_MESSAGE);
                passwordField.setText(""); // 清空密码框
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 清除密码字符数组
            Arrays.fill(passwordChars, '0');
        }
    }
}
