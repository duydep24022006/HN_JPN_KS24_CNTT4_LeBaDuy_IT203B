package bt45p.utity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static final String URL = "jdbc:mysql://localhost:3306/db_user?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "dUYDEP24022006";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void testQuery() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("kết nối thành công");
            }

        } catch (SQLException e) {
            System.out.println("lỗi db");
            e.printStackTrace();
        }
    }

}
