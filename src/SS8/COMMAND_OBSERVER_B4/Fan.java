package COMMAND_OBSERVER_B4;

public class Fan implements Observer {
    @Override
    public void update(int temperature) {
        if (temperature < 20) {
            System.out.println("Quat nhiet do thap ,tu tat");

        } else if (temperature <= 25) {
            System.out.println("Quạt: Chạy tốc độ trung bình");

        } else {
            System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
        }
    }

}
