package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import state.State;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

    public static void refreshModel(int modelNumber) throws SQLException {
        if (State.models.get(modelNumber).getRowCount() > 0)
            for (int i = State.models.get(modelNumber).getRowCount() - 1; i > -1; i--)
                State.models.get(modelNumber).removeRow(i);
        ResultSet set = DatabaseConnection.getConnection()
                .prepareStatement("SELECT * FROM " + State.tableNames.get(modelNumber))
                .executeQuery();
        while (set.next()){
            Vector<String> row = new Vector<>();
            for(int i = 0; i != State.models.get(modelNumber).getColumnCount(); i++ )
                row.add(String.valueOf(set.getObject(i + 1)));
            State.models.get(modelNumber).addRow(row);
        }
    }
}
