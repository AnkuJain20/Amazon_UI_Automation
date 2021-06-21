package stepdefinitions;

import base.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class LoginStepDef {

    TestContext testContext;
    public Scenario scn;

    //Dependency Injections using Pico Container
    public LoginStepDef(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }

    @Given("User is on the landing page with URL {string}")
    public void user_is_on_the_landing_page_with_url(String url) {
        testContext.loginPageObject.openUrl(url);
        scn.log("Browser navigated to URL: " + url);
    }

    @Then("close the browser")
    public void close_the_browser() {
        testContext.loginPageObject.closeBrowser();
    }

    @When("send the username with {string}")
    public void send_the_username(String uname) {
        testContext.loginPageObject.loginWithUserName(uname);
    }

    @Then("user unable to login with error {string}")
    public void userUnableToLoginWithError(String expectedError) {
        testContext.loginPageObject.checkLoginErrorMsg(expectedError);
    }

    @Then("user should able to enter password {string}")
    public void userShouldAbleToEnterPassword(String pwd) {
        testContext.loginPageObject.enterPassword(pwd);
    }

}
