package initialize;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseInitialize extends SQLException{
    // 初始化课程表
    private final DataSource source;
    private final Connection connection;

    public CourseInitialize() throws SQLException {
        // 构造数据源和数据库连接
        GetSource getSource = new GetSource();
        this.source = getSource.getDataSource();
        GetConnec getConnec = new GetConnec();
        this.connection = getConnec.getConnection(source);

        // 执行批处理插入数据
        // 使用 try-with-resources 确保资源正确关闭
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into 课程表 values (?, ?, ?, ?, ?, ?, ?) " +
                        "on duplicate key update 课程id = values(课程id)"
        )) {
            // 第一组数据
            statement.setInt(1, 28197);
            statement.setString(2, "106");
            statement.setInt(3, 414);
            statement.setInt(4, 2220423);
            statement.setString(5, "大学日语");
            statement.setTimestamp(6, java.sql.Timestamp.valueOf("2024-12-05 12:45:00"));
            statement.setTimestamp(7, java.sql.Timestamp.valueOf("2024-12-05 14:15:00"));
            statement.addBatch();

            // 第二组数据
            statement.setInt(1, 18920);
            statement.setString(2, "106");
            statement.setInt(3, 424);
            statement.setInt(4, 2220392);
            statement.setString(5, "成为大江CEO的必修课");
            statement.setTimestamp(6, java.sql.Timestamp.valueOf("2024-01-15 12:45:00"));
            statement.setTimestamp(7, java.sql.Timestamp.valueOf("2024-01-15 14:15:00"));
            statement.addBatch();

            // 执行批处理
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
