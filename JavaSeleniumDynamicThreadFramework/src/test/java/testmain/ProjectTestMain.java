package testmain;

import org.openqa.selenium.WebDriver;
import base.WebDriverManager;
import blackboxtesting.BlackBoxTestCase;
import businessrequirementtesting.BusinessRequirementTestCase;
import performancerequirementtesting.PerformanceTestCase;
import testcases.StockPrice;
import whiteboxtesting.WhiteBoxTestCase;

/**
 * ProjectTestMain is the main class for executing various test cases for a web application.
 * It combines different types of test cases including black box, business requirement,
 * performance, and white box testing.
 */
public class ProjectTestMain {

    /**
     * Main method to execute various test cases.
     * It initializes WebDriver, executes different types of test cases, and prints the test results.
     * The method demonstrates the use of different test methodologies in a project context.
     * 
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = WebDriverManager.getDriver();
        StockPrice stockPrice = new StockPrice(driver);
        
        // Test case: Verify URL after Search
        try {
            stockPrice.stockPriceSearch(driver, "TestCase1");
            boolean isUrlCorrect = BlackBoxTestCase.verifyUrlContainsStockName(driver, "Apple");
            System.out.println("Test 1: Verify URL after search: " + (isUrlCorrect ? "Passed" : "Failed"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test case: Database Reader
        boolean isDatabaseReadCorrectly = WhiteBoxTestCase.validateDatabaseReader(20, "TestCases");
        System.out.println("Test 2: Validate Database Reader: " + (isDatabaseReadCorrectly ? "Passed" : "Failed"));

        // Test case: Verify Data in Database
        boolean isDataInDatabaseCorrect = BusinessRequirementTestCase.validateDataInDatabase("187.70", "TestData", "TestCase1", "OpenPrice");
        System.out.println("Test 3: Verify Data in Database: " + (isDataInDatabaseCorrect ? "Passed" : "Failed"));
        
        // Test case: Testcase Execution Time
        boolean isPageLoadTimeValid = PerformanceTestCase.validateTestcaseExecutionTime("TestCase2", 40000);
        System.out.println("Test 4: Validate Page Load Time: " + (isPageLoadTimeValid ? "Passed" : "Failed"));

        // Close the WebDriver
        driver.quit();
    }    

}
