import Utilities.PropertyReader;
import testUtilities.DriverFactory;
import testUtilities.TestUtilities;

import static testUtilities.DriverFactory.*;

public class TestFile {
    public static void main(String[] args) throws InterruptedException {
        PropertyReader property = PropertyReader.getInstance();
        String value = property.getPropertyValue("TESTURL");
        System.out.println(value);
        System.out.println(property.getPropertyValue("USERNAME"));
        DriverFactory.launchBrowser();
        System.out.println(getDriver().getTitle());
        Thread.sleep(4000);
        DriverFactory.quitBrowser();



    }
}
