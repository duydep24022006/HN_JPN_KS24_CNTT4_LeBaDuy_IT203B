package COMMAND_REMOTE_B3;

import java.util.Scanner;

public class RemoteApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // tạo thiết bị
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // tạo remote
        RemoteControl remote = new RemoteControl();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Gán nút");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("4. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Chọn nút:");
                    int slot = sc.nextInt();

                    System.out.println("Chọn lệnh:");
                    System.out.println("1. Bật đèn");
                    System.out.println("2. Tắt đèn");
                    System.out.println("3. Bật quạt");
                    System.out.println("4. Tắt quạt");
                    System.out.println("5. Set điều hòa");

                    int cmd = sc.nextInt();

                    if (cmd == 1)
                        remote.setCommand(slot, new LightOnCommand(light));

                    if (cmd == 2)
                        remote.setCommand(slot, new LightOffCommand(light));

                    if (cmd == 3)
                        remote.setCommand(slot, new FanOnCommand(fan));

                    if (cmd == 4)
                        remote.setCommand(slot, new FanOffCommand(fan));

                    if (cmd == 5) {
                        System.out.println("Nhập nhiệt độ:");
                        int t = sc.nextInt();
                        remote.setCommand(slot, new ACSetTemperatureCommand(ac, t));
                    }

                    break;

                case 2:

                    System.out.println("Nhấn nút:");
                    int b = sc.nextInt();

                    remote.pressButton(b);
                    break;

                case 3:

                    remote.undo();
                    break;

                case 4:

                    System.out.println("Thoát.");
                    return;
            }
        }
    }
}