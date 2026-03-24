package repository;

import entity.Doctor;
import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO {

    public Doctor login(String doctorCode, String password) {
        String sql = "SELECT * FROM Doctors WHERE doctor_id = ? AND password = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctorCode);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Doctor d = new Doctor();
                    d.setId(rs.getString("doctor_id"));
                    d.setName(rs.getString("name"));
                    d.setSpecialty(rs.getString("specialty"));
                    return d;
                }
            }

        } catch (SQLException e) {
            System.out.println("Lỗi đăng nhập: " + e.getMessage());
        }
        return null;
    }
}