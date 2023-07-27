package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(className = "checkout-button")
    public WebElement proceedToCheckoutBtn;
    @FindBy(className = "entry-title")
    public WebElement pageTitle;
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clickProceedToCheckout() {
        proceedToCheckoutBtn.click();
    }
    public String getCartPageTitle() {
        return pageTitle.getText();
    }
}
