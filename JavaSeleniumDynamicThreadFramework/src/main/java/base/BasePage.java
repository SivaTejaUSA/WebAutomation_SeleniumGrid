package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage is a utility class that encapsulates common WebDriver operations to interact with web pages.
 * This class provides synchronized methods to perform actions like navigating to a URL, clicking elements,
 * sending keystrokes, and more, which are common to all pages.
 */
public class BasePage {
    private WebDriver driver;

    /**
     * Constructor to initialize the BasePage with a WebDriver instance.
     * @param driver the WebDriver instance to interact with the web browser
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to the specified URL.
     * @param url the web address to navigate to
     */
    public synchronized void navigateToUrl(String url) {
        driver.get(url);
    }

    /**
     * Clicks on the element located by the specified locator.
     * @param locator the By locator of the element to click
     */
    public synchronized void click(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }
    
    /**
     * Simulates pressing the Enter key on the element located by the specified locator.
     * @param locator the By locator of the element to receive the key press
     */
    public synchronized void pressEnter(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        element.sendKeys(Keys.ENTER);
    }

    /**
     * Clears any existing text from the element located by the specified locator and sends the specified text to it.
     * @param locator the By locator of the element to send keys to
     * @param text the text to send to the element
     */
    public synchronized void sendKeys(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Retrieves the visible (i.e., not hidden by CSS) text of the element located by the specified locator.
     * @param locator the By locator of the element to retrieve the text from
     * @return the visible text of the element
     */
    public synchronized String getText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    /**
     * Scrolls the web page until the element located by the specified locator is in view.
     * @param locator the By locator of the element to scroll into view
     */
    public synchronized void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Waits for the element located by the specified locator to be visible on the web page.
     * @param locator the By locator of the element to wait for
     * @return the WebElement after it is visible
     */
    public synchronized WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for the element located by the specified locator to be clickable on the web page.
     * @param locator the By locator of the element to wait for
     * @return the WebElement after it is clickable
     */
    public synchronized WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
