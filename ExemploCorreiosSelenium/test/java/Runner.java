import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =
                "test/resources/features/rastrear_objeto.feature",
        glue = "steps",
        monochrome = true,
        //plugin = {"pretty", "html:target/report-html/rastrear-objeto"},
        plugin = "pretty",
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        tags = "@validar"
)
public class Runner {
}
