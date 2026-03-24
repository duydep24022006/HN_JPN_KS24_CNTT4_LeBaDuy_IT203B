package repository;

import entity.Doctor;
import utility.DBContext;

import java.sql.*;
import java.util.*;

public class DoctorDAO {

    // Lấy tất cả bác sĩ
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Doctor(
                        rs.getString("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialty")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách bác sĩ: " + e.getMessage());
        }
        return list;
    }

    // Thêm bác sĩ mới
    public boolean addDoctor(Doctor doctor) {
        String sql = "INSERT INTO Doctors (doctor_id, name, specialty) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getSpecialty());

            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Mã bác sĩ đã tồn tại! Vui lòng nhập mã khác.");
        } catch (SQLException e) {
            System.out.println("Lỗi thêm bác sĩ: " + e.getMessage());
        }
        return false;
    }

    // Thống kê số lượng bác sĩ theo chuyên khoa
    public Map<String, Integer> getSpecialtyStats() {
        Map<String, Integer> stats = new HashMap<>();
        String sql = "SELECT specialty, COUNT(*) AS count FROM Doctors GROUP BY specialty";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                stats.put(rs.getString("specialty"), rs.getInt("count"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi thống kê chuyên khoa: " + e.getMessage());
        }
        return stats;
    }
}
