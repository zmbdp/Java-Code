package Information;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class GetSource {
    public static String serverName = "mysql";
    public DataSource getDataSource() {
        DataSource source = new MysqlDataSource();
        ((MysqlDataSource) source).setURL("jdbc:mysql://127.0.0.1:3306/" + serverName + "?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) source).setUser("root");
        ((MysqlDataSource) source).setPassword(GetPassword.password);
        return source;
    }
    public DataSource getDataSource(String password) {
        DataSource source = new MysqlDataSource();
        ((MysqlDataSource) source).setURL("jdbc:mysql://127.0.0.1:3306/" + serverName + "?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) source).setUser("root");
        ((MysqlDataSource) source).setPassword(password);
        return source;
    }
}
