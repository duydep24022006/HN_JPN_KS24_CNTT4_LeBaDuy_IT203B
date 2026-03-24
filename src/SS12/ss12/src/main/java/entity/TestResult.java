package entity;

public class TestResult {
    private String patientId;
    private String testId;
    private double value;

    public TestResult(String patientId, String testId, double value) {
        this.patientId = patientId;
        this.testId = testId;
        this.value = value;
    }

    public String getPatientId() { return patientId; }
    public String getTestId() { return testId; }
    public double getValue() { return value; }
}
