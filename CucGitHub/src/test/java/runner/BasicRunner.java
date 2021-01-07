package runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin={"pretty", "html:target/cukes", "json:target/cukes/report.json", "junit:target/cukes/junit.xml"}, 
				features={"src/test/resources/features/basic.feature"}, glue={"stepdef"})
@Test
public class BasicRunner extends AbstractTestNGCucumberTests{

//A general comment
	
}

