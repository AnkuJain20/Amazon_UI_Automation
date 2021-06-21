package stepdefinitions;

import base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


@Log4j2
public class Hooks {
    TestContext testContext;
    WebDriver driver;

    //Dependency Injections using Pico Container
    public Hooks(TestContext testContext) {
        System.out.println("Inside Hooks constructor: " + testContext);
        this.testContext = testContext;
        driver = testContext.driver;
    }

    @Before (order = 0)
    public void setUp(Scenario scn) throws Exception {
        System.out.println("Hooks-> Before: " + scn.getName());

        testContext.initializeWebDriver();
        testContext.intializePageObjects();
        testContext.scn = scn;
    }


    @After(order=1)
    public void cleanUp(Scenario scn){
        System.out.println("Hooks-> After (order 1): " + scn.getName());
        testContext.quitDriver();
        scn.log("Browser Closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario scn) {
        System.out.println("Hooks-> After (order 2): " + scn.getName());

        if (scn.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }
}
