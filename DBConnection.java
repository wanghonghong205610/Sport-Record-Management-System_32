package SportsConnection;
import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/fitness_tracker";
    private static final String USER = "root";       // 改成你的MySQL用户名
    private static final String PASSWORD = "060423"; // 改成你的MySQL密码！（重点！）

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}