package equipment;

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

public class EquipmentAdd extends JFrame {
    private JTextField d设备id;
    private JTextField d教室名;
    private JTextField d设备名称;
    private JComboBox<String> d设备类型;
    private JTextField d使用记录;

    public EquipmentAdd() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("添加设备数据");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel 设备id = new JLabel("设备id:");
        d设备id = new JTextField();

        JLabel 教室名 = new JLabel("教室名:");
        d教室名 = new JTextField();

        JLabel 设备名称 = new JLabel("设备名称:");
        d设备名称 = new JTextField();

        JLabel 设备类型 = new JLabel("设备类型:");
        String[] types = {"电子设备", "木制设备", "铁制设备", "其他类型"};
        d设备类型 = new JComboBox<>(types);

        JLabel 使用记录 = new JLabel("使用记录:");
        d使用记录 = new JTextField();

        JButton submitJB = new JButton("提交");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEquipmentAdd();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Equipment();
                dispose();
            }
        });

        panel.add(设备id);
        panel.add(d设备id);
        panel.add(教室名);
        panel.add(d教室名);
        panel.add(设备名称);
        panel.add(d设备名称);
        panel.add(设备类型);
        panel.add(d设备类型);
        panel.add(使用记录);
        panel.add(d使用记录);

        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addEquipmentAdd() {
        String 设备idCur = d设备id.getText();
        String 教室名 = d教室名.getText();
        String 设备名称 = d设备名称.getText();
        String 设备类型 = (String) d设备类型.getSelectedItem();
        String 使用记录 = d使用记录.getText();
        if (设备idCur.isEmpty() || 教室名.isEmpty() || 设备名称.isEmpty() || 设备类型.isEmpty() || 使用记录.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入完整数据！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int 设备id = Integer.parseInt(设备idCur);
        try {

            // 创建数据源
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            // 建立数据库连接
            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            // 准备 SQL 语句
            String sql = "insert into 设备表 values (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 设备id);
            statement.setString(2, 教室名);
            statement.setString(3, 设备名称);
            statement.setString(4, 设备类型);
            statement.setString(5, 使用记录);

            // 执行更新操作
            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已插入。");

            // 关闭资源
            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "最大学生数必须是一个正整数。", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "插入失败，该教室号已存在或数据库错误。", "数据库错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
