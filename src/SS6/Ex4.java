package SS6;

public class Ex4 {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A",5);
        TicketPool roomB = new TicketPool("B",5);

        Thread t1 = new Thread(
                new BookingCounter("Quầy 1",roomA,roomB));

        Thread t2 = new Thread(
                new BookingCounter("Quầy 2",roomA,roomB));

        Thread supplier = new Thread(
                new TicketSupplier(roomA,roomB,3,3000,5));

        t1.start();
        t2.start();
        supplier.start();

    }
}
