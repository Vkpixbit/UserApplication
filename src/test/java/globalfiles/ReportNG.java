package globalfiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportNG {

	static ExtentReports extent;
	
	public static ExtentReports reportConfig() {
		String path = System.getProperty("D:\\Eclipse_Automation\\UserApp\\report\\index.html");
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Prosper User App");
		report.config().setDocumentTitle("Joint property Add");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("QA ENGINEER", "Vishnudas K");
		return extent;
	}
}
