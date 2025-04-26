package blackboxtesting;

import org.openqa.selenium.WebDriver;

/**
 * BlackBoxTestCase contains methods for performing black box testing
 * on web applications using Selenium WebDriver.
 */
public class BlackBoxTestCase {

    /**
     * Verifies if the current URL of the web page contains the specified stock name.
     * This method can be used for testing if navigation to a stock-related page is successful.
     *
     * @param driver The WebDriver instance being used for the test.
     * @param stockName The stock name to check for in the URL.
     * @return boolean indicating whether the URL contains the stock name (true) or not (false).
     */
    public static boolean verifyUrlContainsStockName(WebDriver driver, String stockName) {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(stockName);
    }

}
