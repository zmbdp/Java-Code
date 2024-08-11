package mainBao;

import initialize.DatabaseInitialize;
import initialize.Initialize;
import password.PasswordInput;
import password.PasswordCallback;

import javax.swing.*;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        // 使用多线程，假设用户端很多
        executorService.submit(() -> {
            SwingUtilities.invokeLater(() -> {
                // 创建密码输入窗口
                new PasswordInput(new PasswordCallback() {
                    @Override
                    public void onPasswordCorrect() {
                        // 密码正确，初始化数据库并显示主菜单
                        SwingUtilities.invokeLater(() -> {
                            try {
                                // 先创建数据库
                                new DatabaseInitialize();
                                // 再创建表
                                new Initialize();
                                // 打印主菜单
                                new MainMenu();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "数据库初始化失败：" + e.getMessage(),
                                        "错误", JOptionPane.ERROR_MESSAGE);
                            }
                        });
                    }
                });
            });
        });


        /*Thread t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> {
                // 创建密码输入窗口
                PasswordInput passwordInput = new PasswordInput(new PasswordCallback() {
                    @Override
                    public void onPasswordCorrect() {
                        // 密码正确，初始化数据库并显示主菜单
                        try {
                            new Initialize();
                            // 打印主菜单
                            new MainMenu();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "数据库初始化失败：" + e.getMessage(),
                                    "错误", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // 显示密码输入窗口
                passwordInput.setVisible(true);
            });
            t2.start();
        });
        t1.start();*/
    }
}
