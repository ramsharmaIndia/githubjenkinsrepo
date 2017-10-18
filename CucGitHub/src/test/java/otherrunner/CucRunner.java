package otherrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:target/myCucReport"}, features={"src/mycuc/features"})
public class CucRunner {

	
}


