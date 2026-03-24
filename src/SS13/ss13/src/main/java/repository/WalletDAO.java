package repository;

import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDAO {

    public boolean payInvoice(String patientId, String invoiceId, double amount) {
        String updateWalletSQL = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ? AND balance >= ?";
        String updateInvoiceSQL = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";

        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            // 1. Trừ tiền trong ví bệnh nhân
            try (PreparedStatement psWallet = conn.prepareStatement(updateWalletSQL)) {
                psWallet.setDouble(1, amount);
                psWallet.setString(2, patientId);
                psWallet.setDouble(3, amount);
                int walletRows = psWallet.executeUpdate();
                if (walletRows == 0) {
                    System.out.println("Không đủ tiền trong ví!");
                    conn.rollback(); // rollback ngay nếu không đủ tiền
                    return false;
                }
            }

            // 2. Cập nhật hóa đơn
            try (PreparedStatement psInvoice = conn.prepareStatement(updateInvoiceSQL)) {
                psInvoice.setString(1, invoiceId);
                int invoiceRows = psInvoice.executeUpdate();
                if (invoiceRows == 0) {
                    System.out.println("Không tìm thấy hóa đơn!");
                    conn.rollback(); // rollback nếu cập nhật hóa đơn thất bại
                    return false;
                }
            }

            // 3. Commit transaction
            conn.commit();
            System.out.println("Thanh toán thành công!");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            // **Rollback an toàn nếu có lỗi**
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback giao dịch do lỗi xảy ra!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            // Đảm bảo kết nối được đóng
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // trả về trạng thái mặc định
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void printWallet(String patientId) {
        String sql = "SELECT patient_id, balance FROM Patient_Wallet WHERE patient_id = ?";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Patient ID: " + rs.getString("patient_id") +
                            " | Balance: " + rs.getDouble("balance"));
                } else {
                    System.out.println("Không tìm thấy ví bệnh nhân!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}