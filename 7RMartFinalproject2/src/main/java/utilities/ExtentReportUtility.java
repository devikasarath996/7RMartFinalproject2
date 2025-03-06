package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	//detailed html report generation--extent report utility

	public static final ExtentReports extentReports = new ExtentReports();
	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		//for folder generation
		reporter.config().setReportName("7RMart SuperMarket");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Devika"); 
		return extentReports;
	}
}

