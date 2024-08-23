package lk.ijse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Step 1: Create a private static instance of the class
    private static DBConnection instance;

    // Step 2: Create a private static Connection object
    private static Connection connection;

    // Step 3: Define database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Step 4: Make the constructor private to prevent instantiation
    private DBConnection() {
        try {
            // Step 5: Establish the connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    // Step 6: Provide a public method to get the instance of the class
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
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
