package lk.ijse.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T> extends SuperDao {

    boolean save(T entity) throws SQLException;
    boolean update(String id,T entity) throws SQLException;
    boolean delete(String id) throws SQLException;

   ArrayList<T> getAll() throws SQLException;
}
