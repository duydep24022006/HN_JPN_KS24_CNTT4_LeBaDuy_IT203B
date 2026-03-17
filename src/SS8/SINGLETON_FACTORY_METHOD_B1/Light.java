package SINGLETON_FACTORY_METHOD_B1;

// Lớp Đèn triển khai từ Device
public class Light implements Device {

    // Khi bật đèn
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    // Khi tắt đèn
    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}