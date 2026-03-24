package Bt5;

import utility.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Patients";

        try (Connection conn = DBContext.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Patient p = new Patient(
                        rs.getString("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("diagnosis")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách bệnh nhân: " + e.getMessage());
        }

        return list;
    }

    public boolean addPatient(Patient p) {
        String sql = "INSERT INTO Patients(patient_id, name, age, department, diagnosis) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getPatientId());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getAge());
            ps.setString(4, p.getDepartment());
            ps.setString(5, p.getDiagnosis());

            int n = ps.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm bệnh nhân: " + e.getMessage());
            return false;
        }
    }

    public boolean updateDiagnosis(String patientId, String diagnosis) {
        String sql = "UPDATE Patients SET diagnosis = ? WHERE patient_id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, diagnosis);
            ps.setString(2, patientId);

            int n = ps.executeUpdate();
            return n > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật bệnh án: " + e.getMessage());
            return false;
        }
    }

    public double calculateDischargeFee(String patientId, int days) {
        String sql = "{call CALCULATE_DISCHARGE_FEE(?, ?, ?)}";

        try (Connection conn = DBContext.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, patientId);
            cs.setInt(2, days);
            cs.registerOutParameter(3, Types.DECIMAL);

            cs.execute();
            return cs.getDouble(3);
        } catch (SQLException e) {
            System.out.println("Lỗi khi tính phí xuất viện: " + e.getMessage());
            return -1;
        }
    }
}
