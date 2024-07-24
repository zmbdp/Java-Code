import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;

public class AddDemo {
    public static void main(String[] args) throws SQLException {
        /*// 先在数据库创建一个 student 的表

        // 1、构建数据源
        DataSource source = new MysqlDataSource();
        ((MysqlDataSource) source).setURL("jdbc:mysql://127.0.0.1:3306/mysql0910?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) source).setUser("root");
        ((MysqlDataSource) source).setPassword("Hlovef173503494");

        //2、与服务器建立联系
        Connection connection = source.getConnection();
        //3、给数据库下命令
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名->");
        String name = sc.nextLine();
        System.out.println("请输入id->");
        int id = sc.nextInt();
        String sql = "insert into student values(?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);

        //4、导入到数据库，执行命令
        int n = statement.executeUpdate();
        System.out.println(n);

        //5、释放空间，先创建的后释放，后创建的先释放
        statement.close();
        connection.close();*/



        /*// 创建一个 student 数据库

        // 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mysql0910?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("Hlovef173503494");
        // 用 Java 的 API 接口和数据库建立练习
        Connection connection = dataSource.getConnection();
        // 书写 sql 语句
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名->");
        String name = sc.nextLine();
        System.out.println("请输入id->");
        int id = sc.nextInt();
        String sql = "insert into student values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(2, name);
        statement.setInt(1, id);
        // 执行指令
        int n = statement.executeUpdate();
        System.out.println(n);
        // 释放空间
        statement.close();
        connection.close();*/




        // 创建一个 student 数据库

        // 先让数据库找到这里
        DataSource source = new MysqlDataSource();
        ((MysqlDataSource) source).setURL("jdbc:mysql://127.0.0.1:3306/mysql0910?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) source).setUser("root");
        ((MysqlDataSource) source).setPassword("Hlovef173503494");

        // 再使用 Java 的 API 和数据库建立联系
        Connection connection = source.getConnection();
        // 输入指令
        Scanner sc = new Scanner(System.in);
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("id");
        int id = sc.nextInt();
        String sql = "insert into student values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(2, name);
        statement.setInt(1, id);
        // 执行指令
        int n = statement.executeUpdate();
        System.out.println(n);
        // 释放空间
        statement.close();
        connection.close();






































    }
}
