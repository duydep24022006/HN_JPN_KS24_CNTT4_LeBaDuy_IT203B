package SS1.Ex6;

public class User {

    private String name;
    private int age;

    public User(String name, int age) throws InvalidAgeException {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {

        // Defensive Programming
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }

    }

    public void setAge(int age) throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException("Tuổi phải >= 18 để đăng ký.");
        }

        this.age = age;
    }

    public void printUser() {

        // tránh NullPointerException bằng if
        if (name != null) {
            System.out.println("Tên: " + name);
        } else {
            System.out.println("Tên chưa được thiết lập");
        }

        System.out.println("Tuổi: " + age);
    }
}
