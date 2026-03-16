package SS7.Ex1;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private Map<String, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getOrderId(), order);
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }

    public Order findById(String id) {
        return orders.get(id);
    }
}

