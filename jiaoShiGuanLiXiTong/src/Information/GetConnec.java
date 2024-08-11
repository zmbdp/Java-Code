package Information;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class GetConnec {
    public Connection getConnection(DataSource source) throws SQLException {
        return source.getConnection();
    }
}
