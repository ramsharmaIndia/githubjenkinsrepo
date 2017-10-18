package stepdef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions{

	
	public WebDriver driver = null;
	String enteredPost = null;
	
	@Before()
	public void openBrowser(Scenario scenario){

		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\jars\\chromedriver_win32_2.32\\chromedriver.exe");
		ChromeOptions cOptions = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_setting_values.notifications", 2);
		chromePrefs.put("credentials_enable_service", false);
		cOptions.setExperimentalOption("prefs", chromePrefs);
		cOptions.addArguments("disable-infobars");
		driver = new ChromeDriver(cOptions);
		
		driver.manage().window().maximize();
		System.out.println("Before method of "+scenario.getName()+" is executed");
		
	}
	
	@After()
	public void closeBrowser(Scenario scenario){
		driver.close();
	}
	
	@Given("^open facebook$")
	public void open_facebook() throws Throwable {
		driver.get("https://www.facebook.com/");
	}
	
	@Given("^open \"([^\"]*)\"$")
	public void open(String url) throws Throwable {
		driver.get(url);
	}

	@Given("^login to facebook with correct credentials$")
	public void login_to_facebook_with_correct_credentials() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("bikash.gate2015@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Gate@2015");
		driver.findElement(By.id("loginbutton")).click();
		
	}

	@Then("^check that you have successfully logged in$")
	public void check_that_you_have_successfully_logged_in() throws Throwable {
		if(driver.findElements(By.xpath("//span[text()='Create a Post']")).size()==0)
			Assert.fail();
	}

	@Given("^login to facebook with incorrect credentials$")
	public void login_to_facebook_with_incorrect_credentials() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("bikash.gate2015@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Gate@sdaf");
		driver.findElement(By.id("loginbutton")).click();
	}

	@Then("^check that you were not able to log in$")
	public void check_that_you_were_not_able_to_log_in() throws Throwable {
		if(driver.findElements(By.xpath("//span[text()='Create a Post']")).size()>0)
			Assert.fail();
	}

	@When("^user post something$")
	public void user_post_something() throws Throwable {
		enteredPost = "Hello Automation World";
		driver.findElement(By.xpath("//span[text()='Create a Post']")).click();
		driver.findElement(By.xpath("//div[contains(@data-testid,'mentions-input')]")).sendKeys(enteredPost);
		driver.findElement(By.xpath("//*[contains(@data-testid,'post-button')]")).click();
		
		Thread.sleep(10000);
		
	}

	@Then("^Post should be present in the timeline$")
	public void post_should_be_present_in_the_timeline() throws Throwable {
		
		String postValue = driver.findElement(By.xpath("//div[starts-with(@id,'feed_stream')]/div[@role='article'][1]//p")).getText();
		Assert.assertEquals("Enteredvalue and post value are not equal", enteredPost, postValue);
		
	}
	
	@Then("^log out of facebook$")
	public void log_out_of_facebook() throws Throwable {
		
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	}
	
	@When("^open profile$")
	public void open_profile() throws Throwable {
		driver.findElement(By.xpath("//*[contains(@data-gt,'self_timeline')]")).click();
	}

	@Then("^profile should be opened$")
	public void profile_should_be_opened() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue("Profile page has not been opened", driver.findElements(By.xpath("//span[text()='Intro']")).size()>0);
	}
	
	@Then("^get some value from dataTable$")
	public void get_some_value_from_dataTable(DataTable arg1) throws Throwable {
		List<List<String>> tableData = arg1.raw();
		//arg1.
		
		for(List<String> rowData:tableData){
			for(String cell: rowData){
				System.out.print(cell+"\t");
			}
			System.out.println();
		}
	}
	
	@Given("^I want to write a step with \"([^\"]*)\"$")
	public void i_want_to_write_a_step_with(String ab) throws Throwable {
		System.out.println("First step with value "+ab);
	}
	
	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_in_step(int arg1) throws Throwable {
		System.out.println("Second step with value "+arg1);
	}
	
	@Then("^I verify the \"([^\"]*)\" in step$")
	public void i_verify_the_Success_in_step(String ab) throws Throwable {
		System.out.println("Third step with value "+ab);
	}
	
}
