package DemoHack;

import java.util.*;
import java.util.stream.Collectors;

// Lớp xử lý nghiệp vụ
public class UserBusiness {

    // Danh sách user
    private List<User> users = new ArrayList<>();

    // Singleton Pattern
    private static UserBusiness instance;

    private UserBusiness() {
    }

    public static UserBusiness getInstance() {
        if (instance == null) {
            instance = new UserBusiness();
        }
        return instance;
    }

    // Hiển thị danh sách
    public void displayList() {

        if (users.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return;
        }

        System.out.println("ID     Name            Age   Role       Score");

        users.forEach(User::displayData); // Lambda
    }

    // Thêm user
    public void addUser(User user) {

        boolean exist = users.stream()
                .anyMatch(u -> u.getUserId().equalsIgnoreCase(user.getUserId()));

        if (exist) {
            System.out.println("Mã người dùng đã tồn tại");
        } else {
            users.add(user);
            System.out.println("Thêm thành công");
        }
    }

    // Cập nhật user
    public void updateUser(String id, Scanner scanner) {

        Optional<User> optionalUser = users.stream()
                .filter(u -> u.getUserId().equalsIgnoreCase(id))
                .findFirst();

        if (!optionalUser.isPresent()) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
            return;
        }

        User user = optionalUser.get();

        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa tuổi");
        System.out.println("3. Sửa role");
        System.out.println("4. Sửa score");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {

            case 1:
                System.out.print("Nhập tên mới: ");
                user.setUserName(scanner.nextLine());
                break;

            case 2:
                System.out.print("Nhập tuổi mới: ");
                user.setAge(Integer.parseInt(scanner.nextLine()));
                break;

            case 3:
                System.out.print("Nhập role mới: ");
                user.setRole(scanner.nextLine());
                break;

            case 4:
                System.out.print("Nhập score mới: ");
                user.setScore(Double.parseDouble(scanner.nextLine()));
                break;
        }

        System.out.println("Cập nhật thành công");
    }

    // Xóa user
    public void deleteUser(String id) {

        int oldSize = users.size();

        users.removeIf(u -> u.getUserId().equalsIgnoreCase(id));

        if (users.size() == oldSize) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
        } else {
            System.out.println("Xóa thành công");
        }
    }

    // Tìm theo tên
    public void searchByName(String name) {

        List<User> result = users.stream()
                .filter(u -> u.getUserName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy");
            return;
        }

        result.forEach(User::displayData);

        System.out.println("Tổng kết quả: " + result.size());
    }

    // Lọc ADMIN
    public void filterAdmin() {

        List<User> admins = users.stream()
                .filter(u -> u.getRole().equalsIgnoreCase("ADMIN"))
                .collect(Collectors.toList());

        admins.forEach(User::displayData);
    }

    // Sắp xếp score giảm dần
    public void sortByScoreDesc() {

        users = users.stream()
                .sorted((a, b) -> Double.compare(b.getScore(), a.getScore()))
                .collect(Collectors.toList());

        System.out.println("Danh sách sau khi sắp xếp:");

        displayList();
    }
}