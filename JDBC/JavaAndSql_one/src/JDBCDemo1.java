import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class JDBCDemo1 {
    public static void main(String[] args) throws SQLException {
        // 先在mysql数据库中建立一个 student(id int, name varchar(20)) 的表

        // 1、创建 “数据源 ”
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mysql0910?characterEncoding=utf8&useSSL=false");// 固定书写格式，中间问号那里是写数据库的名字
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("Hlovef173503494");// 里面填写你数据库的密码


        // 2、和数据库服务器建立联系
        Connection connection = dataSource.getConnection();// 这里得选择 java 的 API 接口


        // 3、构造 SQL 语句
        //String sql = "insert into student values(1, '张三')";// 这种写法写死了，更希望在输入框里面给别人自己输入
        //String sql = "insert into student values(" + id + ", '"+ name + "')";// 这种也可以，但是引号太多，很容易出错，并且安全性不高，容易被攻击

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号->");
        int id = sc.nextInt();
        System.out.println("请输入姓名->");
        String name = sc.next();

        String sql = "insert into student values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);// 数据库表中的固定输入格式，表示把第一个问号输入成 “id” 里面的数据
        statement.setString(2, name);// 第二个问号输入成 “name” 里面的数据


        // 4、执行 sql 语句
        int n = statement.executeUpdate();// 适用于插入、修改、删除，返回值就是这次操作影响到几行
        System.out.println(n);
        //statement.executeQuery();// 适用于查询


        // 5、释放资源
        statement.close();
        connection.close();
    }
}
