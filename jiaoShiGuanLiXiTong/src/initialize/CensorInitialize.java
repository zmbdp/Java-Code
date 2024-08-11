package initialize;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CensorInitialize {
    // 初始化检查员表
    public CensorInitialize() throws SQLException {
        // 构造数据源
        GetSource getSource = new GetSource();
        DataSource source = getSource.getDataSource();

        // 联系数据库
        GetConnec getConnec = new GetConnec();
        Connection connection = getConnec.getConnection(source);

        PreparedStatement statement = null;

        try {
            // 构造语句
            String insertSQL = "insert into 检查员表 values (?, ?, ?, ?, ?) " +
                    "on duplicate key update 检查员id = values(检查员id), " +
                    "检查员姓名 = values(检查员姓名), 检查员年龄 = values(检查员年龄), " +
                    "检查员性别 = values(检查员性别), 检查员空闲状态 = values(检查员空闲状态)";
            statement = connection.prepareStatement(insertSQL);

            // 第一条记录
            statement.setInt(1, 20211202);
            statement.setString(2, "王小美");
            statement.setInt(3, 300);
            statement.setString(4, "女");
            statement.setBoolean(5, true);
            statement.addBatch();

            // 第二条记录
            statement.setInt(1, 20240920);
            statement.setString(2, "苹果姐");
            statement.setInt(3, 20);
            statement.setString(4, "女");
            statement.setBoolean(5, true);
            statement.addBatch();

            // 执行批处理
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
