package SS6;

public class Ex2 {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A",10);
        TicketPool roomB = new TicketPool("B",10);

        Thread counter1 = new Thread(
                new BookingCounter("Quầy 1",roomA,roomB));

        Thread counter2 = new Thread(
                new BookingCounter("Quầy 2",roomA,roomB));

        Thread supplier = new Thread(
                new TicketSupplier(roomA,roomB,3,3000,3));

        counter1.start();
        counter2.start();
        supplier.start();

    }
}
