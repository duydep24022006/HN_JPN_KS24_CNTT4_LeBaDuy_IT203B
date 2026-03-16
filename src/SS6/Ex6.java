package SS6;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketPool roomA = new TicketPool("A",10);
        TicketPool roomB = new TicketPool("B",10);

        Thread counter1 = new Thread(
                new BookingCounter("Quầy 1",roomA,roomB));

        Thread counter2 = new Thread(
                new BookingCounter("Quầy 2",roomA,roomB));

        Thread supplier = new Thread(
                new TicketSupplier(roomA,roomB,3,3000,5));

        while(true){

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Thêm vé");
            System.out.println("3. Thống kê");
            System.out.println("4. Thoát");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    counter1.start();
                    counter2.start();
                    supplier.start();

                    break;

                case 2:

                    roomA.addTickets(2);
                    roomB.addTickets(2);

                    System.out.println("Đã thêm vé");

                    break;

                case 3:

                    System.out.println("Vé còn phòng A: "
                            + roomA.getRemainingTickets());

                    System.out.println("Vé còn phòng B: "
                            + roomB.getRemainingTickets());

                    break;

                case 4:

                    System.exit(0);

            }

        }

    }
}
