package functional.helpers;

import functional.core.InitializationUtils;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static functional.constants.ConfigurationConstants.ELEMENT_VISIBILITY_TIMEOUT;
import static functional.constants.ConfigurationConstants.WAITER_POLLING_RATE;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description: Generic Selenium methods wrapped with logs
 */

@Log4j
public class ActionHelper {
    private WebDriver driver = InitializationUtils.getDriver();

    private WebDriverWait getDefaultWait() {
        return new WebDriverWait(driver, Integer.parseInt(System.getenv(ELEMENT_VISIBILITY_TIMEOUT)),
                Integer.parseInt(System.getenv(WAITER_POLLING_RATE)));
    }

    public WebElement findElement(By by) {
        log.info("Retrieving element: [" + by.toString() + "]");
        return getDefaultWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> getElements(By by) {
        log.info("Retrieving elements [" + by.toString() + "]");
        return driver.findElements(by);
    }

    public String getTextFromElement(By by) {
        log.info("Getting text from element: [" + by.toString() + "]");
        return findElement(by).getText();
    }

    public void clickElement(By by) {
        findElement(by).click();
        log.info("Clicked element: [" + by.toString() + "]");
    }

    public void type(String text, By by) {
        log.info("Typing: [" + text + "] in element: [" + by.toString() + "]");
        findElement(by).sendKeys(text);
    }

    public void waitForElementVisibility(By by) {
        log.info("Waiting for element [" + by.toString() + "] to be visible");
        getDefaultWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void hoverElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).perform();
        log.info("Hovered over element [" + by.toString() + "]");
    }

    public void switchFrame(int frameNumber) {
        driver.switchTo().frame(frameNumber);
        log.info("Switched to frame [" + frameNumber + "]");
    }

    public void navigateTo(String url) {
        log.info("Navigating to link: [" + url + "]");
        driver.navigate().to(url);
    }

    public void waitForPage() {
        log.info("Waiting for the page to be loaded");
        boolean stillChanging = true;
        String previous = "";
        String current;
        while (stillChanging) {
            current = driver.getPageSource();
            try {
                Thread.sleep(Long.parseLong(System.getenv(WAITER_POLLING_RATE)));
            } catch (InterruptedException e) {
                log.error("Catch InterruptedException: " + e);
            }
            stillChanging = (!previous.equals(current));
            previous = current;
        }
    }
}
