package sections;

import com.thoughtworks.gauge.Step;
import functional.core.TestContext;
import functional.helpers.AssertHelper;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.TestConstants.INITIAL_LOCATION_LIST;

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
        AssertHelper.assertTrue("Lists have same sizes, the search was not done properly",
                !(((List<WebElement>) TestContext.getScenarioStore().get(INITIAL_LOCATION_LIST)).size()
                        == getLocationListElements().size()));
    }
}
