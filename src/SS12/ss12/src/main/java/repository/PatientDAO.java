package repository;

import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {

    public boolean updateVitals(String patientId, double temperature, int heartRate) {
        String sql = "UPDATE Patients SET temperature = ?, heart_rate = ? WHERE patient_id = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, temperature);  // handle dấu chấm / dấu phẩy tự động
            ps.setInt(2, heartRate);
            ps.setString(3, patientId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật chỉ số sinh tồn: " + e.getMessage());
            return false;
        }
    }
}