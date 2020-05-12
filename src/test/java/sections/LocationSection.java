package sections;

import com.thoughtworks.gauge.Step;
import functional.core.TestContext;
import hooks.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.TestConstants.INITIAL_LOCATION_LIST;
import static functional.constants.ConfigurationConstants.URL;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description: Selector declarations and actions with elements from the Location Section of the page
 */

@Getter
public class LocationSection extends BasePage {
    private By locationsSelector = By.cssSelector(".sc-cSHVUG.dvIJqh");
    private By searchBox = By.cssSelector("#searchBox");
    private By firstFoundLocation = By.cssSelector(".pac-item:first-of-type");
    private By milesAway = By.cssSelector(".sc-chPdSV.GZFXv");

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
        type("Chisinau", searchBox);
        clickOnFirstFoundLocation();
    }

    List<WebElement> getLocationListElements() {
        return getElements(locationsSelector);
    }

    private void clickOnFirstFoundLocation() {
        click(firstFoundLocation);
    }
}
