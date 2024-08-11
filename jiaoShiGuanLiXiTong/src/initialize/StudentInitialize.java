package initialize;

import Information.GetConnec;
import Information.GetSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInitialize {
    // 初始化教师表
    Scanner sc = new Scanner(System.in);
    GetSource getSource = new GetSource();
    GetConnec getConnec = new GetConnec();
    public StudentInitialize() throws SQLException {
        // 构造数据源
        DataSource source = getSource.getDataSource();

        // 联系数据库
        Connection connection = getConnec.getConnection(source);

        try (
                Statement stmt = connection.createStatement();
        ) {
            // 构造语句
            String insertSQL = "insert into 学生表 values (?, ?, ?, ?) " +
                    "on duplicate key update 学生id = values(学生id), 学生名 = values(学生名), " +
                    "学生年龄 = values(学生年龄), 学生性别 = values(学生性别)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);

            statement.setInt(1, 2220423);
            statement.setString(2, "付豪");
            statement.setInt(3, 20);
            statement.setString(4, "男");
            statement.addBatch();

            statement.setInt(1, 2220392);
            statement.setString(2, "李颐");
            statement.setInt(3, 20);
            statement.setString(4, "男");
            statement.addBatch();

            statement.executeBatch();
            // 执行 sql 语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
