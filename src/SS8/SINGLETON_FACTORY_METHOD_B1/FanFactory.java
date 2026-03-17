package SINGLETON_FACTORY_METHOD_B1;

class FanFactory extends DeviceFactory {

    public Device createDevice() {

        System.out.println("FanFactory: Đã tạo quat mới.");
        return new Fan();
    }
}
