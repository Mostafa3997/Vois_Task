package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orders {
    private WebDriver driver;
    //Create Constructor
    public Orders(WebDriver driver){this.driver=driver;}
    //Identify Elements
    private By Myorder= By.xpath("//tr[@class='first_item ']");
    //Actions
    public void Assert_order_history_is_existed(){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Myorder));
        driver.findElement(Myorder).isDisplayed();
    }
}
