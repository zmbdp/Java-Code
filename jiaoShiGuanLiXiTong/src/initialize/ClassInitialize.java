package initialize;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClassInitialize {
    // 初始化教室表
    Scanner sc = new Scanner(System.in);
    GetSource getSource = new GetSource();
    GetConnec getConnec = new GetConnec();
    public ClassInitialize() throws SQLException {
        // 构造数据源
        DataSource source = getSource.getDataSource();

        // 联系数据库
        Connection connection = getConnec.getConnection(source);

        try (
                Statement stmt = connection.createStatement();
        ) {
            // 构造语句
            String insertSQL = "insert into 教室表 values (?, ?, ?, ?, ?) " +
                    "on duplicate key update 教室名 = values(教室名), 最大学生数 = values(最大学生数), " +
                    "教学楼地址 = values(教学楼地址), 教室类别 = values(教室类别), 教室空闲状态 = values(教室空闲状态)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);

            statement.setString(1, "106");
            statement.setInt(2, 100);
            statement.setString(3, "第三教学楼");
            statement.setString(4, "普通教室");
            statement.setBoolean(5, true);
            statement.addBatch();

            statement.setString(1, "108");
            statement.setInt(2, 120);
            statement.setString(3, "第四教学楼");
            statement.setString(4, "多媒体教室");
            statement.setBoolean(5, false);
            statement.addBatch();

            statement.executeBatch();
            // 执行 sql 语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
