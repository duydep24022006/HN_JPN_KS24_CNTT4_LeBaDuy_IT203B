package SS3.Ex5;

import java.util.List;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alexander", "alex@gmail.com", "ACTIVE"),
                new User("charlotte", "char@gmail.com", "ACTIVE"),
                new User("Benjamin", "ben@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "INACTIVE"),
                new User("anna", "anna@gmail.com", "ACTIVE")
        );

        users.stream()
                .sorted(Comparator.comparingInt((User user) -> user.username().length()).reversed())
                .limit(3)
                .forEach(user -> System.out.println(user.username()));
    }
}
