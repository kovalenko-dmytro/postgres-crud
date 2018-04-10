package study.apach.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/bookstore_db";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "apach";

    private DBManager(){};

    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
