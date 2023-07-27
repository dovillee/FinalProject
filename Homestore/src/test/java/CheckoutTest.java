import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.utils.WaitUtils.waitForElement;
public class CheckoutTest extends BaseTest {
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    WebDriverWait wait;
    AddToCartPage addToCartPage;

    @BeforeEach
    public void setUp() {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        addToCartPage = new AddToCartPage(driver);

        addToCartPage.clickAddToCart(3);
        waitForElement(driver, checkoutPage.viewCartBtn);
        addToCartPage.clickViewCart(3);
        cartPage.clickProceedToCheckout();
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/succsessLoginDetails.csv", numLinesToSkip = 1)
    void fillInSuccessfulBillingInfo(String firstName, String lastName, String country, String streetAddress,
                              String town, String county, String zip, String phone, String email) {

        checkoutPage.isOrderInfoDisplayed();
        checkoutPage.writeFirstName(firstName);
        checkoutPage.writeLastName(lastName);
        checkoutPage.clickCountry();
        checkoutPage.writeInput(country);
        checkoutPage.writeStreetAddress(streetAddress);
        checkoutPage.writeTown(town);
        checkoutPage.clickCounty();
        checkoutPage.writeInput(county);
        checkoutPage.writeZIP(zip);
        checkoutPage.writePhoneNumber(phone);
        checkoutPage.writeEmail(email);

        checkoutPage.isInfoMessageDisplayed();
        checkoutPage.clickPlaceOrderBtn();
        waitForElement(driver, checkoutPage.errorMsgRequiredField);
        Assertions.assertTrue(checkoutPage.isRequiredFieldErrorMSGDisplayed(), "Error message is not displayed");
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/billingInfoDetails.csv", numLinesToSkip = 1)
    void fillInNotAllBillingInfo(String firstName, String lastName, String country, String streetAddress,
                                 String town, String county, String zip, String phone, String email) {

        checkoutPage.isOrderInfoDisplayed();
        checkoutPage.writeFirstName(firstName);
        checkoutPage.writeLastName(lastName);
        checkoutPage.clickCountry();
        checkoutPage.writeInput(country);
        checkoutPage.writeStreetAddress(streetAddress);
        checkoutPage.writeTown(town);
        checkoutPage.clickCounty();
        checkoutPage.writeInput(county);
        checkoutPage.writeZIP(zip);
        checkoutPage.writePhoneNumber(phone);
        checkoutPage.writeEmail(email);

        checkoutPage.isInfoMessageDisplayed();
        checkoutPage.clickPlaceOrderBtn();
        waitForElement(driver, checkoutPage.errorMsgRequiredField);
        Assertions.assertTrue(checkoutPage.isRequiredFieldErrorMSGDisplayed(), "Error message is not displayed");

    }
}
