package SS7.Ex5.service;

import SS7.Ex5.model.Order;
import SS7.Ex5.model.OrderItem;

public class InvoiceGenerator {

    public void generate(Order order, double total){

        System.out.println("=== HÓA ĐƠN ===");

        System.out.println("Khách: "+order.getCustomer().getName());

        for(OrderItem item:order.getItems()){

            System.out.println(
                    item.getProduct().getName()+
                            " - Số lượng: "+item.getQuantity()+
                            " - Đơn giá: "+item.getProduct().getPrice()+
                            " - Thành tiền: "+item.getTotal()
            );
        }

        System.out.println("Cần thanh toán: "+total);
    }
}
