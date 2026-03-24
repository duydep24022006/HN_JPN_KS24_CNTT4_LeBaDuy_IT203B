package B2;

import repository.WalletDAO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WalletDAO dao = new WalletDAO();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n=== QUẢN LÝ THANH TOÁN VIỆN PHÍ ===");
            System.out.println("1. Xem ví bệnh nhân");
            System.out.println("2. Thanh toán hóa đơn");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập Patient ID: ");
                    String pid = sc.nextLine();
                    dao.printWallet(pid);
                    break;
                case 2:
                    System.out.print("Nhập Patient ID: ");
                    String patientId = sc.nextLine();
                    System.out.print("Nhập Invoice ID: ");
                    String invoiceId = sc.nextLine();
                    System.out.print("Nhập số tiền cần thanh toán: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    dao.payInvoice(patientId, invoiceId, amount);
                    break;
                case 3:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);

        sc.close();
    }
}
