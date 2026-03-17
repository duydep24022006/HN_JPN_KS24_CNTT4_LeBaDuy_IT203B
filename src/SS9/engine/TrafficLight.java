package SS9.engine;

import SS9.pattern.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrafficLight implements Subject, Runnable {

    private TrafficLightState state = new RedState();
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    public TrafficLightState getState() {
        return state;
    }

    public void setState(TrafficLightState state) {
        this.state = state;
        notifyObservers();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void remove(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }

    public void run() {
        try {
            while (true) {
                setState(new GreenState());
                Thread.sleep(3000);

                setState(new YellowState());
                Thread.sleep(1000);

                setState(new RedState());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}