package service;
import repository.SurgeryDAO;
import java.math.BigDecimal;
public class SurgeryService {
    private SurgeryDAO dao = new SurgeryDAO();

    public BigDecimal getSurgeryFee(String surgeryId) {
        if (surgeryId.isBlank()) {
            System.out.println("Mã phẫu thuật không được để trống!");
            return null;
        }
        return dao.getSurgeryFee(surgeryId);
    }
}
