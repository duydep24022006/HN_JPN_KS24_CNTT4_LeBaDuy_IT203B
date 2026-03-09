package SS2.Ex3;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("12345678");
        Student student2 = new Student("");

        System.out.println(student1.isAuthenticated());
        System.out.println(student2.isAuthenticated());

        String encrypted = Authenticatable.encrypt("12345678");
        System.out.println(encrypted);
    }
}
