package repository;

import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DischargeDAO {

    public boolean dischargeAndPay(int patientId, double hospitalFee) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            double balance = 0;
            String selectBalanceSQL = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            try (PreparedStatement psSelect = conn.prepareStatement(selectBalanceSQL)) {
                psSelect.setInt(1, patientId);
                try (ResultSet rs = psSelect.executeQuery()) {
                    if (rs.next()) {
                        balance = rs.getDouble("balance");
                    } else {
                        throw new Exception("Bệnh nhân không tồn tại!"); // Bẫy 2
                    }
                }
            }

            if (balance < hospitalFee) {
                throw new Exception("Số dư tạm ứng không đủ!");
            }

            String updateWalletSQL = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            try (PreparedStatement psUpdateWallet = conn.prepareStatement(updateWalletSQL)) {
                psUpdateWallet.setDouble(1, hospitalFee);
                psUpdateWallet.setInt(2, patientId);
                int rows = psUpdateWallet.executeUpdate();
                if (rows == 0) {
                    throw new Exception("Không cập nhật được số dư!");
                }
            }

            String updateBedSQL = "UPDATE Beds SET status = 'Empty' WHERE patient_id = ?";
            try (PreparedStatement psUpdateBed = conn.prepareStatement(updateBedSQL)) {
                psUpdateBed.setInt(1, patientId);
                int rows = psUpdateBed.executeUpdate();
                if (rows == 0) {
                    throw new Exception("Không cập nhật được trạng thái giường!"); // Bẫy 2
                }
            }

            String updatePatientSQL = "UPDATE Patients SET status = 'Discharged' WHERE patient_id = ?";
            try (PreparedStatement psUpdatePatient = conn.prepareStatement(updatePatientSQL)) {
                psUpdatePatient.setInt(1, patientId);
                int rows = psUpdatePatient.executeUpdate();
                if (rows == 0) {
                    throw new Exception("Không cập nhật được trạng thái bệnh nhân!"); // Bẫy 2
                }
            }

            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công!");
            return true;

        } catch (Exception e) {
            e.printStackTrace();

            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback giao dịch do lỗi!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;

        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
