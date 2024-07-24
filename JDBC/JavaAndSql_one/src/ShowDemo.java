import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShowDemo {
    public static void main(String[] args) throws SQLException {
        DataSource source = new MysqlDataSource();
        ((MysqlDataSource) source).setURL("jdbc:mysql://127.0.0.1:3306/mysql0910?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) source).setUser("root");
        ((MysqlDataSource) source).setPassword("123456");

        Connection connection = source.getConnection();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名->");
        String studentName = sc.nextLine();
        String sql = "select * from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, studentName);
        ResultSet resultSet = statement.executeQuery();
        boolean flag = true;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + "," + name);
            if (name != null) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("未找到!!!");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
