package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products_results {
    private WebDriver driver;
    //Create Constructor
    public Products_results(WebDriver driver){
        this.driver=driver;
    }


    //identify Elements
    private By BLOUSESTResult = By.xpath("//img[@title='Blouse']");
    public By addToCart=By.xpath("//button//span[contains(.,'Add to cart')]");

   //Actions
    public void click_on_Product(){
        driver.findElement(BLOUSESTResult).isDisplayed();
        driver.findElement(BLOUSESTResult).click();
    }
    public Checkout click_on_add_cart(){
        driver.findElement(addToCart).isDisplayed();
        driver.findElement(addToCart).click();
        return new Checkout(driver);
    }
}
