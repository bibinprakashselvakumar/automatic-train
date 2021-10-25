package com.mindtree.utilities;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class listeners extends ScreenshotUtils implements ITestListener {
	private static Logger log = LogManager.getLogger(listeners.class);
	public void onTestFailure(ITestResult result) {
		log.info("Entered into failed listener");
		try {
			getScreenShot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Entered into Passed listener");
		try {
			getScreenShot(result.getName());
			logger.log(LogStatus.PASS, "Test Case Passed is "+result.getTestName());
			extent.endTest(logger);
			extent.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
