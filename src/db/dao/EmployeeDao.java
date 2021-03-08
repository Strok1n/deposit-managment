package db.dao;

import db.DatabaseConnection;
import ui.State;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class EmployeeDao implements Dao{
    @Override
    public void insert(List<String> args) throws SQLException {

    }

    @Override
    public void update(List<String> args) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void select() throws SQLException {


        ResultSet set = DatabaseConnection
                .getConnection()
                .prepareStatement("SELECT * FROM employee")
                .executeQuery();



        Vector<Vector<String>> list = new Vector<>();
        State.setEmployees(list);
        int j = 0;
        while (set.next()) {
            State.getEmployees().add(new Vector<>());
            for (int i = 1; i != 10; i++)
                State.getEmployees().get(j).add(String.valueOf(set.getObject(i)));
            j++;
        }

    }
}
