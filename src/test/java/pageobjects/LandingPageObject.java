package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageObject {
    WebDriver driver;


    By searchTextField = By.id("twotabsearchtextbox");
    By searchIconClick = By.id("nav-search-submit-button");
    By addressSelectIcon = By.id("glow-ingress-line1");
    By pinCodeField = By.id("GLUXZipUpdateInput");
    By addressSubmitBtn = By.xpath("//*[@id='GLUXZipUpdate']/span/input");
    By readPinCodeLbl = By.xpath("//*[@id='glow-ingress-line2']");

    //*[@id="glow-ingress-line2"]




    public LandingPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void checkTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }






    public void searchForProduct(String productName) {
        driver.findElement(searchTextField).sendKeys(productName);
        driver.findElement(searchIconClick).click();
    }

    public void checkProductPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void selectAddress() {
        driver.findElement(addressSelectIcon).click();
    }

    public void enterPinCode(String pinCode) {
        driver.findElement(pinCodeField).sendKeys(pinCode);
    }

    public void submitPinCode() {
        driver.findElement(addressSubmitBtn).click();
    }

    public void readSelectedAddress() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Bengaluru")));
        String address = driver.findElement(readPinCodeLbl).getText();

        Assert.assertTrue(address.contains("560103"));

    }
}
