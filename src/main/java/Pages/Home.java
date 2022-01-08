package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Home {
    private WebDriver driver;
    //Create Constructor
    public Home(WebDriver driver){
        this.driver=driver;
    }

    //Identify Elements
    private By SignInButton= By.xpath("//a[contains(.,'Sign in')]");
    private By EmailInput=By.id("email_create");
    private By Create_Account_Button=By.id("SubmitCreate");
    private By Validation_error=By.xpath("//li[contains(.,'Invalid email address.')]");
    private By women=By.xpath("(//a[contains(.,'Women')])[1]");
    private By Beloss=By.xpath("(//a[contains(.,'Blouses')])[1]");
    private By SignOut=By.xpath("(//a[contains(.,'Sign out')])[1]");


    //Actions
    public void Create_new_Account(String email){
        driver.findElement(SignInButton).click();
        driver.findElement(EmailInput).sendKeys(email);
        driver.findElement(Create_Account_Button).click();
    }
    public void Select_SubCategory(){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(women)).build().perform();
        driver.findElement(Beloss).click();
    }
    public SignIn Click_on_sign_out(){
        driver.findElement(SignOut).click();
        return new SignIn(driver);
    }


}
