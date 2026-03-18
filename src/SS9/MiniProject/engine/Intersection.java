package SS9.MiniProject.engine;

import SS9.MiniProject.entity.Vehicle;
import SS9.MiniProject.exception.CollisionException;
import SS9.MiniProject.exception.TrafficJamException;
import SS9.MiniProject.util.Stats;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

    private final ReentrantLock lock = new ReentrantLock(true);
    private final BlockingQueue<Vehicle> queue = new LinkedBlockingQueue<>(10);

    // Mốc thời gian bắt đầu mô phỏng
    public static long simulationStart = System.currentTimeMillis();

    public void requestEnter(Vehicle v) throws Exception {

        if (!queue.offer(v)) {
            Stats.incJam();
            throw new TrafficJamException("Kẹt xe tại thời điểm " + getElapsedSeconds() + "s");
        }

        while (true) {
            if (v.isAllowedToGo()) {
                lock.lock();
                try {
                    if (!v.isAllowedToGo()) {
                        continue;
                    }

                    if (!queue.remove(v)) {
                        throw new CollisionException("Va chạm phát hiện với " + v.getId());
                    }

                    // Log xe vào ngã tư
                    System.out.println("[Thời gian: " + getElapsedSeconds() + "s] "
                            + (v.isPriority() ? "Xe ưu tiên" : "Xe thường")
                            + " " + v.getId() + " ĐANG VÀO NGÃ TƯ | Hàng chờ còn: " + queue.size());

                    v.move();
                    Thread.sleep(1000);

                    // Log xe ra khỏi ngã tư
                    System.out.println("[Thời gian: " + getElapsedSeconds() + "s] "
                            + (v.isPriority() ? "Xe ưu tiên" : "Xe thường")
                            + " " + v.getId() + " ĐÃ QUA NGÃ TƯ | Hàng chờ còn: " + queue.size());

                    Stats.incPassed();
                    break;

                } finally {
                    lock.unlock();
                }
            }
            Thread.sleep(200);
        }
    }

    private long getElapsedSeconds() {
        return (System.currentTimeMillis() - simulationStart) / 1000;
    }
}