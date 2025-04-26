package base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * WebDriverManager is a utility class that encapsulates the management of WebDriver instances.
 * It uses ThreadLocal to ensure that each thread has its own WebDriver instance.
 */
public class WebDriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Gets the WebDriver for the current thread, creating it if necessary.
     * It attempts to create a RemoteWebDriver using desired capabilities.
     * If MalformedURLException occurs, it will print the stack trace and continue
     * to set the system property for webdriver.chrome.driver and instantiate a ChromeDriver.
     * 
     * @return WebDriver the WebDriver instance for the current thread
     */
    public synchronized static WebDriver getDriver() {
        String homeDir = System.getProperty("user.dir");
        if (driver.get() == null) {
        	DesiredCapabilities caps = new DesiredCapabilities();
    		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
    		try {
				driver.set(new RemoteWebDriver(new URL("http://192.168.1.2:4444"), caps));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
       	   System.setProperty("webdriver.chrome.driver", homeDir+"\\src\\main\\resources\\webdriver\\chromedriver\\chromedriver.exe");
           //driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    /**
     * Quits the WebDriver for the current thread and removes the instance from the thread local storage.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
