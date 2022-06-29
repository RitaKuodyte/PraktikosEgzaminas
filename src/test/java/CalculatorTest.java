import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
public class CalculatorTest extends BaseTest {

    CalculatorPage calculatorPage = new CalculatorPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/skaiciuotuvas");
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
                "Skaičiuotuvas",
                calculatorPage.getTitle());

        calculatorPage.clickLogout();

        assertEquals(
                "After logging out the login page must be shown",
                "Prisijungimas",
                loginPage.getTitle());
    }
}
