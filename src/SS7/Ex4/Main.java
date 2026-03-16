package SS7.Ex4;

public class Main {

    public static void main(String[] args) {

        OrderRepository repo = new FileOrderRepository();

        NotificationService notify = new EmailService();

        OrderService service =
                new OrderService(repo, notify);

        service.createOrder("ORD001", "user@email.com");

    }
}
