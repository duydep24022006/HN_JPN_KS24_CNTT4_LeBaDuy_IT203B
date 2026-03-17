package COMMAND_OBSERVER_B4;

import COMMAND_OBSERVER_B4.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TemperatureSensor sensor = new TemperatureSensor();

        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        while (true) {
            System.out.println("1. Đăng ký quạt");
            System.out.println("2. Đăng ký máy tạo ẩm");
            System.out.println("3. Thay đổi nhiệt độ");
            System.out.println("4. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    sensor.attach(fan);
                    System.out.println("Quạt: Đã đăng ký nhận thông báo");
                    break;

                case 2:
                    sensor.attach(humidifier);
                    System.out.println("May tao am: Đã đăng ký nhận thông báo");
                    break;

                case 3:
                    System.out.println("Nhap nhiet do");
                    int temp = Integer.parseInt(scanner.nextLine());
                    sensor.setTemperature(temp);
                    break;

                case 4:
                    System.exit(0);

            }

        }
    }

}
