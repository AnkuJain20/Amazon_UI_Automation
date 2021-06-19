package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

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
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("add-to-cart-button")).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id='huc-v2-order-row-confirm-text']/h1"));
//        Set<String> windowHandles = driver.getWindowHandles();
//        driver.switchTo().
//
//        driver.findElement(By.id("//*[@id='attachDisplayAddBaseAlert']/div/h4")).getText();
//

        System.out.println("something");

//        Select select = new Select(driver.findElement(By.id("quantity")));
//        select.selectByIndex(1);

//        driver.switchTo().window(parentId);


//        String addToCart = "//*[@id='add-to-cart-button']";
//        driver.findElement(By.xpath(addToCart)).click();
    }
}
