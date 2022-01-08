package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUP {
    //Identify Elements

    private By Title =By.id("id_gender1");
    private By FirstName =By.id("customer_firstname");
    private By LastName =By.id("customer_lastname");
    private By password =By.id("passwd");
    private By address =By.id("address1");
    private By city =By.id("city");
    private By ZipCode =By.id("postcode");
    private By Mopile=By.id("phone_mobile");
    private By registerBTN=By.xpath("//span[contains(.,'Register')]");
    private By State=By.id("id_state");
    private By errorMessage=By.xpath("//div[@class='alert alert-danger']");
    private By SignOut=By.xpath("(//a[contains(.,'Sign out')])[1]");


    //Create Constructor
    private WebDriver driver;
    public SignUP(WebDriver driver){
        this.driver=driver;
    }
    //Actions






    public void signup(String firstname,String lastname,String  Password,String Address, String City,String zipcode, String mopile ){
        driver.findElement(Title).click();
        driver.findElement(FirstName).isDisplayed();
        driver.findElement(FirstName).sendKeys(firstname);
        driver.findElement(LastName).isDisplayed();
        driver.findElement(LastName).sendKeys(lastname);
        driver.findElement(password).isDisplayed();
        driver.findElement(password).sendKeys(Password);
        driver.findElement(address).isDisplayed();
        driver.findElement(address).sendKeys(Address);
        driver.findElement(city).isDisplayed();
        driver.findElement(city).sendKeys(City);
        Select selectState=new Select(driver.findElement(State));
        selectState.selectByValue("3");
        driver.findElement(ZipCode).isDisplayed();
        driver.findElement(ZipCode).sendKeys(zipcode);
        driver.findElement(Mopile).isDisplayed();
        driver.findElement(Mopile).sendKeys(mopile);
        driver.findElement(registerBTN).isDisplayed();
        driver.findElement(registerBTN).click();

    }
    public void assert_User_login_correctly(){
        driver.findElement(SignOut).isDisplayed();
    }
    public void assert_on_erorr(){
        driver.findElement(errorMessage).isDisplayed();
    }
}
