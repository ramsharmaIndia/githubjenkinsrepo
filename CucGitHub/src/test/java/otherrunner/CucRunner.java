package otherrunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin={"pretty","html:target/myCucReport"}, features={"src/mycuc/features"})
@Test
public class CucRunner  extends AbstractTestNGCucumberTests{

	
}


