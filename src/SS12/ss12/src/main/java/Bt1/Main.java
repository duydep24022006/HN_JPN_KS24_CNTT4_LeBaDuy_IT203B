package Bt1;

import entity.Doctor;
import service.DoctorService;

import java.util.Scanner;

public class Main {
    private static DoctorService service = new DoctorService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG ĐĂNG NHẬP BÁC SĨ ===");

        System.out.print("Nhập mã bác sĩ: ");
        String code = sc.nextLine().trim();

        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine().trim();

        Doctor d = service.login(code, password);
        if (d != null) {
            System.out.println("Đăng nhập thành công! Chào bác sĩ: " + d.getName());
            System.out.println("Chuyên khoa: " + d.getSpecialty());
        } else {
            System.out.println("Đăng nhập thất bại. Sai mã số hoặc mật khẩu!");
        }
    }
}
