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

public class EquipmentDel extends JFrame {
    private JTextField idFind;

    public EquipmentDel() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("删除设备数据");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel 设备idFind = new JLabel("设备id:");
        idFind = new JTextField();

        JButton submitJB = new JButton("删除");
        JButton retJB = new JButton("返回");

        submitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEquipmentDel();
            }
        });

        retJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Equipment();
            }
        });

        panel.add(设备idFind);
        panel.add(idFind);
        panel.add(submitJB);
        panel.add(retJB);

        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void deleteEquipmentDel() {
        String find = idFind.getText();

        if (find.isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入设备id！", "输入错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int findId = Integer.parseInt(find);

        try {
            GetSource getSource = new GetSource();
            DataSource source = getSource.getDataSource();

            GetConnec getConnec = new GetConnec();
            Connection connection = getConnec.getConnection(source);

            String sql = "delete from 设备表 where 设备id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, findId);

            int n = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, n + " 条记录已删除。");

            statement.close();
            connection.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "设备id必须是一个整数！", "输入错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "删除失败，该设备id不存在或数据库错误！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}
