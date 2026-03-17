package SS9.MiniProject.factory;

import SS9.MiniProject.engine.Intersection;
import SS9.MiniProject.entity.PriorityVehicle;
import SS9.MiniProject.entity.StandardVehicle;
import SS9.MiniProject.entity.Vehicle;

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