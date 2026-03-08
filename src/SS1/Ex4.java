package SS1;

import java.io.IOException;

public class Ex4 {
    public static void main(String[] args) {
        try{
            processUserData();
        }catch (IOException e){
            System.out.println("Lỗi xảy ra: " + e.getMessage());
        }
        System.out.println("Chương trình vẫn tiếp tục chạy.");

    }
    public static void saveToFile() throws IOException{
        System.out.println("Đang lưu dữ liệu vào file...");

        throw  new IOException("Lỗi ghi file");

    }
    public static void processUserData() throws  IOException{
        System.out.println("Đang sử lý dữ liệu người dùng...");
        saveToFile();
    }

}
