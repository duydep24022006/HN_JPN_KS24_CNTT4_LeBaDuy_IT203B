package SS7.Ex4;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository,
                        NotificationService notification) {

        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(String id, String recipient) {

        Order order = new Order(id);

        repository.save(order);

        notification.send(
                "Đơn hàng " + id + " đã được tạo",
                recipient
        );
    }
}
