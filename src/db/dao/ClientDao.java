package db.dao;

import db.DatabaseConnection;
import ui.State;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class ClientDao implements Dao{
    @Override
    public void update(List<String> args) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void select() throws SQLException {

        Connection connection = DatabaseConnection.getConnection();
       ResultSet set =  connection.prepareStatement("SELECT * FROM client").executeQuery();
        Vector<Vector<String>> list = new Vector<>();
        State.setClients(list);
        int j = 0;
        while (set.next()) {
            State.getClients().add(new Vector<>());
            for (int i = 1; i != 7; i++)
                State.getClients().get(j).add(String.valueOf(set.getObject(i)));
            j++;
        }
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
