package graduation_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String HOST = "jdbc:mysql://localhost:3306/graduation_project?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "root";
    private Connection connection;

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(HOST, USER, PASS);
        } catch (SQLException e) {
            System.err.println("Ошибка соединения");
        }
    }
    public Connection getConnection(){
        return connection;
    }

}
