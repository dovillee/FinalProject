package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LostPasswordPage extends BasePage {
    @FindBy(id = "user_login")
    private WebElement username;
    @FindBy(className = "woocommerce-Button")
    private WebElement resetPasswordBtn;
    @FindBy(className = "entry-title")
    private WebElement pageTitle;
    @FindBy(className = "woocommerce-error")
    private WebElement errorInvalid;
    public LostPasswordPage(WebDriver driver) {
        super(driver);
    }
    public void writeUsername(String item) {
        username.sendKeys(item);
    }
    public void clickResetPassword() {
        resetPasswordBtn.click();
    }
    public String getPageTitle() {
        return pageTitle.getText();
    }
    public String getErrorText() {
        return errorInvalid.getText();
    }
}
