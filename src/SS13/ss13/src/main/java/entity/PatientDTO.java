package entity;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO {
    private String patientId;
    private String name;
    private int age;
    private String department;
    private List<Service> services = new ArrayList<>();

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public List<Service> getServices() { return services; }
}
