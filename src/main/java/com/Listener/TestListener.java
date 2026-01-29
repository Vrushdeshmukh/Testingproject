package com.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import com.driver.*;
import com.Reports.*;
import com.utility.*;

public class TestListener implements ITestListener {
	
        private WebDriver driver;

		@Override
		public void onStart(ITestContext context) {

			ExtentManager.initReports();
		}

		@Override
		public void onTestStart(ITestResult result) {

			ExtentManager.createTest(result.getMethod().getMethodName());
			ExtentManager.getTest().log(Status.INFO, "✅ " + result.getMethod().getMethodName() + " has been started");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			ExtentManager.getTest().log(Status.PASS, "✅ " + result.getMethod().getMethodName() + "has been Passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			driver = DriverFactory.getDriver();
			String path = SeleniumUtils.takescreenshot(driver, result.getMethod().getMethodName());
			ExtentManager.getTest().log(Status.FAIL, "❌ " + result.getThrowable());
			ExtentManager.getTest().addScreenCaptureFromPath(path);
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			ExtentManager.getTest().log(Status.SKIP, "⚠️ " + result.getMethod().getMethodName() + "has been Skipped");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			ExtentManager.getTest().log(Status.FAIL, "❌ " + result.getThrowable());
		}

		@Override
		public void onFinish(ITestContext context) {
			ExtentManager.flushReports();
		}

	}



