package Bt4;

import entity.TestResult;
import service.TestResultService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TestResultService service = new TestResultService();

        List<TestResult> results = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            results.add(new TestResult("P" + String.format("%03d", i),
                    "TST" + String.format("%03d", i % 50),
                    36.5 + (i % 5) * 0.1));
        }

        long start = System.currentTimeMillis();
        service.insertBatch(results);
        long end = System.currentTimeMillis();

        System.out.println("Thực thi xong 1000 bản ghi trong " + (end - start) + " ms");
    }
}
