package base;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class TestContext {

    public WebDriver driver;
    public LoginPageObject loginPageObject;
    public LandingPageObject landingPageObject;
    public SearchPageObject searchPageObject;
    public AddToCartPageObject addToCartPageObject;
    public  AmazonPayPageObject amazonPayPageObject;
    public Scenario scn;


    public void initializeWebDriver() throws Exception {
        System.out.println("TestContext->initializeWebDriver");
        driver = WebDriverFactory.getWebDriverForBrowser();
    }

    public void intializePageObjects(){
        System.out.println("TestContext->intializePageObjects");
        loginPageObject = new LoginPageObject(driver);
        landingPageObject = new LandingPageObject(driver);
        searchPageObject = new SearchPageObject(driver);
        addToCartPageObject = new AddToCartPageObject(driver);
        amazonPayPageObject = new AmazonPayPageObject(driver);
    }

    public void quitDriver(){
        System.out.println("TestContext->quitDriver");
        driver.quit();

    }

}
