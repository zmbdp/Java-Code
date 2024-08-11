package initialize;

import Information.GetConnec;
import Information.GetPassword;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TeacherInitialize {
    // 初始化教师表
    Scanner sc = new Scanner(System.in);
    GetSource getSource = new GetSource();
    GetConnec getConnec = new GetConnec();

    public TeacherInitialize() throws SQLException {
        // 构造数据源
        DataSource source = getSource.getDataSource();

        // 联系数据库
        Connection connection = getConnec.getConnection(source);

        try (
                Statement stmt = connection.createStatement();
                ) {
            // 构造语句
            String insertSQL = "insert into 教师表 values (?, ?, ?, ?) " +
                    "on duplicate key update 教师id = values(教师id), 教师名 = values(教师名), " +
                    "办公室地址 = values(办公室地址), 教师性别 = values(教师性别)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);

            statement.setInt(1, 414);
            statement.setString(2, "流萎山");
            statement.setString(3, "信息技术学院414");
            statement.setString(4, "男");
            statement.addBatch();

            statement.setInt(1, 424);
            statement.setString(2, "流萎东");
            statement.setString(3, "信息技术学院414");
            statement.setString(4, "男");
            statement.addBatch();

            statement.executeBatch();
            // 执行 sql 语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
