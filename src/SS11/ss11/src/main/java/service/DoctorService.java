package service;



import entity.Doctor;
import repository.DoctorDAO;

import java.util.List;
import java.util.Map;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public List<Doctor> getDoctors() {
        return dao.getAllDoctors();
    }

    public boolean addDoctor(String id, String name, String specialty) {
        // Validate dữ liệu
        if (id.isBlank() || name.isBlank() || specialty.isBlank()) {
            System.out.println("Không được để trống thông tin!");
            return false;
        }
        if (id.length() > 10) {
            System.out.println("Mã bác sĩ tối đa 10 ký tự.");
            return false;
        }
        if (name.length() > 50 || specialty.length() > 50) {
            System.out.println("Họ tên hoặc chuyên khoa vượt quá độ dài.");
            return false;
        }

        Doctor doctor = new Doctor(id, name, specialty);
        return dao.addDoctor(doctor);
    }

    public void showSpecialtyStats() {
        Map<String, Integer> stats = dao.getSpecialtyStats();
        System.out.printf("%-20s | %-5s\n", "Chuyên khoa", "Số lượng");
        System.out.println("---------------------|-------");
        stats.forEach((spec, count) -> System.out.printf("%-20s | %d\n", spec, count));
    }
}