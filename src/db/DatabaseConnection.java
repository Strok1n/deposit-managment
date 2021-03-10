package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import ui.State;
import util.Validator;

import java.sql.*;
import java.util.Vector;

public class DatabaseConnection {

    private static final String DbName = "bank";

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

    public static void insert(int modelNumber, Vector<String> params) throws SQLException {
        StringBuilder builder = new StringBuilder("INSERT INTO " + DbName +"."+ State.tableNames.get(modelNumber) + "(");
        for(int i = 1; i != State.models.get(modelNumber).getColumnCount(); i++)
            builder.append(new String(State.dbTableColumns.get(modelNumber).get(i) + ", "));
        String sql = builder.substring(0, builder.length() - 2);
        builder = new StringBuilder(sql);
        builder.append(") VALUES(");
        for(int i = 0; i != params.size(); i++) {
         //   if(Validator.notOnlyNumbers(params.get(i)))
                builder.append(new String("\"" + params.get(i) + "\", "));
          //  else
              //  builder.append(new String(params.get(i) + ", "));
        }
        sql = builder.substring(0, builder.length() - 2);
        builder = new StringBuilder(sql);
        builder.append(");");
        sql = builder.toString();

        System.out.println(sql);

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.execute();
        Vector<String> modelParams = new Vector<>();
        ResultSet set = statement.getGeneratedKeys();
        while(set.next())
            modelParams.add(set.getObject(1).toString());
        modelParams.addAll(params);
        State.models.get(modelNumber).addRow(modelParams);
    }

    public static void delete(int modelNumber, int id) throws SQLException {
        String sql = new String("DELETE FROM " + State.tableNames.get(modelNumber) + " WHERE id=" + id);
        System.out.println(sql);
        connection.prepareStatement(sql).execute();
    }

    public static void update(int modelNumber, Vector<String> params) throws SQLException {
        String sql ="UPDATE " + DbName +"."+ State.tableNames.get(modelNumber) +" SET ";
        StringBuilder builder = new StringBuilder(sql);
        for(int i = 1; i != State.dbTableColumns.get(modelNumber).size(); i++)
            builder.append(State.dbTableColumns.get(modelNumber).get(i))
                    .append(" = \"")
                    .append(params.get(i))
                    .append("\", ");
        sql = builder.substring(0, builder.length() - 2);
        builder = new StringBuilder(sql);
        System.out.println(sql);
    builder.append(" WHERE(id = ").append(params.get(0)).append(");");
    sql = builder.toString();
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.execute();
    }


}
