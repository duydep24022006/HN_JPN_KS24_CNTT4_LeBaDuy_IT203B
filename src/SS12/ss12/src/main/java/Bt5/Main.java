package Bt5;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static PatientDAO dao = new PatientDAO();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Rikkei-Hospital RHMS ===");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân mới");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & Tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    showPatients();
                    break;
                case "2":
                    addPatient();
                    break;
                case "3":
                    updateDiagnosis();
                    break;
                case "4":
                    dischargePatient();
                    break;
                case "5":
                    System.out.println("Thoát chương trình...");
                    return;
                default:
                    System.out.println("Chọn sai! Thử lại.");
            }
        }
    }

    private static void showPatients() {
        List<Patient> list = dao.getAllPatients();
        System.out.println("Mã BN | Tên | Tuổi | Khoa | Bệnh án");
        for (Patient p : list) {
            System.out.printf("%s | %s | %d | %s | %s\n",
                    p.getPatientId(), p.getName(), p.getAge(),
                    p.getDepartment(), p.getDiagnosis());
        }
    }

    private static void addPatient() {
        System.out.print("Mã bệnh nhân: ");
        String id = sc.nextLine().trim();

        System.out.print("Tên bệnh nhân: ");
        String name = sc.nextLine().trim(); // xử lý dấu nháy tự động bởi PreparedStatement

        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Khoa: ");
        String dept = sc.nextLine().trim();

        System.out.print("Bệnh án: ");
        String diag = sc.nextLine().trim();

        Patient p = new Patient(id, name, age, dept, diag);
        if (dao.addPatient(p)) {
            System.out.println("Thêm bệnh nhân thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập mã bệnh nhân cần cập nhật: ");
        String id = sc.nextLine().trim();

        System.out.print("Nhập bệnh án mới: ");
        String diag = sc.nextLine().trim();

        if (dao.updateDiagnosis(id, diag)) {
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }

    private static void dischargePatient() {
        System.out.print("Nhập mã bệnh nhân xuất viện: ");
        String id = sc.nextLine().trim();

        System.out.print("Số ngày nhập viện: ");
        int days = Integer.parseInt(sc.nextLine().trim());

        double fee = dao.calculateDischargeFee(id, days);
        if (fee >= 0) {
            System.out.println("Tổng phí viện: " + fee + " VND");
        } else {
            System.out.println("Không thể tính phí!");
        }
    }
}
