import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends BaseTest {
    final String logoutMessage = "Sėkmingai atsijungėte";

    CalculatorPage calculatorPage = new CalculatorPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/");
    }

    @BeforeClass
    public static void setUpClass() {
        BaseTest.setUpClass();
        driver.get("http://localhost:8080/prisijungti");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername("test-vartotojas");
        loginPage.fillPassword("slaptazodis");
        loginPage.clickLogin();
    }

    @Test
    public void UserCanLogout() {
        assertEquals(
                "The main page must be opened",
                CalculatorPage.PageName,
                getPageTitle());

        calculatorPage.clickLogout();

        assertEquals(
                "After logging out the login page must be shown",
                LoginPage.PageName,
                getPageTitle());

        assertEquals(
                "Logout message must be shown",
                logoutMessage,
                loginPage.getLogoutMessage());
    }
}
