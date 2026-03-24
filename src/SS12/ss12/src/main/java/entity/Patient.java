package entity;

public class Patient {
    private String id;
    private String name;
    private double temperature;
    private int heartRate;

    public Patient() {}

    public Patient(String id, String name, double temperature, int heartRate) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
        this.heartRate = heartRate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-5.1f | %-3d", id, name, temperature, heartRate);
    }
}
