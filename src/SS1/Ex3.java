package SS1;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tuổi");
        int age=sc.nextInt();
        Ex3 user=new Ex3();
        user.setAge(age);
        System.out.println("Tuổi đã lưu: "+user.getAge());
        sc.close();
    }
    private int age;

    public void setAge(int age){
        if(age<0){
            throw new IllegalArgumentException("Tuổi không thể âm!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
