package service;

import entity.Doctor;
import repository.DoctorDAO;

public class DoctorService {
    private repository.DoctorDAO dao = new DoctorDAO();

    public Doctor login(String code, String password) {
        if (code.isBlank() || password.isBlank()) {
            System.out.println("Không được để trống mã số hoặc mật khẩu!");
            return null;
        }
        if (code.length() > 10) {
            System.out.println("Mã bác sĩ tối đa 10 ký tự!");
            return null;
        }
        return dao.login(code, password);
    }
}