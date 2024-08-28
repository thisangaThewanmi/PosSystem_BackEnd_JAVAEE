package lk.ijse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // Step 1: Create a private static instance of the class
    private static DbConnection instance;

    // Step 2: Create a private static Connection object
    private static Connection connection;

    // Step 3: Define database URL, username, and password

    // Step 4: Make the constructor private to prevent instantiation
    private DbConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 5: Establish the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","Ijse@1234");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // Step 6: Provide a public method to get the instance of the class
    public static DbConnection getInstance() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }

    // Step 7: Provide a method to get the connection
    public Connection getConnection() {
        return connection;
    }
}
