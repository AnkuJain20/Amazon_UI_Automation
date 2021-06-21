package stepdefinitions;

import base.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPayStepDef {


    TestContext testContext;
    public Scenario scn;

    //Dependency Injections using Pico Container
    public AmazonPayStepDef(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }




    @When("User should be able to click on AmazonPay")
    public void user_should_be_able_to_click_on_amazon_pay() {
        testContext.amazonPayPageObject.clickOnAmazonPay();
    }

    @Then("Page should display with title {string}")
    public void page_should_display_with_title(String expTitle) {
        testContext.amazonPayPageObject.checkAmazonPayTitle(expTitle);
    }




    @And("click on AddMoney")
    public void clickOnAddMoney() {
        testContext.amazonPayPageObject.clickOnAddMoney();
    }

    @Then("should ask for login with title {string}")
    public void shouldAskForLoginWithTitle(String expectedTitle ) {
        testContext.amazonPayPageObject.amazonSignInPageTitle(expectedTitle);
    }
}
