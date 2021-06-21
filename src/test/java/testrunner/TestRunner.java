package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/",glue= {"stepdefinitions"},

 plugin = {"pretty", // to generate reports
         "html:target/html/htmlreport.html",
         "json:target/json/file.json",
         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
         },
        publish=false,
        dryRun=false
)
public class TestRunner {

}
