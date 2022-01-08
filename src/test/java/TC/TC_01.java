package TC;

import Data.ExcelRead;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class TC_01 {
    private WebDriver driver;
    private Home home_page;
    private SignUP signUP_page;
    private Products_results products_results;
    private Checkout checkout;
    private Orders orders;
    private SignIn signIn;







    @BeforeClass
    public void SetUp()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1024,768));
        home_page=new Home(driver);
        signUP_page=new SignUP(driver);
        products_results=new Products_results(driver);
        checkout=new Checkout(driver);
        orders=new Orders(driver);
        signIn=new SignIn(driver);


    }
    @DataProvider
    public Object[][] testdata() throws Throwable {
        Object data [][]=ExcelRead.getDataFromExcel("Data");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void Verify_That_user_signUP_Then_navgate_To_home(String email,String firstname,String lastname,String password,String address ,String City ,String zip,String mopile){

       home_page.Create_new_Account(email);
       signUP_page.signup(firstname,lastname,password,address,City,zip,mopile);
        signUP_page.assert_User_login_correctly();
        home_page.Click_on_sign_out();
        signIn.User_LogIn(email,password);
        home_page.Select_SubCategory();
        products_results.click_on_Product();
        products_results.click_on_add_cart();
        checkout.Checkout_procedure();
        checkout.Select_Payment_method();
        checkout.Click_on_Confirm_order();
        checkout.Click_Back_To_OrderH();
        orders.Assert_order_history_is_existed();
        home_page.Click_on_sign_out();


    }


    @AfterClass
    public void TearDown(){
        driver.quit();
    }

}
