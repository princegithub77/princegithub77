package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/feature/ANZ.feature"},
		glue= {"stepdefs"}, 
		monochrome=true
//		plugin = {"pretty",
//				"html:target/cucumber-reports",
//				"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
//				"json:target/cucumber-reports/cucumber.json",
//				"com.happiestminds.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//		}

		)
public class ANZ {

}
