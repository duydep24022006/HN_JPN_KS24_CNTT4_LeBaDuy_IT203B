package SS2.Ex2;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> checkPassword=password->password.length()>=8;
        System.out.println(checkPassword.test("12345678"));
        System.out.println(checkPassword.test("1234"));

    }
}
