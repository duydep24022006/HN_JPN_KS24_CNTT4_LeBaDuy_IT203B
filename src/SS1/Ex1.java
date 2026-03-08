package SS1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            System.out.println("Nhập năm sinh của bạn: ");
            String yearString=sc.nextLine();
            int year=Integer.parseInt(yearString);
            int age=2026-year;
            System.out.println("Tuổi của bạn là: "+ age);
        }catch(NumberFormatException e){
            System.out.println("Bạn phải nhập số!");
        }finally{
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
            sc.close();
        }
    }

}
