package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing_first_name")
    private WebElement firstName;
    @FindBy(id = "billing_last_name")
    private WebElement lastName;
    @FindBy(id = "select2-billing_country-container")
    private WebElement country;
    @FindBy(id = "billing_address_1")
    private WebElement address;
    @FindBy(id = "billing_city")
    private WebElement town;
    @FindBy(id = "select2-billing_state-container")
    private WebElement county;
    @FindBy(id = "billing_postcode")
    private WebElement zip;
    @FindBy(id = "billing_phone")
    private WebElement phone;
    @FindBy(id = "billing_email")
    private WebElement email;
    @FindBy(className = "woocommerce-info")
    private WebElement infoMessage;
    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;
    @FindBy(id = "order_review_heading")
    private WebElement orderInfo;
    @FindBy(className = "select2-search__field")
    private WebElement dropdownInput;
    @FindBy(className = "woocommerce-error")
    public WebElement errorMsgRequiredField;

    @FindBy(xpath = "//a[@title='View cart']")
    public WebElement viewCartBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void writeFirstName(String item) {
        firstName.sendKeys(item);
    }
    public void writeLastName(String item) {
        lastName.sendKeys(item);
    }
    public void clickCountry() {
        country.click();
    }
    public void writeInput(String item){
        dropdownInput.sendKeys(item + Keys.ENTER);
    }
    public void writeStreetAddress(String item) {
        address.sendKeys(item);
    }
    public void writeTown(String item) {
        town.sendKeys(item);
    }
    public void clickCounty(){
        county.click();
    }
    public void writeZIP(String item) {
        zip.sendKeys(item);
    }
    public void writePhoneNumber(String item) {
        phone.sendKeys(item);
    }
    public void writeEmail(String item) {
        email.sendKeys(item);
    }
    public void clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }
    public boolean isOrderInfoDisplayed() {
        return orderInfo.isDisplayed();
    }
    public boolean isInfoMessageDisplayed() {
        return infoMessage.isDisplayed();
    }
    public boolean isRequiredFieldErrorMSGDisplayed() {
        return errorMsgRequiredField.isDisplayed();
    }
}
