package mainpackage;

import java.util.concurrent.CountDownLatch;
import core.DynamicThreadManager;
import database.DatabaseReader;
import reporting.ReportManager;
import testcases.TestCaseExecutor;

/**
 * TestRunner is a class designed to execute a suite of test cases.
 * It utilizes a dynamic thread manager to run tests in parallel and report their outcomes.
 */
public class TestRunner {
    
    // Directory path where the application is running
    static String homeDir = System.getProperty("user.dir");
    // DatabaseReader instance for accessing test case data
    static DatabaseReader databaseReader = new DatabaseReader();
    // Array to hold test case data
    String[][] testCases = databaseReader.readTable("TestCases");
    // Total number of test cases
    static int testCasesSize;
    
    /**
     * Main method that initiates the test execution process.
     * It sets up a reporting mechanism, dynamically executes test cases in parallel,
     * and captures their execution time and outcomes.
     * 
     * @param args Command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        try {
            TestRunner runner = new TestRunner();
            testCasesSize = runner.testCases.length; 

            // Initialize reporting
            ReportManager.initReport();
            // Latch for synchronizing the completion of all test cases
            CountDownLatch latch = new CountDownLatch(testCasesSize);
            // Record the start time of parallel execution
            long parallelStartTime = System.currentTimeMillis();

            // Iteratively submit each test case for execution
            for (String[] testCaseMethods : runner.testCases) {
                String testCaseName = testCaseMethods[1];
                for (int i = 2; i < testCaseMethods.length; i++) {
                    String methodName = testCaseMethods[i];
                    if (methodName != null && !methodName.isEmpty()) {
                        DynamicThreadManager.submitTask(testCaseName, methodName, () -> {
                            try {
                                long startTime = System.currentTimeMillis();
                                boolean passed = TestCaseExecutor.executeTestCase(methodName, testCaseName);
                                System.out.println(passed);
                                long endTime = System.currentTimeMillis();
                                long executionTime = (endTime - startTime)/1000;
                                String screenshotPath = homeDir + "\\src\\main\\resources\\screenshots\\" + testCaseName + ".png";
                                ReportManager.addTestResult(testCaseName, passed, executionTime, screenshotPath);
                            } finally {
                                latch.countDown();  // Decrement the latch counter
                            }
                        });
                    }
                }
            }

            // Wait for the completion of all test case executions
            latch.await();
            DynamicThreadManager.shutdown();
            // Record the end time of execution
            long parallelEndTime = System.currentTimeMillis();
            long actualExecutionTime = (parallelEndTime - parallelStartTime)/1000;
            // Finalize report
            ReportManager.finalizeReport();
            ReportManager.addActualExecutionTime(actualExecutionTime);  
            ReportManager.saveReport(homeDir + "\\src\\main\\resources\\reports\\report.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves the test cases data.
     * 
     * @return 2D array of Strings representing test case data.
     */
    public String[][] getTestCases() {
        return this.testCases;
    }
    
    /**
     * Retrieves the size of the test cases.
     * 
     * @return Integer representing the total number of test cases.
     */
    public static int getTestCasesSize() {
        return testCasesSize;
    }
    
    /**
     * Retrieves the DatabaseReader instance.
     * 
     * @return DatabaseReader instance used by the TestRunner.
     */
    public static DatabaseReader getDatabaseReader() {
        return databaseReader;
    }
}
