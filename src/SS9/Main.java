package SS9;

import SS9.engine.*;
import SS9.factory.VehicleFactory;
import SS9.entity.Vehicle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Intersection intersection = new Intersection();
        TrafficLight light = new TrafficLight();

        Thread lightThread = new Thread(light);
        lightThread.setDaemon(true);
        lightThread.start();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 30; i++) {

            Vehicle v = VehicleFactory.create("V" + i, intersection);
            light.register(v);

            pool.execute(v);
        }

        pool.shutdown();
    }
}