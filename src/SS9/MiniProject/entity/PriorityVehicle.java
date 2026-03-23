package SS9.MiniProject.entity;

import SS9.MiniProject.engine.Intersection;

public class PriorityVehicle extends Vehicle {

    public PriorityVehicle(String id, Intersection intersection) {
        super(id, true, intersection);
    }

    public void move() throws InterruptedException {
        Thread.sleep(300);
    }
}
