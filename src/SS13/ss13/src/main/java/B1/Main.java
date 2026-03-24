package B1;

import entity.Medicine;
import repository.MedicineDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedicineDAO dao = new MedicineDAO();
        int choice;

        do {
            System.out.println("\n=== Rikkei-Hospital Medicine Module ===");
            System.out.println("1. Xem kho thuốc");
            System.out.println("2. Cấp phát thuốc cho bệnh nhân");
            System.out.println("3. Xem lịch sử cấp phát thuốc");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    List<Medicine> list = dao.getAllMedicine();
                    System.out.println("Mã | Tên thuốc | Số lượng");
                    list.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Mã bệnh nhân: ");
                    String patientId = sc.nextLine();
                    System.out.print("Mã thuốc: ");
                    String medicineId = sc.nextLine();
                    System.out.print("Số lượng: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    dao.dispenseMedicine(medicineId, patientId, qty);
                    break;
                case 3:
                    dao.printPrescriptionHistory();
                    break;
                case 4:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 4);
    }
}
