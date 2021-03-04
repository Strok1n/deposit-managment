package db.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao {

    void insert(List<String> args) throws SQLException;

    void update();

    void delete();

    void select() throws SQLException;



}
