package Bt5;

public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String department;
    private String diagnosis;

    public Patient(String patientId, String name, int age, String department, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}
