package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageObject {
    WebDriver driver;

    By minPriceField = By.id("low-price");
    By maxPriceField = By.id("high-price");
    By goBtn = By.xpath("//input[@class='a-button-input']");
    By brandFilter =By.xpath("//*[@id='p_89/OnePlus']/span/a/span");
    By filterCriterialSelected = By.xpath("//*[@id='p_36/1318506031']/span/a/span");
    By brandSelectedCheckbx = By.xpath("//*[@id='p_89/OnePlus']/span/a/div/label/input");
    By sortFeature = (By.xpath("//span[@id='a-autoid-0-announce']"));
    By priceLowToHigh = (By.xpath("//a[@id='s-result-sort-select_1']"));

    public SearchPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void applyPriceFilter(String minPrice, String maxPrice) {
        driver.findElement(minPriceField).sendKeys(minPrice);
        driver.findElement(maxPriceField).sendKeys(maxPrice);
        driver.findElement(goBtn).click();
    }

    public void applyBrandFilter(String brand) {
        driver.findElement(brandFilter).click();
    }

    public void checkFilterApplied() {
        String text = driver.findElement(filterCriterialSelected).getText();
        Assert.assertTrue(text.contains("10,000"));
    }

    public void readSelectedBrandFilter() {
        boolean isSelected = driver.findElement(brandSelectedCheckbx).isSelected();
        Assert.assertTrue(isSelected);
    }
    public void sortFeature(){
        driver.findElement(sortFeature).click();
        driver.findElement(priceLowToHigh).click();
    }



}
