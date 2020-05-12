package hooks;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import functional.core.InitializationUtils;

/**
 * @author: Claudiu-Damian Panzaru
 * @date: 5/11/2020
 * @description:
 */

public class Hooks {
    @BeforeScenario
    public void initializeDriver() {
        InitializationUtils.createDriver();
    }

    @AfterScenario
    public void closeDriver() {
        InitializationUtils.closeDriver();
    }
}
