package db.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import db.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class ClientDao implements Dao{
    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void select() {


    }

    @Override
    public void insert(List<String> args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
       PreparedStatement statement =
               connection.prepareStatement
                       ("INSERT INTO client" +
                               "(passport_id, " +
                               "address, " +
                               "phone, " +
                               "email, " +
                               "password) VALUES(" +
                               "?,?,?,?,?)",
                               Statement.RETURN_GENERATED_KEYS);
       for( int i = 0; i != args.size(); i++) {
           if( i == 0){
               statement.setInt(i + 1, Integer.parseInt(args.get(i).trim()));
           }else{
               statement.setString(i + 1, args.get(i));
           }
       }
       statement.execute();
       ResultSet set = statement.getGeneratedKeys();
    }
}
