package stepdefinitions;

import base.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class SearchStepDef {

    TestContext testContext;
    public Scenario scn;
    //Dependency Injections using Pico Container
    public SearchStepDef(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }

    @And("User should be able to apply search filter {string} and {string}")
    public void userShouldBeAbleToApplySearchFilterAnd(String minPrice, String maxPrice) {
        testContext.searchPageObject.applyPriceFilter(minPrice,maxPrice);
        log.info("applying filter  min range   " + minPrice);
        scn.log("Running the scenarios: " + scn.getName());
    }


    @And("User should be able to apply search filter {string}")
    public void userShouldBeAbleToApplySearchFilter(String brand) {
        testContext.searchPageObject.applyBrandFilter(brand);
    }

    @Then("check filter is applied")
    public void checkFilterIsApplied() {
        testContext.searchPageObject.checkFilterApplied();
    }

    @Then("check brand is selected in filter criteria")
    public void checkBrandIsSelectedInFilterCriteria() {
        testContext.searchPageObject.readSelectedBrandFilter();
    }

    @And("User should be able to apply sort feature price low to high")
    public void userShouldBeAbleToApplySortFeaturePriceLowToHigh() {
        testContext.searchPageObject.sortFeature();
    }


    @Then("User is able to apply sort feature price low to high")
    public void userIsAbleToApplySortFeaturePriceLowToHigh() {
    }

}
