package SS7.Ex5.service;


import SS7.Ex5.discount.DiscountStrategy;
import SS7.Ex5.model.Order;
import SS7.Ex5.model.OrderItem;
import SS7.Ex5.notification.NotificationService;
import SS7.Ex5.payment.PaymentMethod;
import SS7.Ex5.repository.OrderRepository;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository,
                        NotificationService notification){

        this.repository=repository;
        this.notification=notification;
    }

    public void processOrder(Order order,
                             DiscountStrategy discount,
                             PaymentMethod payment){

        double total=0;

        for(OrderItem item:order.getItems())
            total+=item.getTotal();

        double finalAmount=discount.apply(total);

        payment.pay(finalAmount);

        repository.save(order);

        notification.send(
                "Đơn hàng "+order.getId()+" đã được tạo",
                order.getCustomer().getEmail()
        );
    }
}
