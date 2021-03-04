package db;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    private DatabaseConnection(){}

    public static Connection getConnection() {
        return DatabaseConnection.connection;
    }

    public static void setAdminConnection() throws SQLException {
        MysqlDataSource source = new MysqlDataSource();
        source.setServerName("38.17.53.117");
        source.setPort(20372);
        source.setServerTimezone("UTC");
        source.setCharacterEncoding("UTF-8");
        source.setDatabaseName("bank");
        source.setUser("root");
        source.setPassword("12341234");
        DatabaseConnection.connection = source.getConnection();
    }







}
