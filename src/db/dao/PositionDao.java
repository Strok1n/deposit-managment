package db.dao;

import db.DatabaseConnection;
import state.State;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class PositionDao implements Dao{
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
                .prepareStatement("SELECT * FROM position")
                .executeQuery();

        Vector<Vector<String>> list = new Vector<>();
        State.setPositions(list);
        int j = 0;
        while (set.next()) {
            State.getPositions().add(new Vector<>());
            for (int i = 1; i != 5; i++)
                State.getPositions().get(j).add(String.valueOf(set.getObject(i)));
            j++;
        }

    }
}
