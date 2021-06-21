package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonPayPageObject {

    WebDriver driver;

    //XPATHS
    By amazonPayTitle = By.xpath("//*[@id='nav-xshop']/a[8]");
    By addMoney = By.xpath("//*[@id='AddMoney']/div[2]/span/a/span");


    public AmazonPayPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAmazonPay() {
        driver.findElement(amazonPayTitle).click();
    }

    public void checkAmazonPayTitle(String expTitle) {
        String title = driver.getTitle();
        System.out.println(title);
    }
    public  void clickOnAddMoney(){
        driver.findElement(addMoney).click();
    }

    public void amazonSignInPageTitle(String expectedTitle){
        String signInTitle = driver.getTitle();
        System.out.println(signInTitle);
        Assert.assertEquals(signInTitle, expectedTitle);

    }

}
