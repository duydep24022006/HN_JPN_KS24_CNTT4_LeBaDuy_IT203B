package repository;

import entity.Medicine;
import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {

    // 1. Lấy danh sách thuốc
    public List<Medicine> getAllMedicine() {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT medicine_id, name, stock FROM Medicine_Inventory";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("medicine_id"),
                        rs.getString("name"),
                        rs.getInt("stock")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Cấp phát thuốc (giữ nguyên code bạn đã viết)
    public boolean dispenseMedicine(String medicineId, String patientId, int quantity) {
        String updateInventorySQL = "UPDATE Medicine_Inventory SET stock = stock - ? WHERE medicine_id = ? AND stock >= ?";
        String insertHistorySQL = "INSERT INTO Prescription_History (patient_id, medicine_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DBContext.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psUpdate = conn.prepareStatement(updateInventorySQL)) {
                psUpdate.setInt(1, quantity);
                psUpdate.setString(2, medicineId);
                psUpdate.setInt(3, quantity);
                int rowsAffected = psUpdate.executeUpdate();

                if (rowsAffected == 0) {
                    System.out.println("Kho không đủ thuốc để cấp phát!");
                    conn.rollback();
                    return false;
                }
            }

            try (PreparedStatement psInsert = conn.prepareStatement(insertHistorySQL)) {
                psInsert.setString(1, patientId);
                psInsert.setString(2, medicineId);
                psInsert.setInt(3, quantity);
                psInsert.executeUpdate();
            }

            conn.commit();
            System.out.println("Cấp phát thuốc thành công!");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cấp phát thuốc, rollback dữ liệu.");
            return false;
        }
    }
    public void printPrescriptionHistory() {
        String sql = "SELECT id, patient_id, medicine_id, quantity, dispense_date FROM Prescription_History ORDER BY dispense_date DESC";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("ID | Patient | Medicine | Quantity | Date");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %d | %s%n",
                        rs.getInt("id"),
                        rs.getString("patient_id"),
                        rs.getString("medicine_id"),
                        rs.getInt("quantity"),
                        rs.getTimestamp("dispense_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}