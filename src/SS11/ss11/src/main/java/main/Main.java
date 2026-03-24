package main;

import entity.Doctor;
import repository.BedDAO;
import repository.MedicineDAO;
import repository.PatientDAO;
import service.DoctorService;

import java.util.List;
import java.util.Scanner;
public class Main {
//    public static void main(String[] args) {
////        MedicineDAO dao = new MedicineDAO();
////        dao.prinMedicineList();
//
////        BedDAO dao = new BedDAO();
////
////        dao.updateBedStatus("Bed_001");
////        dao.updateBedStatus("Bed_999");
//
////        PatientDAO dao = new PatientDAO();
////        dao.searchPatient("' OR '1'='1");
//
//
//    }
    private static DoctorService service = new DoctorService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> showDoctors();
                case "2" -> addDoctor();
                case "3" -> service.showSpecialtyStats();
                case "4" -> {
                    System.out.println("Thoát chương trình. Bye!");
                    return;
                }
                default -> System.out.println("Chọn không hợp lệ, thử lại.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== HỆ THỐNG QUẢN LÝ BÁC SĨ RIKKEI-CARE =====");
        System.out.println("1. Xem danh sách bác sĩ");
        System.out.println("2. Thêm bác sĩ mới");
        System.out.println("3. Thống kê chuyên khoa");
        System.out.println("4. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static void showDoctors() {
        List<Doctor> list = service.getDoctors();
        System.out.printf("%-10s | %-20s | %-15s\n", "Mã số", "Họ tên", "Chuyên khoa");
        System.out.println("--------------------+----------------------+---------------");
        list.forEach(System.out::println);
    }

    private static void addDoctor() {
        System.out.print("Nhập mã bác sĩ: ");
        String id = sc.nextLine().trim();
        System.out.print("Nhập họ tên: ");
        String name = sc.nextLine().trim();
        System.out.print("Nhập chuyên khoa: ");
        String specialty = sc.nextLine().trim();

        if (service.addDoctor(id, name, specialty)) {
            System.out.println("Thêm bác sĩ thành công!");
        } else {
            System.out.println("Thêm bác sĩ thất bại.");
        }
    }
}
