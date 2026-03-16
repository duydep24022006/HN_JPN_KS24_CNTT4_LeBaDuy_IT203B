package SS6;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;

    private int soldCount = 0;

    Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {

        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;

    }

    @Override
    public void run() {

        while (true) {

            Ticket ticket;

            if (random.nextBoolean())
                ticket = roomA.sellTicket();
            else
                ticket = roomB.sellTicket();

            if (ticket != null) {

                soldCount++;

                System.out.println(counterName +
                        " đã bán vé " +
                        ticket.getTicketId());

            }

            if (roomA.getRemainingTickets() == 0 &&
                    roomB.getRemainingTickets() == 0)
                break;

        }

        System.out.println(counterName +
                " bán được " +
                soldCount + " vé");

    }
}
