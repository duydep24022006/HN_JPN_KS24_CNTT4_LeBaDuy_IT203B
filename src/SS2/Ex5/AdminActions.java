package SS2.Ex5;

public interface AdminActions {
    default void logActivity(String activity){
        System.out.println("Admin activity: " + activity);
    }

}
