package SINGLETON_FACTORY_METHOD_B1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Scanner để nhập dữ liệu
        Scanner sc = new Scanner(System.in);

        // Danh sách lưu các thiết bị đã tạo
        List<Device> devices = new ArrayList<>();

        while (true) {

            // Menu chương trình
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                // Kết nối phần cứng
                case 1:
                    HardwareConnection.getInstance();
                    break;

                // Tạo thiết bị mới
                case 2:

                    System.out.println("Chọn loại:");
                    System.out.println("1. Đèn");
                    System.out.println("2. Quạt");
                    System.out.println("3. Điều hòa");

                    int type = sc.nextInt();

                    DeviceFactory factory = null;

                    // Chọn factory tương ứng
                    if (type == 1)
                        factory = new LightFactory();
                    if (type == 2)
                        factory = new FanFactory();
                    if (type == 3)
                        factory = new AirConditionerFactory();

                    // Nếu factory tồn tại thì tạo thiết bị
                    if (factory != null) {
                        Device device = factory.createDevice();

                        // Lưu vào danh sách
                        devices.add(device);
                    }

                    break;

                // Bật thiết bị
                case 3:

                    if (devices.size() == 0) {
                        System.out.println("Chưa có thiết bị.");
                        break;
                    }

                    System.out.println("Chọn thiết bị:");
                    int on = sc.nextInt();

                    // Bật thiết bị theo vị trí
                    devices.get(on - 1).turnOn();
                    break;

                // Tắt thiết bị
                case 4:

                    if (devices.size() == 0) {
                        System.out.println("Chưa có thiết bị.");
                        break;
                    }

                    System.out.println("Chọn thiết bị:");
                    int off = sc.nextInt();

                    // Tắt thiết bị
                    devices.get(off - 1).turnOff();
                    break;

                // Thoát chương trình
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}