package base;

import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pageobjects.*;

@Log4j2
public class TestContext {

    public WebDriver driver;
    public LoginPageObject loginPageObject;
    public LandingPageObject landingPageObject;
    public SearchPageObject searchPageObject;
    public AddToCartPageObject addToCartPageObject;
    public  AmazonPayPageObject amazonPayPageObject;
    public Scenario scn;


    public void initializeWebDriver() throws Exception {
        log.info("TestContext->initializeWebDriver");
        driver = WebDriverFactory.getWebDriverForBrowser();
    }

    public void intializePageObjects(){
        log.info("TestContext->intializePageObjects");
        loginPageObject = new LoginPageObject(driver);
        landingPageObject = new LandingPageObject(driver);
        searchPageObject = new SearchPageObject(driver);
        addToCartPageObject = new AddToCartPageObject(driver);
        amazonPayPageObject = new AmazonPayPageObject(driver);
    }

    public void quitDriver(){
        driver.quit();
        log.info("TestContext->quitDriver.");

    }

}
