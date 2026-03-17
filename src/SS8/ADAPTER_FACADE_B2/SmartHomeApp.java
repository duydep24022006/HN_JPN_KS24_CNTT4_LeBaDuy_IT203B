package ADAPTER_FACADE_B2;

import java.util.Scanner;

public class SmartHomeApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Tạo cảm biến cũ
        OldThermometer oldThermometer = new OldThermometer();

        // Dùng Adapter để chuyển sang interface mới
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);

        // Tạo Facade
        SmartHomeFacade home = new SmartHomeFacade(sensor);

        while (true) {
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("4. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    home.getCurrentTemperature();
                    break;

                case 2:
                    home.leaveHome();
                    break;

                case 3:
                    home.sleepMode();
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}