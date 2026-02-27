package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testUtilities.DriverFactory;
import testUtilities.TestUtilities;

import javax.swing.text.Utilities;

public class MakeMyTriHomePage {
    private TestUtilities testUtilities;

    public  MakeMyTriHomePage(){
        PageFactory.initElements(DriverFactory.getDriver(),this);
        testUtilities = TestUtilities.getInstance();
    }

    //Encapsulation

    @FindBy(xpath="(//div[@class='tp-dt-header-icon']/img)[2]")
    private WebElement aiDismissIcon;

    @FindBy(css = "section > .commonModal__close")
    private WebElement closeLoginIcon;

    public void clickOnCloseLoginIcon() throws InterruptedException {
        try {
            Thread.sleep(2000);
            testUtilities.clickMethod(closeLoginIcon);
        }catch (Exception e){
            System.out.println("Login icon is not displayed");
        }
    }


    public void clickOnAIDismissIcon(){
         try{
             testUtilities.clickMethod(aiDismissIcon);
         } catch (Exception e) {
             System.out.println("Error in clicking icon");
         }
    }

    public boolean isAIChatBotDisplayed(){
      return testUtilities.isElementDisplayed(aiDismissIcon);
    }

    public boolean isLoginWindowDisplayed(){
        return testUtilities.isElementDisplayed(closeLoginIcon);
    }

}
