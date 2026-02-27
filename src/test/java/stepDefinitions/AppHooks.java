package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testUtilities.DriverFactory;

public class AppHooks {

    @Before(order =1 )
    public void initializeMethod() {
        DriverFactory.launchBrowser();
    }


    @After(order =1)
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        DriverFactory.quitBrowser();
    }

}
