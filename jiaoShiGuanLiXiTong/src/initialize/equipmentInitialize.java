package initialize;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class equipmentInitialize {
    public equipmentInitialize() throws SQLException {
        // 构造数据源
        GetSource getSource = new GetSource();
        DataSource source = getSource.getDataSource();

        // 联系数据库
        GetConnec getConnec = new GetConnec();
        Connection connection = getConnec.getConnection(source);

        PreparedStatement statement = null;

        try {
            // 构造语句
            String insertSQL = "insert into 设备表 values (?, ?, ?, ?, ?) " +
                    "on duplicate key update 设备id = values(设备id), " +
                    "教室名 = values(教室名), 设备名称 = values(设备名称), " +
                    "设备类型 = values(设备类型), 使用记录 = values(使用记录)";
            statement = connection.prepareStatement(insertSQL);

            // 第一条记录
            statement.setInt(1, 222);
            statement.setString(2, "106");
            statement.setString(3, "音响");
            statement.setString(4, "电子设备");
            statement.setString(5, "17次");
            statement.addBatch();

            // 第二条记录
            statement.setInt(1, 213);
            statement.setString(2, "108");
            statement.setString(3, "电脑");
            statement.setString(4, "电子设备");
            statement.setString(5, "17次");
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
