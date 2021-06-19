package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static WebDriver driver=null;

    public static WebDriver getWebDriverForBrowser() throws Exception {
        String browser = BaseClass.getBrowser().toLowerCase();

        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver(){
        String browser = BaseClass.getBrowser().toLowerCase();
        if(browser.equals("chrome")){
            driver.quit();
        }
    }
}
