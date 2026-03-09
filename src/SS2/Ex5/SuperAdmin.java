package SS2.Ex5;

public class SuperAdmin implements UserActions,AdminActions{
    @Override
    public  void logActivity(String activity){
        UserActions.super.logActivity(activity);
    }
}
