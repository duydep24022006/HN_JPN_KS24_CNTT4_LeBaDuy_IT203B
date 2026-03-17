package SINGLETON_FACTORY_METHOD_B1;

// Lớp Điều hòa triển khai từ Device
class AirConditioner implements Device {

    public void turnOn() {
        System.out.println("Điều hòa: Bật.");
    }

    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}