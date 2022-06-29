import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {

    @FindBy(xpath = "/html/body/nav/div/ul[2]/a")
    private WebElement logoutElement;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogout() {
        logoutElement.click();
    }
}