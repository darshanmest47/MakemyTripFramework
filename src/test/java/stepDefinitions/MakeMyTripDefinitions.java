package stepDefinitions;

import POM.MakeMyTriHomePage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class MakeMyTripDefinitions {

    private MakeMyTriHomePage mmtHomePage;

    @Given("I am already on make my trip website")
    public void i_am_already_on_make_my_trip_website() {
        mmtHomePage = new MakeMyTriHomePage();
        System.out.println("I am already on make my trip page");
    }

    @When("I click on dismiss icon for AI Chat bot")
    public void i_click_on_dismiss_icon_for_ai_chat_bot() {
        mmtHomePage.clickOnAIDismissIcon();
    }

    @Then("AI chat bot should get closed")
    public void ai_chat_bot_should_get_closed() {
        if(mmtHomePage.isAIChatBotDisplayed()){
            Assert.assertFalse(mmtHomePage.isAIChatBotDisplayed());
            System.out.println("AI chat bot is not closed");
        }else{
            Assert.assertTrue(!mmtHomePage.isAIChatBotDisplayed());
            System.out.println("AI Chat bot is closed");
        }
    }

    @And("I click on dismiss icon for login")
    public void i_click_on_dismiss_icon_for_login() throws InterruptedException {
         mmtHomePage.clickOnCloseLoginIcon();
    }

    @Then("login window should get closed")
    public void login_window_should_get_closed() {

        if(mmtHomePage.isLoginWindowDisplayed()){
            Assert.assertFalse(mmtHomePage.isLoginWindowDisplayed());
            System.out.println("Login window is not closed");
        }else{
            Assert.assertTrue(!mmtHomePage.isLoginWindowDisplayed());
            System.out.println("Login Widnow is closed");
        }
    }

    @Then("I print {string}")
    public void i_print(String value) {
        System.out.println(value);
    }
}
