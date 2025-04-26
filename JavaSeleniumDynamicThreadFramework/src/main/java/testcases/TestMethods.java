package testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import base.WebDriverManager;

/**
 * TestMethods contains specific test methods to be executed as part of the testing process.
 * It includes functionalities for capturing and saving screenshots during test execution.
 */
public class TestMethods {

    /**
     * Captures and saves a screenshot of the current state of the web driver.
     *
     * @param screenshotName The name to be used for the saved screenshot file.
     * @param passed A boolean indicating whether the test passed or failed.
     */
    public synchronized void captureAndSaveScreenshot(String screenshotName, boolean passed) {
        WebDriver driver = WebDriverManager.getDriver();
        String homeDir = System.getProperty("user.dir");
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
            String screenshotPath = homeDir + "\\src\\main\\resources\\screenshots\\" + screenshotName + ".png";
            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method1(String screenshotName) {
        WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
            StockPrice stockprice = new StockPrice(driver);
            passed = stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method1: " + passed);
        }
        return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method2(String screenshotName) {
        WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
            StockPrice stockprice = new StockPrice(driver);
            passed = stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method2: " + passed);
        }
        return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method3(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method3: "+passed);
        }
		return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method4(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method4: "+passed);
        }
		return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method5(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method5: "+passed);
        }
		return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method6(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method6: "+passed);
        }
		return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method7(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
    }

    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method8(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method8: "+passed);
        }
		return passed;
    }
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method9(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
    }
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method10(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
    }
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method11(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method12(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method13(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method14(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method15(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method16(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method17(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method18(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method19(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
    
    /**
     * Executes a specific test case, captures a screenshot, and quits the WebDriver.
     * Another test method with similar functionality to method1 for demonstration purposes. It can be replaced or modified to fit specific test case needs.
     *
     * @param screenshotName The name to be used for the screenshot file.
     * @return boolean indicating whether the test passed or failed.
     */
    public boolean method20(String screenshotName) {
    	WebDriver driver = WebDriverManager.getDriver();
        boolean passed = false;
        try {
        	StockPrice stockprice= new StockPrice(driver);
        	passed=stockprice.stockPriceSearch(driver, screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            captureAndSaveScreenshot(screenshotName, passed);
            driver.quit();
            System.out.println("method7: "+passed);
        }
		return passed;
	}
}
