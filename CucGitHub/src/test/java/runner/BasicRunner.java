package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:target/cukes", "json:target/cukes/report.json", "junit:target/cukes/junit.xml"}, features={"src/test/resources/features/basic.feature"}, glue={"stepdef"})
public class BasicRunner {

	
}

