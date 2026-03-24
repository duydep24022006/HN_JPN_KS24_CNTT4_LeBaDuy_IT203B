package Bt2;

import service.PatientService;

import java.util.Scanner;

public class Main {
    private static PatientService service = new PatientService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== CẬP NHẬT CHỈ SỐ SINH TỒN BỆNH NHÂN ===");

        System.out.print("Nhập mã bệnh nhân: ");
        String patientId = sc.nextLine().trim();

        System.out.print("Nhập nhiệt độ (°C): ");
        double temp = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Nhập nhịp tim (lần/phút): ");
        int hr = Integer.parseInt(sc.nextLine().trim());

        boolean success = service.updateVitals(patientId, temp, hr);
        if (success) {
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }
}