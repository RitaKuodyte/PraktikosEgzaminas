import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
}
