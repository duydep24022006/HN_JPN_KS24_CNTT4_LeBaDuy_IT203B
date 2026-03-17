package DemoHack;

import java.util.Scanner;

public class UserManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserBusiness business = UserBusiness.getInstance();

        while (true) {

            System.out.println("\n*********** QUẢN LÝ NGƯỜI DÙNG ***********");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm người dùng");
            System.out.println("3. Cập nhật người dùng");
            System.out.println("4. Xóa người dùng");
            System.out.println("5. Tìm theo tên");
            System.out.println("6. Lọc ADMIN");
            System.out.println("7. Sắp xếp theo score giảm dần");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    business.displayList();
                    break;

                case 2:

                    User user = new User();
                    user.inputData(scanner);

                    business.addUser(user);
                    break;

                case 3:

                    System.out.print("Nhập ID cần sửa: ");
                    String idUpdate = scanner.nextLine();

                    business.updateUser(idUpdate, scanner);
                    break;

                case 4:

                    System.out.print("Nhập ID cần xóa: ");
                    String idDelete = scanner.nextLine();

                    business.deleteUser(idDelete);
                    break;

                case 5:

                    System.out.print("Nhập tên cần tìm: ");
                    String name = scanner.nextLine();

                    business.searchByName(name);
                    break;

                case 6:
                    business.filterAdmin();
                    break;

                case 7:
                    business.sortByScoreDesc();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}