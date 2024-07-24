import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DelDemo {
    public static void main(String[] args) throws SQLException {
        DataSource source = new MysqlDataSource();
        ((MysqlDataSource) source).setURL("jdbc:mysql://127.0.0.1:3306/mysql0910?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) source).setUser("root");
        ((MysqlDataSource) source).setPassword("Hlovef173503494");

        Connection connection = source.getConnection();

        Scanner sc = new Scanner(System.in);
        /*System.out.println("请输入id->");
        int id = sc.nextInt();
        String sql = "delete from student where id = ?";*/
        System.out.println("请输入名字->");
        String name = sc.nextLine();
        String sql = "delete from student where name = ?";// 不支持模糊查询
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        int n = statement.executeUpdate();
        System.out.println(n);
        statement.close();
        connection.close();
    }
}
