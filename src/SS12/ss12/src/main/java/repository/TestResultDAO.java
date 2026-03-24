package repository;

import entity.TestResult;
import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestResultDAO {

    public void insertBatch(List<TestResult> results) {
        String sql = "INSERT INTO TestResults(patient_id, test_id, value) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (TestResult r : results) {
                ps.setString(1, r.getPatientId());
                ps.setString(2, r.getTestId());
                ps.setDouble(3, r.getValue());
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (SQLException e) {
            System.out.println("Lỗi chèn kết quả xét nghiệm: " + e.getMessage());
        }
    }
}
