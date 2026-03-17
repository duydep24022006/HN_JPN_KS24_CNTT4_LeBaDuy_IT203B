package SS9.pattern;

import SS9.engine.Intersection;
import SS9.entity.PriorityVehicle;
import SS9.entity.StandardVehicle;
import SS9.entity.Vehicle;


import java.util.Random;

public class VehicleFactory {

    private static int counter = 1;

    public static Vehicle create(Intersection intersection) {
        Random r = new Random();
        int type = r.nextInt(4);

        String id = "Vehicle-" + counter++;

        switch (type) {
            case 0:
            case 1:
                return new StandardVehicle(id, intersection);
            case 2:
                return new PriorityVehicle(id, intersection);
            default:
                return new StandardVehicle(id, intersection);
        }
    }
}
