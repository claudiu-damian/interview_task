package sections;

import com.thoughtworks.gauge.Step;
import functional.helpers.AssertHelper;
import org.openqa.selenium.By;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/12/2020
 * @description: Assert methods for Location Section validation
 */

public class LocationSectionAsserts extends LocationSection {
    @Step("Verify if the location list was updated with the closes locations")
    public void wasListUpdatedWithCloseLocations() {
        waitForElementToBeVisible(getMilesAway());
        waitForPage();
        AssertHelper.assertTrue("Location lists have same sizes, the search was not done properly",
                !((returnInitialLocationList()).size() == getLocationListElements().size()));
    }

    @Step("Verify if all the locations are displayed in the list with miles")
    public void wasNotListUpdatedWithCloseLocations() {
        waitForElementToBeVisible(getMilesAway());
        waitForPage();
        AssertHelper.assertTrue("Location lists have not same sizes, the search was not done properly",
                returnInitialLocationList().size() == getLocationListElements().size());
    }

    @Step("Verify if all the locations are displayed in the list")
    public void areAllTheLocationsDisplayed() {
        waitForPage();
        AssertHelper.assertTrue("Location lists have not same sizes, the search was not done properly",
                returnInitialLocationList().size() == getLocationListElements().size());
    }

    @Step("Warning: <message> appears")
    public void isWarningDisplayed(String message) {
        AssertHelper.assertTrue("", isElementPresent(By.xpath("//*[text()='" + message + "']")));
    }
}
