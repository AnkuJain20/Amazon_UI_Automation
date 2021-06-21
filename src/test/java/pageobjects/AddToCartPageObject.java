package pageobjects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddToCartPageObject {

    WebDriver driver;

    //XPATHS
    By selectProductText = By.linkText("Samsung Galaxy M12 (Black,6GB RAM, 128GB Storage) 6000 mAh with 8nm Processor | True 48 MP Quad Camera | 90Hz Refresh Rate");

    public AddToCartPageObject(WebDriver driver){
        this.driver = driver;
    }

}
