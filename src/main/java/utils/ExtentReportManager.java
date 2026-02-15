package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;

    public static ExtentReports createInstance() {
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("SauceDemo Automation Report");
        reporter.config().setDocumentTitle("Test Execution Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }

}
