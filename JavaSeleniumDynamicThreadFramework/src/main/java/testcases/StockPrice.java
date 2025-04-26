package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import mainpackage.TestRunner;
import base.BasePage;
import database.DatabaseReader;

/**
 * StockPrice is a class designed to interact with web pages for the purpose of fetching stock price information.
 * It uses Selenium WebDriver for web page interaction and BasePage for common web operations.
 */
public class StockPrice {
    
    // DatabaseReader instance for accessing test case data
    DatabaseReader reader = TestRunner.getDatabaseReader();
    // BasePage instance for common web operations
    BasePage basePage;

    /**
     * Constructor to initialize the StockPrice with a WebDriver instance.
     * @param driver The WebDriver instance used for web interactions.
     */
    public StockPrice(WebDriver driver) {
        basePage = new BasePage(driver);  // Initialize BasePage instance
    }

    /**
     * Performs a search on Google for a given stock's price and updates the value in the database.
     * It navigates to Google, enters the stock name into the search box, and submits the search.
     * Then, it retrieves the stock price information from the search results and updates it in the database.
     *
     * @param driver The WebDriver instance used for web interactions.
     * @param testCaseName The name of the test case which contains the stock name information.
     * @return true if the operation is completed successfully.
     * @throws InterruptedException If the thread is interrupted while waiting.
     */
    public boolean stockPriceSearch(WebDriver driver, String testCaseName) throws InterruptedException {
        driver.manage().window().maximize();
        basePage.navigateToUrl("https://www.google.com");  // Navigate to Google

        // Prepare and send the search query
        String stockName = this.reader.getValue("TestData", testCaseName, "stockname") + " Stock Price";
        By searchBoxLocator = By.name("q");
        basePage.sendKeys(searchBoxLocator, stockName);
        Thread.sleep(3000);

        // Submit the search query
        basePage.pressEnter(searchBoxLocator);
        Thread.sleep(5000);

        // Extract stock price information from the search results
        WebElement table = driver.findElement(By.className("CYGKSb"));
        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 2) {
                String label = cells.get(0).getText() + "Price";
                String value = cells.get(1).getText().replace(",", "");
                this.reader.updateValue("TestData", testCaseName, label, value);
                Thread.sleep(2000);
            }
        }

        return true;
    }
}
