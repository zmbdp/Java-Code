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

public class EquipmentFind extends JFrame {
    private JTextField idFind;
    private JTextArea resultArea;

    public EquipmentFind() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("查找设备数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel findId = new JLabel("请输入要查找的设备id:");
        idFind = new JTextField();

        JButton submitJB = new JButton("查找");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(e -> {
            findEquipment();
        });

        retJB.addActionListener(e -> {
            dispose();
            new Equipment();
        });

        panel.add(findId);
        panel.add(idFind);
        panel.add(submitJB);
        panel.add(retJB);
        panel.add(new JScrollPane(resultArea));

        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void findEquipment() {
        String findId = idFind.getText();

        if (findId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入设备id！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int find = Integer.parseInt(findId);

            try {
                GetSource getSource = new GetSource();
                DataSource source = getSource.getDataSource();

                GetConnec getConnec = new GetConnec();
                connection = getConnec.getConnection(source);

                String sql = "select * from 设备表 where 设备id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, find);

                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int equipmentId = resultSet.getInt("设备id");
                    String className = resultSet.getString("教室名");
                    String equipmentName = resultSet.getString("设备名称");
                    String equipmentType = resultSet.getString("设备类型");
                    String recording = resultSet.getString("使用记录");

                    String result = "设备id: " + equipmentId + "\n" +
                            "教室名: " + className + "\n" +
                            "设备名: " + equipmentName + "\n" +
                            "设备类型: " + equipmentType + "\n" +
                            "使用记录: " + recording;
                    JOptionPane.showMessageDialog(null, result, "查询结果", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "未找到该设备id的记录。", "查找结果", JOptionPane.INFORMATION_MESSAGE);
                }

                // 关闭资源
                resultSet.close();
                statement.close();
                connection.close();
            } finally {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "设备id必须是整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "查找数据失败，数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
