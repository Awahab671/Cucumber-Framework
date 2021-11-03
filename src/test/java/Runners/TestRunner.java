package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/AddEmployee.feature/",
        glue = "steps",


       dryRun = false,
        monochrome = true, // we always keep it true and it removes the irrelevant info from our console.
        tags = "@datatable"
)



public class TestRunner {
}
