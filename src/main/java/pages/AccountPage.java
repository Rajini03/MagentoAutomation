package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElement signOutLink;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement accountDropdown;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]")
    WebElement selectChangePassword;

    @FindBy(linkText = "Account Information")
    WebElement accountInfoLink;

    @FindBy(xpath = "//*[@id=\"change-password\"]")
    WebElement changePasswordCheckbox;

    @FindBy(xpath = "//*[@id=\"current-password\"]")
    WebElement currentPasswordField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement newPasswordField;

    @FindBy(xpath = "//*[@id=\"password-confirmation\"]")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement saveButton;

    public void clickAccountDropdown() {
        accountDropdown.click();
    }

    public void clickSignOut() {
        signOutLink.click();
    }

    public void openAccountDropdown() {
        accountDropdown.click();
    }

    public void changePassword(){
        selectChangePassword.click();
    }

    public void clickMyAccount() {
        myAccountLink.click();
    }

    public void goToAccountInformation() {
        accountInfoLink.click();
    }
    public void selectCheckbox(){
        changePasswordCheckbox.click();
    }

    public void currentPassword(String password){
        currentPasswordField.sendKeys(password);
    }

    public void newPassword(String password){
        newPasswordField.sendKeys(password);
    }

    public void confirmPassword(String password){
        confirmPasswordField.sendKeys(password);
    }

    public void saveButton(){
        saveButton.click();
    }

}
