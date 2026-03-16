package SS7.Ex5.repository;

import SS7.Ex5.model.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();
}
