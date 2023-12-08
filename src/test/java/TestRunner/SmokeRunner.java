package TestRunner;
// Here we map both the feature file and StepDefinition in our Runner class

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features" ,
        glue = "StepDefinitions",
        dryRun = false,
        tags = "@testcase2",
        plugin = {"pretty", "html:target/Cucumber.html", "json:target/Cucumber.json", "rerun:target/failed.txt"}
)

// copy feature's Path/references/Paste -- copy path/paste from StepDefinitions the Full Name
// After we run it, in Console Cucumber will print the auto-generated corresponding code based on my Feature File test cases
// Or the Gherkin steps (Scenario) that we don't have the testing code... copy/paste them in StepDefinition (Login class)
// dryRun = true --> it will generate code for the feature file steps. But if we want to run the runner, it should dryRun = true.
// tags option will execute the tagged testcases as mentioned in TestRunner class, even we add more tagged tescases
// like this : " @testcase1 or @testcase2 "
// plugin option makes the console more readable and organized
// "html:target/Cucumber.html" : Creates Cucumber.html file under target folder --> shows testcase report (right-click ->open in->browser Chrome
// "rerun:target/failed.txt" : shows report ( failed.txt) under target folder--> which ONLY testcase/line failed

public class SmokeRunner {

}
