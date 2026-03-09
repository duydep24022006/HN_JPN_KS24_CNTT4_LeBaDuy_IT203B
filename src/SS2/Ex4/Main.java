package SS2.Ex4;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Function<User,String> getName= User::getFullName;
        Consumer<String> print = System.out::println;
        Supplier<User> newUser= User::new;

    }
}
