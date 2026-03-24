package B3;

import repository.DischargeDAO;
import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    private static final DischargeDAO dischargeDAO = new DischargeDAO();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    handleDischarge();
                    break;
                case 2:
                    handleCheckBalance();
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Goodbye!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Chọn lại.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== Rikkei Hospital - Discharge Module =====");
        System.out.println("1. Discharge & Pay");
        System.out.println("2. Check Patient Wallet");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");
    }

    private static void handleDischarge() {
        try {
            System.out.print("Enter patient ID: ");
            int patientId = Integer.parseInt(sc.nextLine());
            System.out.print("Enter hospital fee: ");
            double fee = Double.parseDouble(sc.nextLine());

            boolean success = dischargeDAO.dischargeAndPay(patientId, fee);
            if (success) {
                System.out.println("Giao dịch hoàn tất thành công!");
            } else {
                System.out.println("Giao dịch thất bại. Kiểm tra log lỗi.");
            }

        } catch (Exception e) {
            System.out.println("Nhập liệu sai! " + e.getMessage());
        }
    }

    private static void handleCheckBalance() {
        try {
            System.out.print("Enter patient ID: ");
            int patientId = Integer.parseInt(sc.nextLine());

            try (Connection conn = DBContext.getConnection()) {
                String sql = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, patientId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            double balance = rs.getDouble("balance");
                            System.out.println("Patient ID: " + patientId + " - Balance: " + balance);
                        } else {
                            System.out.println("Bệnh nhân không tồn tại!");
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi khi kiểm tra số dư: " + e.getMessage());
        }
    }
}
