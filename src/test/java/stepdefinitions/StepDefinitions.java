package stepdefinitions;

import base.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class StepDefinitions {

    WebDriver driver;

    //POM classes
    LoginPageObject loginPageObject;
    LandingPageObject landingPageObject;
    SearchPageObject searchPageObject;
    AddToCartPageObject addToCartPageObject;
    AmazonPayPageObject amazonPayPageObject;

    @Before
    public void setUp() throws Exception {
        driver = WebDriverFactory.getWebDriverForBrowser();
        loginPageObject = new LoginPageObject(driver);
        landingPageObject = new LandingPageObject(driver);
        searchPageObject = new SearchPageObject(driver);
        addToCartPageObject = new AddToCartPageObject(driver);
        amazonPayPageObject = new AmazonPayPageObject(driver);

    }

    @After(order=1)
    public void cleanUp(){
        WebDriverFactory.quitDriver();
    }

    @Given("User is on the landing page with URL {string}")
    public void user_is_on_the_landing_page_with_url(String url) {
        loginPageObject.openBrowser();
        loginPageObject.openUrl(url);
    }

    @Then("Home Page should display with title {string}")
    public void home_page_should_display_with_title(String expectedTitle) {
        landingPageObject.checkTitle(expectedTitle);
    }

    @Then("close the browser")
    public void close_the_browser() {
        loginPageObject.closeBrowser();
    }

    @When("send the username with {string}")
    public void send_the_username(String uname) {
        loginPageObject.loginWithUserName(uname);
    }

    @Then("user unable to login with error {string}")
    public void userUnableToLoginWithError(String expectedError) {
        loginPageObject.checkLoginErrorMsg(expectedError);
    }

    @Then("user should able to enter password {string}")
    public void userShouldAbleToEnterPassword(String pwd) {
        loginPageObject.enterPassword(pwd);
    }



    @When("User should be able to search for product {string}")
    public void userShouldBeAbleToSearchForProduct(String productName) {
        landingPageObject.searchForProduct(productName);
    }

    @Then("Product page should be displayed with title {string}")
    public void productPageShouldBeDisplayedWithTitle(String expectedTitle) {
        landingPageObject.checkProductPageTitle(expectedTitle);
    }


    @When("User should be able to click on select address")
    public void user_should_be_able_to_click_on_select_address() {
       landingPageObject.selectAddress();
    }



    @When("user should able to click on apply")
    public void user_should_able_to_click_on_apply() {
       landingPageObject.submitPinCode();
    }
    @Then("user should see the updated address")
    public void user_should_see_the_updated_address() {
       landingPageObject.readSelectedAddress();
    }

    @And("user should be able to enter pincode {string}")
    public void userShouldBeAbleToEnterPinCode(String pinCode) {
        landingPageObject.enterPinCode(pinCode);
    }

    @And("User should be able to apply search filter {string} and {string}")
    public void userShouldBeAbleToApplySearchFilterAnd(String minPrice, String maxPrice) {
        searchPageObject.applyPriceFilter(minPrice,maxPrice);
    }


    @And("User should be able to apply search filter {string}")
    public void userShouldBeAbleToApplySearchFilter(String brand) {
        searchPageObject.applyBrandFilter(brand);
    }

    @Then("check filter is applied")
    public void checkFilterIsApplied() {
        searchPageObject.checkFilterApplied();
    }

    @Then("check brand is selected in filter criteria")
    public void checkBrandIsSelectedInFilterCriteria() {
        searchPageObject.readSelectedBrandFilter();
    }

    @And("click on cart")
    public void clickOnCart() {
        addToCartPageObject.selectProductAndClickOnCart();
    }

    @Then("product should be in cart")
    public void productShouldBeInCart() {
        addToCartPageObject.checkProductInCart();
    }

    @When("User should be able to click on AmazonPay")
    public void user_should_be_able_to_click_on_amazon_pay() {
        amazonPayPageObject.clickOnAmazonPay();
    }

    @Then("Page should display with title {string}")
    public void page_should_display_with_title(String expTitle) {
        amazonPayPageObject.checkAmazonPayTitle(expTitle);
    }


}
