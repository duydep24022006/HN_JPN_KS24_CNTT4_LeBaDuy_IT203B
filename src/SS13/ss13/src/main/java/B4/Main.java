package B4;

import repository.DashboardDAO;
import entity.PatientDTO;
import entity.Service;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DashboardDAO dao = new DashboardDAO();

        String department = "ICU";
        List<PatientDTO> patients = dao.getPatientsWithServices(department);

        System.out.println("=== Patient Dashboard - Department: " + department + " ===");
        for (PatientDTO patient : patients) {
            System.out.println("Patient ID: " + patient.getPatientId());
            System.out.println("Name      : " + patient.getName());
            System.out.println("Age       : " + patient.getAge());
            System.out.println("Department: " + patient.getDepartment());

            List<Service> services = patient.getServices();
            if (services.isEmpty()) {
                System.out.println("Services  : No services recorded today");
            } else {
                System.out.println("Services  : ");
                for (Service service : services) {
                    System.out.println("  - " + service.getServiceName() +
                            " | Quantity: " + service.getQuantity() +
                            " | Time: " + service.getServiceTime());
                }
            }
            System.out.println("-----------------------------------------");
        }
    }
}
