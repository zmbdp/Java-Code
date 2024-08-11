package initialize;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InspectionInitialize {
    // 初始化检查表
    private final DataSource source;
    private final Connection connection;

    public InspectionInitialize() throws SQLException {
        // 构造数据源和数据库连接
        GetSource getSource = new GetSource();
        this.source = getSource.getDataSource();
        GetConnec getConnec = new GetConnec();
        this.connection = getConnec.getConnection(source);

        // 执行批处理插入数据
        // 使用 try-with-resources 确保资源正确关闭
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into 检查表 (设备id, 检查员id, 检查时间, 设备状态) values (?, ?, ?, ?) " +
                        "on duplicate key update 设备id = values(设备id)"
        )) {
            // 第一组数据
            statement.setInt(1, 222);
            statement.setInt(2, 20240920);
            statement.setDate(3, java.sql.Date.valueOf("2024-12-05"));
            statement.setBoolean(4, true);
            statement.addBatch();

            // 第二组数据
            statement.setInt(1, 213);
            statement.setInt(2, 20211202);
            statement.setDate(3, java.sql.Date.valueOf("2024-07-05"));
            statement.setBoolean(4, false);
            statement.addBatch();

            // 执行批处理
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
