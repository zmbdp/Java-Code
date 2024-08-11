package equipment;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentRevise extends JFrame {
    private JTextField d老设备id;
    private JTextField d新设备id;
    private JTextField d新教室名;
    private JTextField d新设备名;
    private JComboBox<String> d新设备类型;
    private JTextField d新使用记录;

    public EquipmentRevise() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("修改设备数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel 老设备id = new JLabel("设备id:");
        d老设备id = new JTextField();

        JLabel 新设备id = new JLabel("新设备id:");
        d新设备id = new JTextField();

        JLabel 新教室名 = new JLabel("新教室名:");
        d新教室名 = new JTextField();

        JLabel 新设备名 = new JLabel("新设备名:");
        d新设备名 = new JTextField();

        JLabel 新设备类型 = new JLabel("新设备类型:");
        String[] newType = {"电子设备", "木制设备", "铁制设备", "其他设备"};
        d新设备类型 = new JComboBox<>(newType);

        JLabel 新使用记录 = new JLabel("新使用记录:");
        d新使用记录 = new JTextField();

        JButton submitJB = new JButton("修改");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(e -> {
                    ReviseEquipmentRevise();
                }
        );

        retJB.addActionListener(e -> {
            dispose();
            new Equipment();
        });

        panel.add(老设备id);
        panel.add(d老设备id);
        panel.add(新设备id);
        panel.add(d新设备id);
        panel.add(新教室名);
        panel.add(d新教室名);
        panel.add(新设备名);
        panel.add(d新设备名);
        panel.add(新设备类型);
        panel.add(d新设备类型);
        panel.add(新使用记录);
        panel.add(d新使用记录);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void ReviseEquipmentRevise() {
        String 老设备idCur = d老设备id.getText();
        String 新设备idCur = d新设备id.getText();
        String 新教室名 = d新教室名.getText();
        String 新设备名 = d新设备名.getText();
        String 新设备类型 = (String) d新设备类型.getSelectedItem();
        String 新使用记录 = d新使用记录.getText();

        if (老设备idCur.isEmpty() || 新教室名.isEmpty() || 新设备名.isEmpty() || 新设备类型.isEmpty() || 新使用记录.isEmpty()) {
            JOptionPane.showMessageDialog(this, "数据不可为空！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int 老设备id = Integer.parseInt(老设备idCur);
        int 新设备id;
        try {
            新设备id = 老设备id;
            if (!新设备idCur.isEmpty()) {
                新设备id = Integer.parseInt(新设备idCur);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "设备id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            String findSql = "select * from 设备表 where 设备id = ?";
            PreparedStatement findStatement = connection.prepareStatement(findSql);
            findStatement.setInt(1, 老设备id);
            ResultSet resultSet = findStatement.executeQuery();

            if (resultSet.next()) {
                String updateSql = "update 设备表 set 设备id = ?, 教室名 = ?, 设备名称 = ?, 设备类型 = ?, 使用记录 = ? where 设备id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setInt(1, 新设备id);
                updateStatement.setString(2, 新教室名);
                updateStatement.setString(3, 新设备名);
                updateStatement.setString(4, 新设备类型);
                updateStatement.setString(5, 新使用记录);
                updateStatement.setInt(6, 老设备id);

                int n = updateStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, n + " 条记录已修改。");

                updateStatement.close();
            } else {
                JOptionPane.showMessageDialog(this, "未找到该设备id的记录。", "修改失败", JOptionPane.ERROR_MESSAGE);
            }

            resultSet.close();
            findStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "修改失败，数据库错误：" + e.getMessage(), "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
