import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;

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
    public void UserCanOpenRegistrationPage() {
        loginPage.goToRegisterAccountPage();
        assertEquals("Page name must match", "Registracija", registrationPage.getTitle());
        assertTrue("Url must match", registrationPage.getCurrentUrl().contains("registruoti"));
    }
}
