package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    public static final String url = "jdbc:postgresql://localhost:5432/home_work_6";
    public static final String user = "postgres";
    public static final String password = "kutu013kg";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect болду postgres серверге кошулду");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

