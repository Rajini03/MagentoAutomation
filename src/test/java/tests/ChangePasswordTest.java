package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AccountPage;
import pages.LoginPage;

import java.time.Duration;

public class ChangePasswordTest {

    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;
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

        // Login first
        loginPage.clickSignIn();
        loginPage.enterEmail("rajini" + "78654" + "@test.com");
        loginPage.enterPassword("Rajini@123");  // current password
        loginPage.clickLogin();

        wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")));
    }

    @Test
    public void testChangePassword() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")));
        accountPage.clickAccountDropdown();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")));
        accountPage.clickMyAccount();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]")));
        accountPage.changePassword();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"current-password\"]")));
        accountPage.currentPassword("Rajini@123");

        accountPage.newPassword("Rajini@321");

        accountPage.confirmPassword("Rajini@321");

        accountPage.saveButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
        System.out.println("Password changed successfully");


    }


}

