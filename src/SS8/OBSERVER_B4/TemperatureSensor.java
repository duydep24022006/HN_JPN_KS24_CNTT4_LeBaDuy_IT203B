package OBSERVER_B4;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {

    // danh sách thiết bị đang theo dõi
    private List<Observer> observers = new ArrayList<>();

    private int temperature;

    // đăng ký observer
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    // hủy đăng ký
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    // thông báo cho tất cả observer
    @Override
    public void notifyObservers() {

        for (Observer o : observers) {
            o.update(temperature);
        }

    }

    // thay đổi nhiệt độ
    public void setTemperature(int temperature) {

        this.temperature = temperature;

        System.out.println("Cảm biến: Nhiệt độ = " + temperature);

        // khi nhiệt độ thay đổi -> thông báo
        notifyObservers();
    }

}