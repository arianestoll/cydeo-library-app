package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {



    /*
    creating private constructor so
     we re closing access to the object of this class from outside the class
     */
    private Driver(){

    }

    /*
    webDriver is private too to close access from outside the class
    static because we will use it in a static method
     */
    private static WebDriver driver;

    /*
    public method so we can access from outside
    re-usable utility method which will return same driver instance when we call it
     */

    public static WebDriver getDriver(){
        if(driver == null){
            String browserType = com.cydeo.utilities.ConfigurationReader.getProperty("browser");//getting/reading browser type
            // from conf reader. This WAY we can control which browser is opened from outside our code,
            // from configuration.reader

            switch  (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                //depending

            }
        }

        return driver;
    }



    /*
    This closing down method will close the session but if my driver session ID has been completely terminated (quit),
    this new method will turn it back to null, so new test can run(with a new driver ID) when we
    call Driver (see beginning of getDriver method above)

    This closeDriver method can be used at the end of a test, when there's another test after that.
     */


    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
