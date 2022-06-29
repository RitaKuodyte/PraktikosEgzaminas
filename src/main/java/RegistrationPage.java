import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    final static public String PageName = "Registracija";

    @FindBy(id = "username")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "passwordConfirm")
    private WebElement passwordConfirmElement;

    @FindBy(className = "btn-primary")
    private WebElement RegisterButtonElement;

    @FindBy(id="username.errors")
    private WebElement usernameErrorMessageElement;

    @FindBy(id="password.errors")
    private WebElement registerPasswordErrorMessageElement;

    @FindBy(id="passwordConfirm.errors")
    private WebElement registerPasswordConfirmErrorMessageElement;

    @FindBy(partialLinkText = "naują paskyrą")
    private WebElement registerButtonElement;

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

    public void clickRegister() {
        RegisterButtonElement.click();
    }

    public void fillPasswordFields(String text) {
        fillPassword(text);
        fillPasswordConfirm(text);
    }

    public String getUsernameErrorMessage() {
        return usernameErrorMessageElement.getText();
    }

    public String getRegisterPasswordErrorMessage() {
        return registerPasswordErrorMessageElement.getText();
    }

    public String getRegisterPasswordConfirmErrorMessage() {
        return registerPasswordConfirmErrorMessageElement.getText();
    }
}