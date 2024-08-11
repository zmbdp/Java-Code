package censor;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CensorDel extends JFrame {
    private JTextField idField;

    public CensorDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除检查员数据");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出程序

        // 设置窗口居中显示
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("检查员id:");
        idField = new JTextField();

        JButton submitJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCensor();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Censor();
                dispose();
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void deleteCensor() {
        String id = idField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入检查员id！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idInt = Integer.parseInt(id);

            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            Connection connection = null;
            PreparedStatement statement = null;

            try {
                GetConnec getConnec = new GetConnec();
                connection = getConnec.getConnection(source);

                String sql = "delete from 检查员表 where 检查员id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idInt);

                int n = statement.executeUpdate();
                JOptionPane.showMessageDialog(this, n + " 条记录已删除。");

            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "检查员id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "删除数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
