package SINGLETON_FACTORY_METHOD_B1;

// Factory tạo Điều hòa
class AirConditionerFactory extends DeviceFactory {

    public Device createDevice() {

        System.out.println("AirConditionerFactory: Đã tạo điều hòa mới.");

        return new AirConditioner();
    }
}