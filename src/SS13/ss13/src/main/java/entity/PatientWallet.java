package entity;

public class PatientWallet {
    private String patientId;
    private double balance;

    public PatientWallet(String patientId, double balance) {
        this.patientId = patientId;
        this.balance = balance;
    }

    public String getPatientId() { return patientId; }
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return patientId + " | Balance: " + balance;
    }
}