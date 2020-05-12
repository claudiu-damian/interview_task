package sections;

import com.thoughtworks.gauge.Step;
import functional.core.TestContext;
import hooks.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.TestConstants.*;
import static functional.constants.ConfigurationConstants.URL;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description: Selector declarations and actions with elements from the Location Section of the page
 */

@Getter
public class LocationSection extends BasePage {
    private By locationsSelector = By.cssSelector(".store-meta div");
    private By searchBox = By.cssSelector("#searchBox");
    private By firstFoundLocation = By.cssSelector(".pac-item:first-of-type");
    private By milesAway = By.cssSelector(".store-phone-group div span");
    private By showAllLocationsButton = By.xpath("//*[text()='Show all locations']");
    private By findButton = By.xpath("//*[text()='Find']");

    @Step("Open Location Page")
    public void openLocationPage() {
        navigateTo(System.getenv(URL));
        waitForPage();
        switchFrame(0);
    }

    @Step("Search for a location from the delivery area")
    public void searchForLocationInDeliveryArea() {
        type(getLocationListElements().get(0).getText(), searchBox);
        clickOnFirstFoundLocation();
    }

    @Step("Save the initial location list")
    public void saveTheInitialLocationList() {
        TestContext.getScenarioStore().put(INITIAL_LOCATION_LIST, getLocationListElements());
    }

    @Step("Search for a location outside the delivery area")
    public void searchForLocationNotInDeliveryArea() {
        type(OUTSIDE_ADDRESS, searchBox);
        clickOnFirstFoundLocation();
    }

    @Step("Search for an unclear location")
    public void searchForUnclearLocation() {
        type(RANDOM_TEXT, searchBox);
        click(findButton);
    }

    @Step("Click on Show all locations button")
    public void clickOnShowAllLocationsButton() {
        waitForPage();
        click(showAllLocationsButton);
    }

    List<WebElement> getLocationListElements() {
        return getElements(locationsSelector);
    }

    private void clickOnFirstFoundLocation() {
        click(firstFoundLocation);
    }

    List<WebElement> returnInitialLocationList() {
        return (List<WebElement>) TestContext.getScenarioStore().get(INITIAL_LOCATION_LIST);
    }
}
