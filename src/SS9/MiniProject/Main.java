package SS9.MiniProject;

import SS9.MiniProject.engine.*;
import SS9.MiniProject.entity.Vehicle;
import SS9.MiniProject.factory.VehicleFactory;
import SS9.MiniProject.util.Stats;

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

        // Đợi pool kết thúc rồi in báo cáo
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("=== REPORT ===");
        System.out.println("Vehicles passed: " + Stats.getPassed());
        System.out.println("Traffic jams: " + Stats.getJams());
    }
}