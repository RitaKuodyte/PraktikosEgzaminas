import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "username")
    private WebElement usernameElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(className = "btn-primary")
    private WebElement loginButtonElement;

    @FindBy(partialLinkText = "naują paskyrą")
    private WebElement registerButtonElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String text) {
        usernameElement.sendKeys(text);
    }

    public void fillPassword(String text) {
        passwordElement.sendKeys(text);
    }

    public void clickLogin() {
        loginButtonElement.click();
    }

    public void goToRegisterAccountPage() {
        registerButtonElement.click();
    }
}
