package SS1.Ex6;

public class Ex6 {
    public static void main(String[] args) {
        try {
            User user = new User("An", 15);
            user.printUser();

        } catch (InvalidAgeException e) {

            Logger.logError(e.getMessage());

            e.printStackTrace();

        }

    }
}
