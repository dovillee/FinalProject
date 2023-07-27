package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(className = "product_title")
    public WebElement productTitle;
    @FindBy(className = "summary")
    public WebElement productInfo;
    @FindBy(className = "single_add_to_cart_button")
    private WebElement addToCartFromProductPage;
    @FindBy(className = "qty")
    private WebElement inputQty;
    @FindBy(className = "woocommerce")
    private WebElement alert;
    @FindBy(className = "posted_in")
    private WebElement productCategory;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public boolean isProductInfoDisplayed() {
        return productInfo.isDisplayed();
    }
    public void clickAddToCartFromProductPage() {
        addToCartFromProductPage.click();
    }
    public void clearInputQty() {
        inputQty.clear();
    }
    public void writeQty(String numberQty) {
        inputQty.sendKeys(numberQty);
    }
    public boolean isAlertDisplayed() {
        return alert.isDisplayed();
    }
    public String getAlertText() {
        return alert.getText();
    }
    public String getProductCategoryText() {
        return alert.getText();
    }
    public String getProductNameInProductPage() {
        return productTitle.getText();
    }
}
