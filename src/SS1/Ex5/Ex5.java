package SS1.Ex5;

public class Ex5 {

    public static void main(String[] args) {
        User user = new User();
        try {
            user.setAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Lỗi nghiệp vụ: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
