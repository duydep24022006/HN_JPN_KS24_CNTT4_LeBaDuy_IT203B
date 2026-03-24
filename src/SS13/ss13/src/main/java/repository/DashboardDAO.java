package repository;

import entity.PatientDTO;
import entity.Service;
import utility.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DashboardDAO {

    public List<PatientDTO> getPatientsWithServices(String department) {
        List<PatientDTO> result = new ArrayList<>();
        Map<String, PatientDTO> map = new LinkedHashMap<>(); // preserve insertion order

        String sql = "SELECT p.patient_id, p.name, p.age, p.department, " +
                "s.service_name, s.quantity, s.service_time " +
                "FROM Patients p " +
                "LEFT JOIN PatientServices s ON p.patient_id = s.patient_id " +
                "WHERE p.department = ? AND p.admission_date = CURDATE()";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, department);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String patientId = rs.getString("patient_id");

                    PatientDTO patient = map.get(patientId);
                    if (patient == null) {
                        patient = new PatientDTO();
                        patient.setPatientId(patientId);
                        patient.setName(rs.getString("name"));
                        patient.setAge(rs.getInt("age"));
                        patient.setDepartment(rs.getString("department"));
                        map.put(patientId, patient);
                    }

                    String serviceName = rs.getString("service_name");
                    if (serviceName != null) {
                        Service service = new Service();
                        service.setServiceName(serviceName);
                        service.setQuantity(rs.getInt("quantity"));
                        service.setServiceTime(rs.getTimestamp("service_time"));
                        patient.getServices().add(service);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        result.addAll(map.values());
        return result;
    }
}
