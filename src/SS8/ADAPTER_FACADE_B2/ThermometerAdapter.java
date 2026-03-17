package ADAPTER_FACADE_B2;

// Adapter để chuyển cảm biến cũ sang interface mới
class ThermometerAdapter implements TemperatureSensor {

    private OldThermometer oldThermometer;

    // Constructor nhận cảm biến cũ
    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    // Chuyển đổi F -> C
    public double getTemperatureCelsius() {
        int f = oldThermometer.getTemperatureFahrenheit();
        double c = (f - 32) * 5.0 / 9;

        return c;
    }
}