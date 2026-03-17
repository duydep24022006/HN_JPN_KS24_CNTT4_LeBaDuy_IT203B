package COMMAND_OBSERVER_B4;

import java.util.*;

public class TemperatureSensor implements Subject {
    // tbi theo doi
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    // dko obs
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    // huy obs
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    // tbao cho tat ca obs
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
            ;
        }
    }

    // thay doi nhiet do
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Cam bien nhiet do" + temperature);
        notifyObservers();// thay doi nhiet den thong bao
    }

}
