package lesson3;

public class Main {
    public static void main(String[] args) {
        lesson3.BedDAO dao = new lesson3.BedDAO();

        dao.updateBedStatus("Bed_001"); // có thể tồn tại
        dao.updateBedStatus("Bed_999"); // test lỗi
    }
}