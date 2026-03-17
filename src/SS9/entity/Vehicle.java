package SS9.entity;

import SS9.engine.Intersection;
import SS9.pattern.Observer;
import SS9.pattern.TrafficLightState;

public abstract class Vehicle implements Runnable, Observer {

    protected String id;
    protected boolean priority;
    protected Intersection intersection;
    protected volatile boolean canGo = false;

    public Vehicle(String id, boolean priority, Intersection intersection) {
        this.id = id;
        this.priority = priority;
        this.intersection = intersection;
    }

    public boolean isPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public boolean isAllowedToGo() {
        return canGo || priority;
    }

    public void update(TrafficLightState state) {
        if (priority) {
            canGo = true;
        } else {
            canGo = state.getName().equals("GREEN");
        }
    }

    public void run() {
        try {
            intersection.requestEnter(this);
        } catch (Exception e) {
            System.out.println(id + " ERROR");
        }
    }

    public abstract void move() throws InterruptedException;
}