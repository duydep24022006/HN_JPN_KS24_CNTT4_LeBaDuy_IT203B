package SS9.MiniProject.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Stats {

    private static final AtomicInteger passed = new AtomicInteger(0);

    public static void inc() {
        passed.incrementAndGet();
    }

    public static int get() {
        return passed.get();
    }
}