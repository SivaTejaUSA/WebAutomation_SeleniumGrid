package reporting;

import mainpackage.TestRunner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ReportManager is responsible for generating and managing test execution reports.
 * It stores test results and compiles them into an HTML report.
 */
public class ReportManager {
    // StringBuilder for accumulating report content
    private static final StringBuilder reportContent = new StringBuilder();
    // Map to store test results keyed by test case name
    private static final Map<String, TestResult> testResults = Collections.synchronizedMap(new LinkedHashMap<>());
    // List to maintain the order of test cases
    private static final List<String> testCaseOrder = new ArrayList<>();

    /**
     * Initializes the report with the current date and time and sets up the basic HTML structure.
     */
    public static void initReport() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateAndTime = sdf.format(new Date());

        // Setting up the initial HTML structure for the report
        reportContent.append("<html><head><title>Test Report</title></head><body>");
        reportContent.append("<h1 style='text-align:center;'>Test Execution Report (" + currentDateAndTime + ")</h1>");
        reportContent.append("<table border='1'><tr><th><b>Test Case</b></th><th><b>Execution Time (Seconds)</b></th><th><b>Screenshot</b></th></tr>");
    }

    /**
     * Adds a test result to the report.
     *
     * @param testCase The name of the test case.
     * @param passed Whether the test case passed or failed.
     * @param time The execution time of the test case in seconds.
     * @param screenshotPath The file path to the screenshot captured during the test execution.
     */
    public synchronized static void addTestResult(String testCase, boolean passed, long time, String screenshotPath) {
        testResults.put(testCase, new TestResult(time, screenshotPath, passed));
        testCaseOrder.add(testCase);
    }

    /**
     * Finalizes the report by summarizing the results and closing the HTML tags.
     */
    public static void finalizeReport() {
        int passed = 0, failed = 0;
        long totalTime = 0;
        TestRunner runner = new TestRunner();
        String[][] testcases = runner.getTestCases();
        for (String[] testcasearray : testcases) {
            String testCase = testcasearray[1];
            TestResult result = testResults.get(testCase);
            totalTime += result.time;
            if (result.passed) {
                passed++;
            } else {
                failed++;
            }

            addTestCase(testCase, result.time, result.screenshotPath, result.passed);
        }

        // Append summary and close HTML tags
        reportContent.append("</table>");
        reportContent.append("<h2>Summary</h2>");
        reportContent.append("Total Test Cases Passed: " + passed);
        reportContent.append("<br/>Total Test Cases Failed: " + failed);
        reportContent.append("<br/>Total Execution Time: " + totalTime + " Seconds");
        reportContent.append("</body></html>");
    }

    /**
     * Adds the actual execution time of the test suite to the report.
     *
     * @param time The actual execution time of the test suite in seconds.
     */
    public static void addActualExecutionTime(long time) {
        reportContent.append("<h2>Actual Execution Time</h2>");
        reportContent.append("Total Actual Execution Time: " + time + " Seconds");
    }

    /**
     * Adds an individual test case's result to the report.
     *
     * @param testCaseName The name of the test case.
     * @param executionTime The execution time of the test case in seconds.
     * @param screenshotPath The file path to the screenshot captured during the test execution.
     * @param passed Whether the test case passed or failed.
     */
    private static void addTestCase(String testCaseName, long executionTime, String screenshotPath, boolean passed) {
        String color = passed ? "green" : "red";
        reportContent.append("<tr style='background-color:" + color + "'>");
        reportContent.append("<td style='text-align:center;' width='400' height='400'><b>" + testCaseName + "</b></td>");
        reportContent.append("<td style='text-align:center;' width='400' height='400'><b>" + executionTime + "</b></td>");
        String screenshotHtml = screenshotPath.equals("No Screenshot")
                                 ? "No Screenshot"
                                 : "<img src='" + screenshotPath + "' width='700', height='400'/>";
        reportContent.append("<td style='text-align:center;'>" + screenshotHtml + "</td>");
        reportContent.append("</tr>");
    }

    /**
     * A private class within ReportManager to hold the result of a single test case.
     */
    private static class TestResult {
        long time;
        String screenshotPath;
        boolean passed;

        TestResult(long time, String screenshotPath, boolean passed) {
            this.time = time;
            this.screenshotPath = screenshotPath;
            this.passed = passed;
        }
    }

    /**
     * Writes the report content to a specified file path.
     *
     * @param filePath The file path where the report should be saved.
     */
    public static void saveReport(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(reportContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
