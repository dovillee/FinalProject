package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AddToCartPage extends BasePage {
    @FindBy(css = ".product")
    public List<WebElement> productLayout;
    @FindBy(css = ".added_to_cart")
    public WebElement viewCartBtn;
    @FindBy(id = "site-header-cart")
    public WebElement cartShortSummary;
    @FindBy(className = "wp-element-button")
    public WebElement cartBlockViewCartBtn;
    @FindBy(className = "woocommerce-Price-amount")
    public WebElement cartPrice;
    @FindBy(className = "count")
    public WebElement itemsCount;
    @FindBy(xpath ="//*[@id=\"site-header-cart\"]/li[2]/div/div/ul/li/a[2]")
    public WebElement addedProductName;
    @FindBy(id = "site-header-cart")
    public WebElement headerCart;
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }
    public void clickAddToCart(int productNumber) {
        productLayout.get(productNumber -1)
                .findElement(By.cssSelector(".add_to_cart_button"))
                .click();
    }
    public String productPrice(int productNumber) {
        return productLayout.get(productNumber -1)
                .findElement(By.className("woocommerce-Price-amount"))
                .getText();
    }
    public void clickViewCart(int productNumber) {
        productLayout.get(productNumber - 1)
                .findElement(By.cssSelector(".added_to_cart"))
                .click();
    }
    public String productName(int productNumber){
        return productLayout.get(productNumber - 1)
                .findElement(By.cssSelector(".woocommerce-loop-product__title"))
                .getText();
    }
    public void clickProduct(int productNumber) {
        productLayout.get(productNumber - 1)
                .findElement(By.cssSelector(".woocommerce-loop-product__title"))
                .click();
    }
    public boolean isCartBlockViewCartBtnDisplayed() {
        return cartBlockViewCartBtn.isDisplayed();
    }
    public void clickHeaderCart() {headerCart.click(); }
}
