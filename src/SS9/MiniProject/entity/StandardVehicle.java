package SS9.MiniProject.entity;

import SS9.MiniProject.engine.Intersection;

public class StandardVehicle extends Vehicle {

    public StandardVehicle(String id, Intersection intersection) {
        super(id, false, intersection);
    }

    public void move() throws InterruptedException {
        Thread.sleep(500);
    }
}