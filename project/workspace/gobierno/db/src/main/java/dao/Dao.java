package dao;


import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> select(T form) throws SQLException;

    void insert(T form) throws SQLException;

    void update(T form) throws SQLException;

    void delete(T form) throws SQLException;

    boolean valid(T form) throws SQLException;
}
