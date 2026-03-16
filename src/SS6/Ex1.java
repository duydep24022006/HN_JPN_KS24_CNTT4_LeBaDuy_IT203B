package SS6;

public class Ex1 {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A",10);
        TicketPool roomB = new TicketPool("B",10);

        Thread t1 = new Thread(
                new BookingCounter("Quầy 1",roomA,roomB));

        Thread t2 = new Thread(
                new BookingCounter("Quầy 2",roomA,roomB));

        t1.start();
        t2.start();

    }
}
