package service;

import entity.TestResult;
import repository.TestResultDAO;

import java.util.List;

public class TestResultService {
    private TestResultDAO dao = new TestResultDAO();

    public void insertBatch(List<TestResult> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("Danh sách kết quả xét nghiệm trống!");
            return;
        }
        dao.insertBatch(results);
    }
}