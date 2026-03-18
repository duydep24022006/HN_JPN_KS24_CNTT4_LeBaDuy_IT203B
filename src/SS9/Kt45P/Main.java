package SS9.Kt45P;

import SS9.Kt45P.Entity.Product;
import SS9.Kt45P.Factory.ProductFactory;
import SS9.Kt45P.servis.ProductDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("\n📝---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Loại sản phẩm (1-Physical, 2-Digital): ");
                    int type = sc.nextInt(); sc.nextLine();
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Tên: "); String name = sc.nextLine();
                    System.out.print("Giá: "); double price = sc.nextDouble();
                    System.out.print(type == 1 ? "Trọng lượng: " : "Dung lượng (MB): ");
                    double extra = sc.nextDouble();

                    Product p = ProductFactory.createProduct(type, id, name, price, extra);
                    db.addProduct(p);
                    break;

                case 2:
                    for (Product prod : db.getProducts()) {
                        prod.displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = sc.nextLine();
                    System.out.print("Loại sản phẩm (1-Physical, 2-Digital): ");
                    int updateType = sc.nextInt(); sc.nextLine();
                    System.out.print("Tên mới: "); String newName = sc.nextLine();
                    System.out.print("Giá mới: "); double newPrice = sc.nextDouble();
                    System.out.print(updateType == 1 ? "Trọng lượng mới: " : "Dung lượng mới (MB): ");
                    double newExtra = sc.nextDouble();

                    Product newProduct = ProductFactory.createProduct(updateType, updateId, newName, newPrice, newExtra);
                    db.updateProduct(updateId, newProduct);
                    break;

                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deleteId = sc.nextLine();
                    db.deleteProduct(deleteId);
                    break;

                case 5:
                    System.out.println("Thoát chương trình...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
