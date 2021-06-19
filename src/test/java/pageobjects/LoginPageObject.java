package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageObject {
    WebDriver driver;

    //XPATHS
    By loginBtn = By.id("nav-link-accountList-nav-line-1");
    By userNameTxt = By.xpath("//input[@id='ap_email']");
    By continueBtn = By.xpath("//input[@id='continue']");
    By loginErrMsg = By.xpath("//*[@id='auth-error-message-box']/div/h4");
    By pwdText = By.id("ap_password");


    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void openBrowser() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void openUrl(String url) {
        driver.get(url);
    }



    public void closeBrowser() {
        driver.close();
    }

    public void loginWithUserName(String uname) {
        driver.findElement(loginBtn).click();
        driver.findElement(userNameTxt).sendKeys(uname);
        driver.findElement(continueBtn).click();
    }

    public void checkLoginErrorMsg(String expectedError) {
        String errorText =  driver.findElement(loginErrMsg).getText();
        Assert.assertEquals(errorText,expectedError);

    }

    public void enterPassword(String pwd) {
        driver.findElement(pwdText).sendKeys(pwd);
       boolean displayed = driver.findElement(pwdText).isDisplayed();
       Assert.assertTrue(displayed);

    }
}
