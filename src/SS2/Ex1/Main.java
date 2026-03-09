package SS2.Ex1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("admin", "ADMIN");
        Predicate<User> isAdmin=user->user.getRole().equals("ADMIN");
        Function<User,String> getUserName=user->user.getUserName();
        Consumer<User> printUser=user -> System.out.println(user);
        Supplier<User> createUser=()->new User("guest", "123456");
        System.out.println(isAdmin.test(user1));     // Predicate

        System.out.println(getUserName.apply(user1)); // Function

        printUser.accept(user1);                     // Consumer

        User newUser = createUser.get();            // Supplier
        System.out.println(newUser);
    }


}
