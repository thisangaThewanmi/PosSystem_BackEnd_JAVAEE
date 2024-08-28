package lk.ijse.dao;

import lk.ijse.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {

    public static <T> T execute(String sql, Object... ob) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        if(connection == null){
            System.out.println("connection null");
        }
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < ob.length; i++) {
            pstm.setObject(i+1 ,ob[i]);
        }

        if(sql.startsWith("SELECT")||sql.startsWith("select")){
            return (T) pstm.executeQuery();
        }
        return (T) (Boolean) (pstm.executeUpdate()>0);

    }
}