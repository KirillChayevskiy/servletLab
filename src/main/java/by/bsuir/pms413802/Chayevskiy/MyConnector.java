package main.java.by.bsuir.pms413802.Chayevskiy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnector {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/dbLaba?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "111";
    public static Connection jdbcConnection;


    public static void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public static void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}
