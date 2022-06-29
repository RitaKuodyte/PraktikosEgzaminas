import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/prisijungti");
    }

    @Test
    public void UserCanLogin() {
        loginPage.fillUsername("vartotojas");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();
    }

    @Test
    public void ShowsLoginError() {
        loginPage.fillUsername("");
        loginPage.fillPassword("");
        loginPage.clickLogin();
        assertEquals(
                "Page must show error message",
                "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",
                loginPage.getLoginErrorMessage());

        loginPage.fillUsername("");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();
        assertEquals(
                "Page must show error message",
                "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",
                loginPage.getLoginErrorMessage());

        loginPage.fillUsername("vartotojas222");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();
        assertEquals(
                "Page must show error message",
                "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",
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
