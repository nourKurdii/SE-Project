package soft;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/wikipedia.html"},
        monochrome = true,
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        features = "use_cases",
        glue = "soft"
)

class acceptanceTest {

}
