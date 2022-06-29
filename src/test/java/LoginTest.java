import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class LoginTest extends BaseTest {
    final String loginErrorMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    CalculatorPage calculatorPage = new CalculatorPage(driver);

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/prisijungti");
    }

    @Test
    public void UserCanLogin() {
        loginPage.fillUsername("test-vartotojas");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();

        if (loginPage.getTitle().equals("Prisijungimas")) {
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
                    "Skaičiuotuvas",
                    calculatorPage.getTitle());

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
                "Registracija",
                registrationPage.getTitle());
        assertTrue(
                "Url must match",
                registrationPage.getCurrentUrl().contains("registruoti"));
    }
}
