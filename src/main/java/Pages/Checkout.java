package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private WebDriver driver;
    //Create Constructor
    public Checkout(WebDriver driver){this.driver=driver;}
     //Identify Elements
    private By CheckoutBtn= By.xpath("//span[contains(.,'Proceed to checkout')]");
    private By CheckoutBTn2=By.xpath("(//span[contains(.,'Proceed to checkout')])[2]");
    private By termsRadioBTN=By.id("cgv");
    private By BankLink=By.xpath("//a[@title='Pay by bank wire']");
    private By confirmBTN=By.xpath("//span[contains(.,'I confirm my order')]");
    private By BackBTN=By.xpath("//a[@title='Back to orders']");

     //Actions
    public void Checkout_procedure(){
        driver.findElement(CheckoutBtn).isDisplayed();
        driver.findElement(CheckoutBtn).click();
        driver.findElement(CheckoutBTn2).isDisplayed();
        driver.findElement(CheckoutBTn2).click();
        driver.findElement(CheckoutBTn2).click();
        driver.findElement(termsRadioBTN).click();
        driver.findElement(CheckoutBTn2).click();

    }
    public void Select_Payment_method(){
        driver.findElement(BankLink).click();
    }
    public void Click_on_Confirm_order(){
        driver.findElement(confirmBTN).click();
    }
    public void Click_Back_To_OrderH(){
        driver.findElement(BackBTN).click();
    }
}
