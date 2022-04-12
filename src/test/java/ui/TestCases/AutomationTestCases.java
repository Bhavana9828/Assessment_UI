package ui.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.MediaType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ui.ExtendReportListener.ExtentReportListener;
import ui.pageObjects.AutomationPageObjects;
import ui.pageObjects.pageobjects;

public class AutomationTestCases {
	WebDriver driver = BaseClass.driver;
	public AutomationPageObjects pageobj;
	public static ExtentTest test1 = ExtentReportListener.test1;

	@When("^Click on search button and enter three characters$")
	public void click_on_search_button_and_enter_three_characters() throws Throwable {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement search = driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']"));
		js.executeScript("arguments[0].click()", search);
		search.clear();
		search.sendKeys("dre");
		Thread.sleep(5000);
		test1.log(Status.PASS, "Entered 3 characters on search", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());
		// test1.pass("PASS",
		// MediaEntityBuilder.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

		System.out.println("Entered 3 characters on search");

	}

	@When("^Validate whether the search suggestion is given after entering three characters$")
	public void validate_whether_the_search_suggestion_after_entering_three_characters() throws Throwable {
		WebElement search = driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", search);
		search.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		search.sendKeys(Keys.ENTER);
		System.out.println("search suggestion is given after entering three characters and user is able to click");
		test1.log(Status.PASS, "search suggestion is given after entering three characters and user is able to click", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^User gives only two or one characters on search suggestion$")
	public void user_gives_only_two_or_one_characters_on_search_suggestion() throws Throwable {
		WebElement search = driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']"));
     	driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']")).sendKeys("dr");
		System.out.println("Entered 2 characters on search");
		search.sendKeys(Keys.ARROW_DOWN);
		test1.log(Status.PASS, "User gives only two or one characters on search suggestion", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Validate no search suggestion is given after entering two characters$")
	public void validate_no_search_suggestion_is_given_after_entering_two_characters() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
    	pageobj.clickSubmitbutton();
    	String ActualTitle = pageobj.Searchcharvalidate();
		System.out.println(ActualTitle);
		Assert.assertTrue(ActualTitle.contains("No results were found for your search"));
		System.out.println("No results were found for your search after entering two characters");
		test1.log(Status.PASS, "No results were found for your search after entering two characters", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Click on search button and enter \"([^\"]*)\" dress name$")
	public void click_on_search_button_and_enter_dress_name(String arg1) throws Throwable {
		pageobj = new AutomationPageObjects(driver);
    	pageobj.clicksearchbutton();
		pageobj.enterdressname(arg1);
		pageobj.clickSubmitbutton();
		test1.log(Status.PASS, "Clicked on search button and enter dress name", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Validate results are displayed according to the search made by the user\\.$")
	public void validate_results_are_displayed_according_to_the_search_made_by_the_user() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
		String ActualTitle = pageobj.Searchdressvalidate();
		System.out.println(ActualTitle);
		Assert.assertTrue(ActualTitle.contains("PRINTED SUMMER DRESS"));
		System.out.println("results are displayed according to the search made by the user");
		test1.log(Status.PASS, "Validated results are displayed according to the search made by the user", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Click on T-shirt section on the page$")
	public void click_on_T_shirt_section_on_the_page() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
		pageobj.clicktshirtsection();
		test1.log(Status.PASS, "Clicked on T-shirt section on the page", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Validate whether the user is able to apply the large size on the page$")
	public void validate_whether_the_user_is_able_to_apply_the_large_size_on_the_page() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
		pageobj.clicklbutton();
		System.out.println("user is able to apply the large size on the page");
		test1.log(Status.PASS, "user is able to apply the large size on the page", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Click on contact us button on the page$")
	public void click_on_contact_us_button_on_the_page() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
		pageobj.clickContactusButton();
		System.out.println("user Clicked on contact us button on the page");
		test1.log(Status.PASS, "user Clicked on contact us button on the page", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Validate whether the user is able to upload a file on the contact us page$")
	public void validate_whether_the_user_is_able_to_upload_a_file_on_the_contact_us_page() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
		pageobj.clickChoosefilebutton();
		Thread.sleep(5000);
		System.out.println("user is able to upload a file on the contact us page");
		test1.log(Status.PASS, "user is able to upload a file on the contact us page", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	@When("^Add five products in the cart on the page$")
	public void add_five_products_in_the_cart_on_the_page() throws Throwable {
		pageobj = new AutomationPageObjects(driver);
		pageobj.clickaddtocart();
		pageobj.clickcartbutton();
		Thread.sleep(2000);
		System.out.println("Added five products in the cart on the page");
		test1.log(Status.PASS, "Added five products in the cart on the page", MediaEntityBuilder
				.createScreenCaptureFromBase64String(ExtentReportListener.captureScreenShot(driver)).build());

	}

	
	@When("^validate total cart amount and individual product price both with and without discount$")
	public void validate_total_cart_amount_and_individual_product_price_both_with_and_without_discount()
 {
		pageobj = new AutomationPageObjects(driver);
		pageobj.clickcartbutton();
		System.out.println("TOTAL PRICE:" +pageobj.gettotalprice());
		
		//list of products without discount
		System.out.println("list of products without discount");
		List<WebElement> list= driver.findElements(By.xpath("//tr/td[4]/span/span[@class='price']"));
		int count= driver.findElements(By.xpath("//tr/td[4]/span/span[@class='price']")).size();
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.xpath("//tr/td[4]/span/span")).get(i).getText();
			text.replaceAll("$", "");
			
		System.out.println( "price for "+i+"product is:" +text);
		
		}
		//list of products with discount
		System.out.println("list of products with discount");
		List<WebElement> listwithdiscount= driver.findElements(By.xpath("//tr/td[4]/span/span[@class='price special-price']"));
		int discount= driver.findElements(By.xpath("//tr/td[4]/span/span[@class='price special-price']")).size();
		System.out.println(discount);
		for(int i=0;i<count-1;i++)
		{
			String text=driver.findElements(By.xpath("//tr/td[4]/span/span[@class='price special-price']")).get(i).getText();
			
		System.out.println( "price for dicount "+i+"product is:" +text);
		
		}
		
		
	}
	
	
}
