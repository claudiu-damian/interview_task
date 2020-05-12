package functional.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static functional.constants.ConfigurationConstants.*;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description:
 */

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriver driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(System.getenv(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", System.getenv(DRIVER_PATH));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--hooks-type");
        chromeOptions.addArguments("enable-automation");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        return new ChromeDriver(chromeOptions);
    }
}
