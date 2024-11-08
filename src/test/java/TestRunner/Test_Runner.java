package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/featureFile",
		glue = "stepDefinitation",
		plugin = {"html: target/cucumber_report.html"},
		monochrome = true
		
		)
public class Test_Runner extends AbstractTestNGCucumberTests{
	
	

}
