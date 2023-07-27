import org.example.AddToCartPage;
import org.example.ShopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.example.utils.WaitUtils.waitForElement;
public class ShopPageTest extends BaseTest {
    ShopPage shopPage;
    AddToCartPage addToCartPage;
    @BeforeEach
    public void setUp() {
        shopPage = new ShopPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }

    @Test
    @DisplayName("User can sort products by Popularity sorting")
    public void sortingByPopularity() {
        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("popularity");

        waitForElement(driver, shopPage.productPlaceHolder);

        assertAll("By Popularity sorting products are 'Ceramic Flower Pot' and 'Minimalist ceramic lamp'",
                () -> assertEquals("Ceramic Flower Pot", addToCartPage.productName(1),
                        "First product name is not the same"),
                () -> assertEquals("Minimalist ceramic lamp", addToCartPage.productName(2),
                        "Second product name is not the same")
        );
    }
    @Test
    @DisplayName("User can sort products by Default sorting")
    public void sortingByDefault() {
        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("rating");
        shopPage.selectSortingOptionsInDropdown("menu_order");
        assertAll("Default sorting products are 'Ceramic Flower Pot' and 'Classic TV stand'",
                () -> assertEquals("Ceramic Flower Pot", addToCartPage.productName(1),
                        "First product name is not the same"),
                () -> assertEquals("Classic TV stand", addToCartPage.productName(2),
                        "Second product name is not the same")
        );
    }
    @Disabled
    public void sortingByRating() {
        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("rating");
    }
    @Disabled
    public void sortingByLatest() {
        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("date");
    }
    @Disabled
    public void sortingByPriceLowToHigh() {
        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("price");
    }
    @Disabled
    public void sortingByPriceHighToLow() {
        shopPage.clickDropdown();
        shopPage.selectSortingOptionsInDropdown("price-desc");
    }
    @Test
    @DisplayName("User can navigate to the next and previous page with numbered buttons")
    public void goingToTheNextPageWithNumberedButton() {
        shopPage.getCurrentPageNumberText();
        assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");

        shopPage.clickNumberButtonOfTheOtherPage();
        assertEquals("2", shopPage.getCurrentPageNumberText(), "User is not in the second page!");

        shopPage.clickNumberButtonOfTheOtherPage();
        assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");

    }
    @Test
    @DisplayName("User can navigate to the next and previous page with arrow buttons")
    public void goingToTheNextPageWithArrows() {
        shopPage.getCurrentPageNumberText();
        assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");

        shopPage.clickArrowButtonToTheNextPage();
        assertEquals("2", shopPage.getCurrentPageNumberText(), "User is not in the second page!");

        shopPage.clickPreviousPageArrowButton();
        assertEquals("1", shopPage.getCurrentPageNumberText(), "User is not in the first page!");
    }

    @Test
    @DisplayName("User can search product with header search bar")
    public void searchProductsInHeaderBar() {
        shopPage.writeProductInHeaderSearchBar("bed");

        assertAll("User is in search results page",
                () -> assertTrue(shopPage.isPageTitleDisplayed(), "Search results title is not displayed!"),
                () -> assertEquals("Search results: “bed”", shopPage.getPageTitle(), "Page title is not the same!")
        );
    }
    @Test
    @DisplayName("User can search product with side menu search bar")
    public void searchProductsInSideMenuSearchBar() {
        shopPage.clickSideMenuSearchBar();
        shopPage.writeProductInSideMenuSearchBar("curtains");

        assertAll("User is in search results page",
                () -> assertTrue(shopPage.isPageTitleDisplayed(), "Search results title is not displayed!"),
                () -> assertEquals("Search Results for: curtains", shopPage.getPageTitle(), "Page title is not the same!")
        );
    }
    @Test
    @DisplayName("User can add more keywords to current search")
    public void addMoreKeywordsToCurrentSearch() {
        shopPage.clickSideMenuSearchBar();
        shopPage.writeProductInSideMenuSearchBar("curtains");

        assertAll("User is in search results page",
                () -> assertTrue(shopPage.isPageTitleDisplayed(), "Search results title is not displayed!"),
                () -> assertEquals("Search Results for: curtains", shopPage.getPageTitle(), "Page title is not the same!")
        );

        shopPage.writeProductInSideMenuSearchBar(" brown");
        assertEquals("Search Results for: curtains brown", shopPage.getPageTitle(), "Page title is not the same!");
    }

// test
}