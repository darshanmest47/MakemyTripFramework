package testUtilities;

import Utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static ThreadLocal<WebDriver> tls = new ThreadLocal<>();

    public static void launchBrowser(){
        PropertyReader reader = PropertyReader.getInstance();
        String browser = reader.getPropertyValue("BROWSER");
        String URL = reader.getPropertyValue("TESTURL");
        if(browser.equalsIgnoreCase("CHROME")){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            tls.set(driver);
            tls.get().manage().window().maximize();
            tls.get().get(URL);
        }
        else if(browser.equalsIgnoreCase("FIREFOX")){
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            tls.set(driver);
            tls.get().manage().window().maximize();
            tls.get().get(URL);
        }
        else if(browser.equalsIgnoreCase("EDGE")){
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            tls.set(driver);
            tls.get().manage().window().maximize();
            tls.get().get(URL);
        }else{
            System.out.println("Invalid Browser");
        }
    }


    public static WebDriver getDriver(){
        return tls.get();
    }

    public static void quitBrowser(){
        try{
            if(tls.get()!=null){
                tls.get().quit();
            }
        } catch (Exception e) {
            System.out.println("Error in closing the browser");
        }finally {
            tls.remove();
        }
    }




}
