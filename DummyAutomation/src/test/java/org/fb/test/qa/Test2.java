package org.fb.test.qa;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.fb.base.qa.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class Test2 {
	@Test
	public void test1() throws IOException {

		WebDriver driver;

		ExtentSparkReporter sp = new ExtentSparkReporter(
				"C:\\EclipseWorkspace\\DummyAutomation\\reports\\extentdummy.html");

		sp.config().setTimeStampFormat("DDMMYYYY");

		ExtentReports er = new ExtentReports();
		er.attachReporter(sp);

		ExtentTest test = er.createTest("Test1-----");

		test.info("Test is getting started");

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotName = timestamp + ".jpeg";

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotName);

		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(destFile.getAbsolutePath());

		er.flush();

		driver.close();
	}

	@Test
	public void test2() {

		ExtentSparkReporter sp = new ExtentSparkReporter(
				"C:\\EclipseWorkspace\\DummyAutomation\\reports\\extentdummy2.html");

		ExtentReports er = new ExtentReports();
		er.attachReporter(sp);

		ExtentTest test = er.createTest("Test1-----");

		test.info("Test is getting started");

		BaseTest.initialization();
		BaseTest.getDriver().get("https://www.fb.com");

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotName = timestamp + ".png";

		File srcFile = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotName);

		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(destFile.getAbsolutePath());

		er.flush();

		BaseTest.getDriver().close();

	}

}
