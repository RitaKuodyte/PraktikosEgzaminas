import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class LoginTest extends BaseTest {
    final String loginErrorMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/prisijungti");
    }

    @Test
    public void UserCanLogin() {
        loginPage.fillUsername("test-vartotojas");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();

        if (getPageTitle().equals(LoginPage.PageName)) {
            loginPage.fillUsername("");
            loginPage.fillPassword("");
            loginPage.clickLogin();
            assertEquals(
                    "User doesn't exist and the error must be shown",
                    loginErrorMessage,
                    loginPage.getLoginErrorMessage());
        } else {
            assertEquals(
                    "User exists and user must be redirected to main page",
                    CalculatorPage.PageName,
                    getPageTitle());
        }
    }

    @Test
    @Category(ErrorMessageTests.class)
    public void ShowsLoginError() {
        loginPage.fillUsername("");
        loginPage.fillPassword("");
        loginPage.clickLogin();
        assertEquals(
                "Page must show error message",
                loginErrorMessage,
                loginPage.getLoginErrorMessage());

        loginPage.fillUsername("");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();
        assertEquals(
                "Page must show error message",
                loginErrorMessage,
                loginPage.getLoginErrorMessage());

        loginPage.fillUsername("vartotojas222");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();
        assertEquals(
                "Page must show error message",
                loginErrorMessage,
                loginPage.getLoginErrorMessage());
    }

    @Test
    public void UserCanOpenRegistrationPage() {
        loginPage.goToRegisterAccountPage();
        assertEquals(
                "Page name must match",
                RegistrationPage.PageName,
                getPageTitle());
        assertTrue(
                "Url must match",
                getPageUrl().contains("registruoti"));
    }
}
