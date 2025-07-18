package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupTest {

    WebDriver driver;
    SignupPage signupPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        signupPage = new SignupPage(driver);
    }

    @Test
    public void testSignup() {
        signupPage.clickCreateAccount();
        signupPage.enterFirstName("Rajini");
        signupPage.enterLastName("Chippa");
        signupPage.enterEmail("rajini" + "78654" + "@test.com");
        signupPage.enterPassword("Rajini@123");
        signupPage.enterConfirmPassword("Rajini@123");
        signupPage.clickCreateAccountButton();
    }


}
