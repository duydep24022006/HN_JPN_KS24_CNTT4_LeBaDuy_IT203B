package service;

import repository.PatientDAO;

public class PatientService {
    private PatientDAO dao = new PatientDAO();

    public boolean updateVitals(String patientId, double temperature, int heartRate) {
        if (patientId.isBlank()) {
            System.out.println("Mã bệnh nhân không được để trống!");
            return false;
        }
        if (temperature < 30 || temperature > 45) {
            System.out.println("Nhiệt độ nhập không hợp lệ!");
            return false;
        }
        if (heartRate < 30 || heartRate > 200) {
            System.out.println("Nhịp tim nhập không hợp lệ!");
            return false;
        }
        return dao.updateVitals(patientId, temperature, heartRate);
    }
}
