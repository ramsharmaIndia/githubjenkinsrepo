package otherrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin={"pretty","html:target/myCucReport"}, features={"src/mycuc/basic/features/dataTable.feature"})
public class DataTableRunner  extends AbstractTestNGCucumberTests{

	
}


