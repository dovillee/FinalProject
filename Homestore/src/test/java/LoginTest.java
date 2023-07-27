import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    ShopPage shopPage;
    LostPasswordPage lostPasswordPage;

    @BeforeEach
    public void setUp() {
        shopPage = new ShopPage(driver);
        loginPage = new LoginPage(driver);
        lostPasswordPage = new LostPasswordPage(driver);
        shopPage.clickMyAccount();
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logindetails.csv", numLinesToSkip = 1)
    void loginWithInvalidCredentials(String username, String password) {

        loginPage.writeUsername(username);
        loginPage.writePassword(password);
        loginPage.checkRememberMe();
        loginPage.clickLogin();

        Assertions.assertTrue(loginPage.isLoginErrorDisplayed(), "Login Error message is not displayed!");
    }
    @Test
    void cantResetPasswordWithInvalidData() {

        loginPage.clickLostPassword();
        Assertions.assertEquals("Lost password", lostPasswordPage.getPageTitle(),
                "Page title is not the same!");

        lostPasswordPage.writeUsername("username");
        lostPasswordPage.clickResetPassword();

        Assertions.assertEquals("Invalid username or email.", lostPasswordPage.getErrorText(),
                "Error message text does not match!");
    }
}
