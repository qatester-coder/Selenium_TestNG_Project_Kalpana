package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.PizzaBase;
import utilities.ExtentReporter;

public class MyListeners extends PizzaBase implements ITestListener {

	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase started :" + result.getName());
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase passed :" + result.getName());
		extentTest.log(Status.PASS, "Test Passed :" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.fail(result.getThrowable());

		WebDriver driver = null;

		String testName = result.getName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String screenshotPath = takeScreenShot(testName, driver);
			extentTest.addScreenCaptureFromPath(screenshotPath, testName);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Testcase failed :" + result.getName());
		extentTest.log(Status.FAIL, "Test Failed :" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase skipped :" + result.getName());
		extentTest.log(Status.SKIP, "Test Skipped :" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Testcase failed with success is :" + result.getName());
		extentTest.log(Status.PASS, "Testcase failed with success is :" + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Testcase failed with Timeout is :" + result.getName());
		extentTest.log(Status.PASS, "Testcase failed with Timeout is :" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("The name of the testcase started is :" + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Testcase finished :" + context.getName());
		extentReport.flush();

	}

}
