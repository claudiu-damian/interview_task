package functional.core;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

public class TestContext {
    public static DataStore getScenarioStore() {
        return DataStoreFactory.getScenarioDataStore();
    }

    public static DataStore getSpecificationStore() {
        return DataStoreFactory.getSpecDataStore();
    }

    public static DataStore getSuiteStore() {
        return DataStoreFactory.getSuiteDataStore();
    }
}
