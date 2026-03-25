package bt45p;

import bt45p.service.TransferService;
import bt45p.utity.DBContext;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBContext.getConnection()) {
            TransferService service = new TransferService(conn);

            service.transfer("ACC01", "ACC02", 1000);

            System.out.println("Chuyển tiền thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
