package functional.core;

import org.openqa.selenium.WebDriver;

import static functional.constants.ConfigurationConstants.DRIVER_KEY;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description:
 */

public class InitializationUtils {
    public static void createDriver() {
        TestContext.getScenarioStore().put(DRIVER_KEY, DriverFactory.createDriver());
    }

    public static WebDriver getDriver() {
        return (WebDriver) TestContext.getScenarioStore().get(DRIVER_KEY);
    }

    public static void closeDriver() {
        getDriver().close();
    }
}
