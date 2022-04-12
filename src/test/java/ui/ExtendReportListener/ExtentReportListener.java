package ui.ExtendReportListener;

import java.io.File;

import java.io.IOException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.markuputils.ExtentColor;

import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener {

	public static ExtentHtmlReporter report = null;

	public static ExtentReports extent = new ExtentReports();

	public static ExtentTest test1 = null;

	public static ExtentReports setUp() {

		String reportLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\Textcase5Validation.html";

		//String reportLocation =  "C:\\Users\\Thumma Bhavana\\sample.html";

		report = new ExtentHtmlReporter(reportLocation);

		report.config().setDocumentTitle("Automation Test Report");

		report.config().setReportName("Test Report");

		report.config().setTheme(Theme.STANDARD);

		report.config().setEncoding("utf-8");

		System.out.println("Extent Report location initialized . . .");

		report.start();

		extent.attachReporter(report);

		extent.setSystemInfo("Application", "MYStore");

		System.out.println("System Info. set in Extent Report");

		return extent;

	}

	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {

		switch (teststatus) {

		case "FAIL":

			extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));

			extenttest.error(throwable.fillInStackTrace());

			try {

				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));

			} catch (IOException e) {

				e.printStackTrace();

			}

			if (driver != null) {

				driver.quit();

			}

			break;

		default:

			break;

		}

	}

	public static void testStepHandle1(String teststatus, WebDriver driver, ExtentTest extenttest) {

		switch (teststatus) {

		case "PASS":

			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));

			try {

				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));

			} catch (IOException e) {

				e.printStackTrace();

			}

			break;

		default:

			break;

		}

	}

	public static String captureScreenShot(WebDriver driver) throws IOException {

		TakesScreenshot screen = (TakesScreenshot) driver;

		String src = screen.getScreenshotAs(OutputType.BASE64);

		
		/*
		 * String dest = System.getProperty("user.dir") +
		 * "\\src\\test\\resources\\reports" + getcurrentdateandtime() + ".png";
		 * 
		 * File target = new File(dest);
		 * 
		 * FileUtils.copyFile(src, target);
		 */

		return src;

	}

	private static String getcurrentdateandtime() {

		String str = null;

		try {

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");

			Date date = new Date();

			str = dateFormat.format(date);

			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");

		} catch (Exception e) {

		}

		return str;

	}

}
