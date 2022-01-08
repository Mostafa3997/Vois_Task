package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
    private WebDriver driver;
    //Create Constructor

    public SignIn (WebDriver driver){this.driver=driver;}
    //Identify Elements

    private By emailField=By.id("email");
    private By pass=By.id("passwd");
    private By signInBTN=By.id("SubmitLogin");

    //Actions
    public void User_LogIn(String email,String password){
        driver.findElement(emailField).isDisplayed();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(pass).isDisplayed();
        driver.findElement(pass).sendKeys(password);
        driver.findElement(signInBTN).click();
    }
}
