package cucumber.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/Features",
                      glue = "ui/TestCases",

			monochrome = false, 
			tags = { "@test5" }, 
			dryRun = false)
	public class TestRunner extends AbstractTestNGCucumberTests {
		private TestNGCucumberRunner testNGCucumberRunner;

		@BeforeClass(alwaysRun = true)
		public void setUpClass() throws Exception {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}

		@Test(groups = "cucumber", description = "Runs Cucucmber Feature", dataProvider = "features")
		public void feature(CucumberFeatureWrapper cucumberFeature) {
			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		}

		@DataProvider // (parallel=true)
		public Object[][] features() {
			return testNGCucumberRunner.provideFeatures();

		}

		@AfterClass(alwaysRun = true)
		public void tearDownClass() throws Exception {
			testNGCucumberRunner.finish();

		}

	}

