package SS2.Ex3;

public class Student implements Authenticatable{
    private String password;

    public Student(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return password;
    }
}
