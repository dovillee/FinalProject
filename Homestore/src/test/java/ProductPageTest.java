import org.example.AddToCartPage;
import org.example.ProductPage;
import org.example.ShopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductPageTest extends  BaseTest {
    ShopPage shopPage;
    ProductPage productPage;
    AddToCartPage addToCartPage;
    @BeforeEach
    public void setUp() {
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }
    @Test
    @DisplayName("User can see chosen product information and add written quantity it to cart")
    public void addToCartWithChangedWrittenQty() {
        addToCartPage.clickProduct(2);

        assertEquals("Classic TV stand", productPage.getProductNameInProductPage(), "Page title is not the same!");
        assertTrue(productPage.getProductCategoryText().contains("Living Room"), "Product category is not the same!");

        productPage.isProductInfoDisplayed();
        productPage.clearInputQty();
        productPage.writeQty("2");
        productPage.clickAddToCartFromProductPage();

        assertTrue(productPage.isAlertDisplayed(), "Alert is not displayed");
    }
}