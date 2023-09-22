package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/main/resources/demo.feature",
        publish = true,
        plugin = {"pretty", "html:report/TestReport.html"},
        glue = {"StepDefs"}
        )
public class RunnerClass {
}
