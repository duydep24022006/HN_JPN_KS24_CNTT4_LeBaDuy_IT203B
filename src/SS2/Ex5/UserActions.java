package SS2.Ex5;

public interface UserActions {
    default void logActivity(String activity){
        System.out.println("User activity: " + activity);
    }
}
