package SS7.Ex5.model;

import java.util.*;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items=new ArrayList<>();

    public Order(String id,Customer customer){
        this.id=id;
        this.customer=customer;
    }

    public void addItem(Product p,int qty){
        items.add(new OrderItem(p,qty));
    }

    public List<OrderItem> getItems(){ return items; }
    public String getId(){ return id; }
    public Customer getCustomer(){ return customer; }
}
