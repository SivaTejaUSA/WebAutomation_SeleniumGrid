package performancerequirementtesting;

import testcases.TestMethods;

/**
 * PerformanceTestCase contains methods for validating the execution time of test cases,
 * ensuring they meet specified performance criteria.
 */
public class PerformanceTestCase {

    /**
     * Validates that the execution time of a specified test case does not exceed the expected time.
     * This method is useful for performance testing where execution time is a critical factor.
     *
     * @param testcaseName The name of the test case to be executed.
     * @param expectedTimeMillis The maximum allowed execution time in milliseconds.
     * @return boolean indicating whether the test case execution time is within the expected limit (true) or not (false).
     */
    public static boolean validateTestcaseExecutionTime(String testcaseName, long expectedTimeMillis) {
        long start = System.currentTimeMillis();
        TestMethods methods = new TestMethods();
        methods.method1(testcaseName);
        long end = System.currentTimeMillis();
        return (end - start) <= expectedTimeMillis;
    }

}
