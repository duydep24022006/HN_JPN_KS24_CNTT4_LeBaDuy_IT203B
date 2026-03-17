package COMMAND_REMOTE_B3;

public class AirConditioner {
    private int temperature = 25; // nhiệt độ mặc định

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temperature);
    }

    public int getTemperature() {
        return temperature;
    }

}
