package stepdefinitions;

import base.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class AddToCartStepDef {

    TestContext testContext;
    public Scenario scn;

    //Dependency Injections using Pico Container
    public AddToCartStepDef(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }


    @And("click on cart")
    public void clickOnCart() {
        //testContext.addToCartPageObject.selectProductAndClickOnCart();
    }

    @Then("product should be in cart")
    public void productShouldBeInCart() {
        //testContext.addToCartPageObject.checkProductInCart();
    }



}
