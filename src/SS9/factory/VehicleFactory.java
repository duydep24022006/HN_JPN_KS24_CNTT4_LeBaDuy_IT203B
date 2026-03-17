package SS9.factory;

import SS9.entity.*;
import SS9.engine.Intersection;

import java.util.Random;

public class VehicleFactory {

    private static final Random random = new Random();

    public static Vehicle create(String id, Intersection i) {

        if (random.nextInt(5) == 0) {
            return new PriorityVehicle(id, i);
        }

        return new StandardVehicle(id, i);
    }
}