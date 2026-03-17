package SS9.MiniProject.engine;

import SS9.MiniProject.entity.Vehicle;
import SS9.MiniProject.exception.TrafficJamException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

    private final ReentrantLock lock = new ReentrantLock(true);
    private final BlockingQueue<Vehicle> queue = new LinkedBlockingQueue<>(10);

    public void requestEnter(Vehicle v) throws Exception {

        if (!queue.offer(v)) {
            throw new TrafficJamException("Traffic Jam");
        }

        while (true) {

            if (v.isAllowedToGo()) {

                lock.lock();
                try {

                    if (!v.isAllowedToGo()) {
                        continue;
                    }

                    queue.remove(v);

                    System.out.println(v.getId() + " ENTER");

                    v.move();

                    Thread.sleep(1000);

                    System.out.println(v.getId() + " EXIT");

                    break;

                } finally {
                    lock.unlock();
                }
            }

            Thread.sleep(200);
        }
    }
}