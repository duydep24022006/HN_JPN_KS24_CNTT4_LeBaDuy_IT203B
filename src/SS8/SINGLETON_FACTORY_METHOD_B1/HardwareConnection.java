package SINGLETON_FACTORY_METHOD_B1;

public class HardwareConnection {
    private static HardwareConnection instance;

    private HardwareConnection() {
    }

    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();

        }
        return instance;

    }

    public void disconnect() {
        System.out.println("ngat ket noi phan cung");
    }

}
