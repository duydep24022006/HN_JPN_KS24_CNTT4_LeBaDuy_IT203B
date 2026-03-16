package SS6;

public class Ex5 {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A",20);
        TicketPool roomB = new TicketPool("B",20);

        for(int i=1;i<=5;i++){

            Thread t = new Thread(
                    new BookingCounter("Quầy "+i,roomA,roomB));

            t.start();
        }

    }
}
