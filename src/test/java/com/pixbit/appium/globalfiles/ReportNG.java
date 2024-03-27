package com.pixbit.appium.globalfiles;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportNG {

	static ExtentReports extent;

	public static ExtentReports reportConfig() {
		// String path = System.getProperty("user.dir")+"\\reports\\index.html";
		String reportsFolderPath = System.getProperty("user.dir") + File.separator + "reports";
		new File(reportsFolderPath).mkdirs();

		String path = reportsFolderPath + File.separator + "index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Prosper User App");
		report.config().setDocumentTitle("Joint property Add");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("QA ENGINEER", "Vishnudas K");
		return extent;
	}
}
