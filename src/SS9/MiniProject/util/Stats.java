package SS9.MiniProject.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Stats {

    private static final AtomicInteger passed = new AtomicInteger(0);
    private static final AtomicInteger jams = new AtomicInteger(0);

    public static void incPassed() {
        passed.incrementAndGet();
    }

    public static void incJam() {
        jams.incrementAndGet();
    }

    public static int getPassed() {
        return passed.get();
    }

    public static int getJams() {
        return jams.get();
    }
}