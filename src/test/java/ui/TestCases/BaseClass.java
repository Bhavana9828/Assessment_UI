package ui.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

//import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ui.ExtendReportListener.ExtentReportListener;


public class BaseClass extends ExtentReportListener{
//	private static ExtentReports extent;
	public static WebDriver driver;

	//("^Initialize the browser with chrome$")
	@Before
	public void beforemethod(cucumber.api.Scenario scenario) throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
				 driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://automationpractice.com/index.php");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				ExtentTest logInfo = null;
				 setUp();
					test1 = extent.createTest(Feature.class, scenario.getName());
					//test1 = test1.createNode(Scenario.class, scenario.getName());
					//test1 = test1.createNode(new GherkinKeyword("Given"), "launch my store application");
				
	}
	@After

	public void embedScreenshot(cucumber.api.Scenario scenario) {

		if (scenario.isFailed()) {

			try {

				// Code to capture and embed images in test reports (if scenario fails)

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		System.out.println("Execution started ...");

		System.out.println("Execution completed...");

		extent.flush();

		System.out.println("Generated Report. . .");

		driver.close();

		driver.quit();

	}

}

