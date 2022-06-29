import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "passwordConfirm")
    private WebElement passwordConfirmElement;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String text) {
        usernameElement.sendKeys(text);
    }

    public void fillPassword(String text) {
        passwordElement.sendKeys(text);
    }

    public void fillPasswordConfirm(String text) {
        passwordConfirmElement.sendKeys(text);
    }

    public void fillPasswordFields(String text) {
        fillPassword(text);
        fillPasswordConfirm(text);
    }
}
