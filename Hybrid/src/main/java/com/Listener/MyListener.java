package com.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.BaseClass;
import com.Utils.DriverUtils;
import com.aventstack.extentreports.Status;

public class MyListener extends BaseClass implements ITestListener {
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TestCase Pass");
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "TestCase Fail");
		 try {
				String path=DriverUtils.getScreenShort(result.getName());
				test.addScreenCaptureFromPath(path);
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "TestCase Skip");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
		ReportInit();
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
