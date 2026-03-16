package SS6;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets;

    public TicketPool(String roomName, int count) {

        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));

        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {

                t.setSold(true);
                return t;

            }
        }

        return null;
    }

    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {

            String id = roomName + "-" + String.format("%03d", start + i);
            tickets.add(new Ticket(id, roomName));

        }

    }

    public synchronized int getRemainingTickets() {

        int count = 0;

        for (Ticket t : tickets) {

            if (!t.isSold())
                count++;

        }

        return count;
    }
}