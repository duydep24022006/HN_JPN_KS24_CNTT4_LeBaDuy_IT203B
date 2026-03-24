package repository;

import utility.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDAO {
    public String sanitizeInput(String input) {
        if (input == null) return null;

        input = input.replace("--", "");
        input = input.replace(";", "");
        input = input.replace("'", "");

        return input;
    }
    public void searchPatient(String name) {
        String cleanName = sanitizeInput(name);

        String sql = "SELECT * FROM patient WHERE name = '" + cleanName + "'";

        try (
                Connection conn = DBContext.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
        ) {

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
