package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\features",
glue = "stepDefinitions",
dryRun = false,monochrome = true,tags = "",
plugin = {"pretty",
        "html:target/cucumber-reports/testexecution.html",
        "json:target/cucumber-reports/testexecution.json",
        "rerun:target/failed_scenarios.txt"

})


public class Junit4Runner {
}
