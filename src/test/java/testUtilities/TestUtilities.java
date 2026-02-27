package testUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtilities {
    private static TestUtilities utilities = null;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;


    private TestUtilities(){
        wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        actions = new Actions(DriverFactory.getDriver());
        js = (JavascriptExecutor)DriverFactory.getDriver();
    }

    public static TestUtilities getInstance(){
        if(utilities==null){
            utilities = new TestUtilities();
            return utilities;
        }else{
            return utilities;
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void scrollToElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollView()",element);
    }

    public void jsClick(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].click()",element);
    }

    public void actionsClick(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).click().build().perform();
    }

    public void clickMethod(WebElement element){
          wait.until(ExpectedConditions.visibilityOf(element));
          element.click();
    }

    public void enterUserName(WebElement element,String username){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(username);
    }
}
