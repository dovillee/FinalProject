import org.example.AddToCartPage;
import org.example.CartPage;
import org.example.CheckoutPage;
import org.example.ShopPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import static org.example.utils.WaitUtils.waitForElement;
public class AddToCartTest extends BaseTest {
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    AddToCartPage addToCartPage;
    @BeforeEach
    void setup() {
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }
    @DisplayName("Add to cart product and hover on cart section to see more info about added product")
    @Test
    void addToCartAndSeeInfoInHoveredSection() {
        addToCartPage.clickAddToCart(3);
        waitForElement(driver, checkoutPage.viewCartBtn);

        Assertions.assertTrue(addToCartPage.viewCartBtn.isDisplayed(),
                "View cart button is not displayed!");

        Assertions.assertEquals(addToCartPage.productPrice(3), addToCartPage.cartPrice.getText(),
                "Price does not match");
        Assertions.assertEquals("1 item", addToCartPage.itemsCount.getText(),
                "Number of products in the cart does not match");

        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartPage.cartShortSummary)
                .perform();

        Assertions.assertEquals(addToCartPage.addedProductName.getText(), addToCartPage.productName(3),
                "Added product name in cart does not match");
        Assertions.assertEquals(addToCartPage.cartPrice.getText(), addToCartPage.productPrice(3),
                "Price in cart and price of product does not match");

        addToCartPage.clickHeaderCart();
        Assertions.assertEquals("Cart", cartPage.getCartPageTitle(),
                "User is not in the cart page");
    }
    @DisplayName("Add product to the cart and press view cart from product layout")
    @Test
    void addToCartAndGoToCartFromProductLayout() {
        addToCartPage.clickAddToCart(3);

        waitForElement(driver, checkoutPage.viewCartBtn);

        addToCartPage.clickViewCart(3);

        Assertions.assertTrue(addToCartPage.isCartBlockViewCartBtnDisplayed(),
                "View cart button is not displayed after adding product to the cart");

        Assertions.assertEquals("Cart", cartPage.getCartPageTitle(),
                "User is not in the cart page");
    }

    //comment
}
