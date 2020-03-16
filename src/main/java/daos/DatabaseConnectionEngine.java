package daos;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionEngine {
    public static final String URL = "jdbc:mysql://localhost:3306/bankDetails?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "gbrad";
    public static final String PASS = "kali";

    /*This method is used to make a connection to the database.*/
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Connection Successful");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) {
        Connection connection = DatabaseConnectionEngine.getConnection();
    }

}
