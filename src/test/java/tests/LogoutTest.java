package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutTest {

    WebDriver driver;
    AccountPage accountPage;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://magento.softwaretestingboard.com/");
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        loginPage.clickSignIn();
        loginPage.enterEmail("rajini" + "78654" + "@test.com");
        loginPage.enterPassword("Rajini@123");
        loginPage.clickLogin();

        // Wait for login to complete by checking visibility of account dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")));

    }

    @Test
    public void testLogout() {

        accountPage.clickAccountDropdown();

        // Wait for Sign Out link to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")));

        accountPage.clickSignOut();

    }


}
