package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	public static ExtentReports getExtentReport() {

		String extentReportPath = System.getProperty("user.dir") + "\\extentreports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("PizzaOrder Automation Results");
		reporter.config().setDocumentTitle("PizzaOrder Automation Test Results");

		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);

		extentReport.setSystemInfo("Operating System", "Windows 11");
		extentReport.setSystemInfo("Executed By", "Kalpana");

		return extentReport;
	}

}
