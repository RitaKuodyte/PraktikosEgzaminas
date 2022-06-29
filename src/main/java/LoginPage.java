import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    final static public String PageName = "Prisijungimas";

    @FindBy(name = "username")
    private WebElement usernameElement;

    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(className = "btn-primary")
    private WebElement loginButtonElement;

    @FindBy(partialLinkText = "naują paskyrą")
    private WebElement registerButtonElement;

    @FindBy(xpath = "/html/body/div/form/div/span[2]")
    private WebElement loginErrorMessageElement;

    @FindBy(xpath = "/html/body/div/form/div/span[1]")
    private WebElement logoutSuccessfulMessageElement;

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

    public String getLoginErrorMessage() {
        return loginErrorMessageElement.getText();
    }

    public String getLogoutMessage() {
        return logoutSuccessfulMessageElement.getText();
    }
}
