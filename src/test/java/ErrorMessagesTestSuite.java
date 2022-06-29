import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(ErrorMessageTests.class)
@Suite.SuiteClasses({ LoginTest.class, RegistrationTest.class })
public class ErrorMessagesTestSuite {
}
