package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.clickSignIn();
        loginPage.enterEmail("rajini" + "78654" + "@test.com");
        loginPage.enterPassword("Rajini@123");
        loginPage.clickLogin();
    }


}
