package SS7.Ex5;

import SS7.Ex5.model.Customer;
import SS7.Ex5.model.Order;
import SS7.Ex5.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    addProduct(sc);
                    break;

                case 2:
                    addCustomer(sc);
                    break;

                case 3:
                    createOrder(sc);
                    break;

                case 4:
                    showOrders();
                    break;

                case 5:
                    calculateRevenue();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ");

            }

        }
    }
    static void addProduct(Scanner sc){

        System.out.print("Mã: ");
        String id = sc.nextLine();

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Danh mục: ");
        String category = sc.nextLine();

        Product p = new Product(id,name,price,category);

        products.add(p);

        System.out.println("Đã thêm sản phẩm "+id);

    }
    static void addCustomer(Scanner sc){

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("SĐT: ");
        String phone = sc.nextLine();

        Customer c = new Customer(name,email,phone);

        customers.add(c);

        System.out.println("Đã thêm khách hàng");

    }
}
