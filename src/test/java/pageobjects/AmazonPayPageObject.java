package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class AmazonPayPageObject {

    WebDriver driver;

    //XPATHS
    By amazonPayTitle = By.xpath("//*[@id='nav-xshop']/a[8]");

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

}
