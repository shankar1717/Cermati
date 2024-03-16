package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // Specify the test runner class
@CucumberOptions(features = "Features//productSearch.feature", // Path to your feature files
		glue = { "stepdefinition" }, // Package where your step definitions are located
		stepNotifications = true, // Enable notifications for each step during the test execution
		dryRun = false, // Check whether all steps have corresponding step definitions
		//plugin = "pretty", // "html:target/cucumber-reports"}, // Plugins for reporting
		plugin = { "pretty", "html:target/cucumber-reports" }, // Plugins for reporting 
		monochrome = true, // Display the console output in a proper readable format
		publish = true, // Publish the test results to Cucumber Reports
		//strict = false, // Allow undefined and pending steps without failing the test
		tags = "@tag1"
			

)

public class TestRunner {

}
