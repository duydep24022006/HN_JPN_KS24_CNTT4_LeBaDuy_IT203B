package SS9.MiniProject.pattern;

import SS9.MiniProject.engine.Intersection;
import SS9.MiniProject.entity.PriorityVehicle;
import SS9.MiniProject.entity.StandardVehicle;
import SS9.MiniProject.entity.Vehicle;


import java.util.Random;

public class VehicleFactory {

    private static int counter = 1;

    public static Vehicle create(Intersection intersection) {
        Random r = new Random();
        int type = r.nextInt(4);

        String id = "Vehicle-" + counter++;

        switch (type) {
            case 1:
                return new StandardVehicle(id, intersection);
            case 2:
                return new PriorityVehicle(id, intersection);
            default:
                return new StandardVehicle(id, intersection);
        }
    }
}
