package SS3.Ex3;

public class Main {
    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        var result = repo.findUserByUsername("alice");

        result.ifPresent(user ->
                System.out.println("Welcome " + user.username())
        );

        System.out.println(
                result.map(user -> "")
                        .orElse("Guest login")
        );
    }
}
