package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "rememberme")
    private WebElement rememberMeCheckbox;
    @FindBy(name = "login")
    private WebElement loginBtn;
    @FindBy(css = "a[href$=\"/lost-password\"]")
    private WebElement lostPasswordBtn;
    @FindBy(className = "woocommerce-error")
    private WebElement loginError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void writeUsername(String item) {
        username.sendKeys(item);
    }
    public void writePassword(String item) {
        password.sendKeys(item);
    }
    public void checkRememberMe() {
        rememberMeCheckbox.click();
    }
    public void clickLogin() {
        loginBtn.click();
    }
    public void clickLostPassword() {
        lostPasswordBtn.click();
    }
    public boolean isLoginErrorDisplayed() {
        return loginError.isDisplayed();
    }
}
