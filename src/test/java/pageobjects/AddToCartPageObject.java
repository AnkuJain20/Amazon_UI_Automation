package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPageObject {

    WebDriver driver;

    //XPATHS
    By selectProductText = By.linkText("Samsung Galaxy M12 (Black,6GB RAM, 128GB Storage) 6000 mAh with 8nm Processor | True 48 MP Quad Camera | 90Hz Refresh Rate");

    public AddToCartPageObject(WebDriver driver){
        this.driver = driver;
    }


    public void selectProductAndClickOnCart() {
        driver.findElement(selectProductText).click();
    }

    public void checkProductInCart() {


//        Select select = new Select(driver.findElement(By.id("quantity")));
//        select.selectByIndex(1);

//        driver.switchTo().window(parentId);


//        String addToCart = "//*[@id='add-to-cart-button']";
//        driver.findElement(By.xpath(addToCart)).click();
    }
}
