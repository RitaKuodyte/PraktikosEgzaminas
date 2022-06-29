import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage(driver);
    CalculatorPage calculatorPage = new CalculatorPage(driver);

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/registruoti");
    }

    @Test
    public void UserCanRegister() {
        registrationPage.fillUsername("test-vartotojas");
        registrationPage.fillPasswordFields("slaptazodis");
        registrationPage.clickRegister();

        if (registrationPage.getTitle().equals("Registracija")) {
            assertEquals(
                    "Page must show error message for existing user",
                    "Toks vartotojo vardas jau egzistuoja",
                    registrationPage.getUsernameErrorMessage());
        } else {
            assertEquals(
                    "After registration user must be redirected to different page",
                    "Skaičiuotuvas",
                    calculatorPage.getTitle());
        }
    }

    @Test
    @Category(ErrorMessageTests.class)
    public void ShowErrorPasswordsDoesntMatch() {
        registrationPage.fillUsername("");
        registrationPage.fillPassword("slaptazodis");
        registrationPage.fillPasswordConfirm("");
        registrationPage.clickRegister();
        assertEquals(
                "Page must show error message",
                "Įvesti slaptažodžiai nesutampa",
                registrationPage.getRegisterPasswordConfirmErrorMessage());

        registrationPage.fillUsername("");
        registrationPage.fillPassword("slaptazodis");
        registrationPage.fillPasswordConfirm("slaptazodis123");
        registrationPage.clickRegister();
        assertEquals(
                "Page must show error message",
                "Įvesti slaptažodžiai nesutampa",
                registrationPage.getRegisterPasswordConfirmErrorMessage());
    }

    @Test
    @Category(ErrorMessageTests.class)
    public void ShowErrorMinimumSymbolCount() {
        registrationPage.fillUsername("");
        registrationPage.fillPassword("");
        registrationPage.clickRegister();
        assertEquals(
                "Page must show error message",
                "Šį laukelį būtina užpildyti\n" +
                        "Privaloma įvesti nuo 3 iki 32 simbolių",
                registrationPage.getUsernameErrorMessage());
        assertEquals(
                "Page must show error message about minimum symbol count",
                "Šį laukelį būtina užpildyti\n" +
                        "Privaloma įvesti bent 3 simbolius",
                registrationPage.getRegisterPasswordErrorMessage());

        registrationPage.fillUsername("vartotojas123");
        registrationPage.fillPassword("");
        registrationPage.fillPasswordConfirm("");
        registrationPage.clickRegister();
        assertEquals(
                "Page must show error message about minimum symbol count",
                "Šį laukelį būtina užpildyti\n" +
                        "Privaloma įvesti bent 3 simbolius",
                registrationPage.getRegisterPasswordErrorMessage());
    }

    @Test
    @Category(ErrorMessageTests.class)
    public void ShowErrorUserExists() {
        registrationPage.fillUsername("admin");
        registrationPage.fillPassword("");
        registrationPage.fillPasswordConfirm("");
        registrationPage.clickRegister();
        assertEquals(
                "Page must show error message for existing user",
                "Toks vartotojo vardas jau egzistuoja",
                registrationPage.getUsernameErrorMessage());
    }
}
