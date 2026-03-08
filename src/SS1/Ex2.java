package SS1;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try{
           int tongSoNguoi=sc.nextInt();
            System.out.println("Nhập số người: ");
           int soNhom=sc.nextInt();
            System.out.println("Nhập số nhóm: ");
           int soNguoiMotNhom=tongSoNguoi/soNhom;
            System.out.println("Mỗi nhóm có "+ soNguoiMotNhom+" người");
        }catch (ArithmeticException  e){
            System.out.println("Không thể chia cho 0!");
        }
        System.out.println("kết thúc chương trình");
    }
}
