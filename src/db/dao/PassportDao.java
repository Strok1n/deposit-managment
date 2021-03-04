package db.dao;

import db.DatabaseConnection;
import state.AppState;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PassportDao implements Dao{
    @Override
    public void insert(List<String> args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement =
                connection.prepareStatement(
                        "INSERT INTO passport" +
                                "(first_name, " +
                                "last_name, " +
                                "patronymic, " +
                                "series, " +
                                "number, " +
                                "gender, " +
                                "address, " +
                                "birth_date, " +
                                "birth_place, " +
                                "issue_date, " +
                                "issue_place, " +
                                "military_duty, " +
                                "marital_status, " +
                                "is_valid) VALUES(" +
                                "?,?,?,?,?,?,?,?,?,?," +
                                "?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        for( int i = 0; i != args.size(); i++)
            statement.setString(i + 1, args.get(i));


        statement.execute();

        ResultSet set = statement.getGeneratedKeys();

        while (set.next()){
            System.out.println(set.getObject(1));
        }











    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void select() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        ResultSet set = connection
                .createStatement()
                .executeQuery("SELECT * FROM passport");
        Vector<Vector<String>> list = new Vector<>();
        AppState.setPassports(list);
        int j = 0;
        while (set.next()) {
            AppState.getPassports().add(new Vector<>());
            for (int i = 1; i != 16; i++)
                AppState.getPassports().get(j).add(String.valueOf(set.getObject(i)));
            j++;
        }
    }
}
