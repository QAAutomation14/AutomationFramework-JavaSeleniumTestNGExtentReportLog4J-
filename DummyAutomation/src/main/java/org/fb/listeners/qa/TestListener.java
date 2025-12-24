package org.fb.listeners.qa;

import org.apache.logging.log4j.Logger;
import org.fb.base.qa.BaseTest;

import org.fb.utils.qa.ExtentManager;
import org.fb.utils.qa.LogUtil;
import org.fb.utils.qa.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	Logger log = LogUtil.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test execution is getting start");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		test.info("Test Execution has been Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Passed");
		extentTest.get().pass("Test has been Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test failed");
		log.debug("Test Debugg");
		String screenshotPath = ScreenshotUtil.captureScreenshot(BaseTest.getDriver(),
				result.getMethod().getMethodName());

		extentTest.get().fail(result.getThrowable());
		extentTest.get().addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.warn("Test Debugg");
		extentTest.get().skip("Test has been Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("Test Finshed");
		extent.flush();
	}
}
