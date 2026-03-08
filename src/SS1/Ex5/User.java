package SS1.Ex5;

public class User {

    private String name;
    private int age;

    public void setAge(int age) throws InvalidAgeException {

        if(age < 18){
            throw new InvalidAgeException("Tuổi phải >= 18 để đăng ký.");
        }

        this.age = age;
    }

}