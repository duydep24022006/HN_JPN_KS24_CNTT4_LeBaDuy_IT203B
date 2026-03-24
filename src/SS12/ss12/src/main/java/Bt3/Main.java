package Bt3;

import service.SurgeryService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static SurgeryService service = new SurgeryService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== TRA CỨU CHI PHÍ PHẪU THUẬT ===");

        System.out.print("Nhập mã phẫu thuật: ");
        String surgeryId = sc.nextLine().trim();

        BigDecimal fee = service.getSurgeryFee(surgeryId);
        if (fee != null) {
            System.out.println("Tổng chi phí phẫu thuật: " + fee + " VND");
        } else {
            System.out.println("Không tìm thấy thông tin phẫu thuật hoặc lỗi!");
        }
    }
}
