package initialize;

import Information.GetConnec;
import Information.GetPassword;
import Information.GetSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitialize {
    public DatabaseInitialize() throws SQLException {
        GetSource getSource = new GetSource();
        DataSource source = getSource.getDataSource(GetPassword.password);
        GetConnec getConnec = new GetConnec();
        Connection connection = null;
        try {
            connection = getConnec.getConnection(source);
            Statement statement = connection.createStatement();
            String sql = "create database if not exists 数据库实践 character set utf8 collate utf8_general_ci";
            statement.executeUpdate(sql);
            GetSource.serverName = "数据库实践";
            JOptionPane.showMessageDialog(null, "初始化完成: " + " 数据库创建成功！");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "数据库创建失败！" + e.getMessage(),
                    "程序退出！", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
