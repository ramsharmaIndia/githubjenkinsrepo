package otherrunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/mycuc/basic/features/tagstest.feature", dryRun=false, 
					plugin={"pretty","html:target/myHtmlReport","json:target/cucumber.json"},
					glue={"mycuc/stepdef2"},tags={"@smoke","~@scenario2"})
@Test
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
}
