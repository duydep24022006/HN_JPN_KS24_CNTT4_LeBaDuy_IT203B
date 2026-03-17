package DemoHack;

import java.util.Scanner;

// Lớp User lưu thông tin người dùng
public class User {

    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    // Constructor không tham số
    public User() {
    }

    // Constructor đầy đủ tham số
    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    // Getter Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("USER")) {
            this.role = role.toUpperCase();
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 10) {
            this.score = score;
        }
    }

    // Nhập dữ liệu
    public void inputData(Scanner scanner) {

        System.out.print("Nhập ID: ");
        userId = scanner.nextLine();

        System.out.print("Nhập tên: ");
        userName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Nhập tuổi (>=18): ");
                age = Integer.parseInt(scanner.nextLine());

                if (age >= 18) {
                    break;
                }
            } catch (Exception e) {
            }
        }

        while (true) {
            System.out.print("Nhập role (ADMIN/USER): ");
            role = scanner.nextLine().toUpperCase();

            if (role.equals("ADMIN") || role.equals("USER")) {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Nhập score (0-10): ");
                score = Double.parseDouble(scanner.nextLine());

                if (score >= 0 && score <= 10) {
                    break;
                }
            } catch (Exception e) {
            }
        }
    }

    // Hiển thị dữ liệu
    public void displayData() {
        System.out.printf("%-6s %-15s %-5d %-10s %-5.2f\n",
                userId, userName, age, role, score);
    }
}