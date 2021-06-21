package stepdefinitions;

import base.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;


@Log4j2

public class LandingPageStepDef {

    TestContext testContext;

    public Scenario scn;

    //Dependency Injections using Pico Container
    public LandingPageStepDef(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }



//    @After(order=1)
//    public void cleanUp(){
//        WebDriverFactory.quitDriver();
//    }



    @Then("Home Page should display with title {string}")
    public void home_page_should_display_with_title(String expectedTitle) {
        testContext.landingPageObject.checkTitle(expectedTitle);
    }





    @When("User should be able to search for product {string}")
    public void userShouldBeAbleToSearchForProduct(String productName) {
        testContext.landingPageObject.searchForProduct(productName);
        
        
    }

    @Then("Product page should be displayed with title {string}")
    public void productPageShouldBeDisplayedWithTitle(String expectedTitle) {
        testContext.landingPageObject.checkProductPageTitle(expectedTitle);
    }


    @When("User should be able to click on select address")
    public void user_should_be_able_to_click_on_select_address() {
        testContext.landingPageObject.selectAddress();
    }



    @When("user should able to click on apply")
    public void user_should_able_to_click_on_apply() {
        testContext.landingPageObject.submitPinCode();
    }
    @Then("user should see the updated address")
    public void user_should_see_the_updated_address() {
        testContext.landingPageObject.readSelectedAddress();
    }

    @And("user should be able to enter pincode {string}")
    public void userShouldBeAbleToEnterPinCode(String pinCode) {
        testContext.landingPageObject.enterPinCode(pinCode);
    }





}
