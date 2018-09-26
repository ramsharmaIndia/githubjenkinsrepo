package otherrunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(plugin={"pretty","html:target/myCucReport"}, features={"src/mycuc/basic/features/parameter.feature"})
@Test
public class ParameterRunner  extends AbstractTestNGCucumberTests{

	
}


