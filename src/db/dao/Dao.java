package db.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao {

    void insert(List<String> args) throws SQLException;

    void update(List<String> args) throws SQLException;

    void delete(String  id) throws SQLException;

    void select() throws SQLException;



}
