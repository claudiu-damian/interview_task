package hooks;

import functional.helpers.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description: A class which will serve like a bridge between helper classes and page objects
 */

public class BasePage {
    private ActionHelper actionHelper = new ActionHelper();

    public void click(By by) {
        actionHelper.clickElement(by);
    }

    public void type(String text, By by) {
        actionHelper.type(text, by);
    }

    public void hover(By by) {
        actionHelper.hoverElement(by);
    }

    public void waitForElementToBeVisible(By by) {
        actionHelper.waitForElementVisibility(by);
    }

    public List<WebElement> getElements(By by) {
        return actionHelper.getElements(by);
    }

    public String getText(By by) {
        return actionHelper.getTextFromElement(by);
    }

    public void navigateTo(String url) {
        actionHelper.navigateTo(url);
    }

    public void switchFrame(int frameNumber) {
        actionHelper.switchFrame(frameNumber);
    }

    public void waitForPage() {
        actionHelper.waitForPage();
    }
}
