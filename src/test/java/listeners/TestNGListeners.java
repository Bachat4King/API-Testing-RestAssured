package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Author: Bastian Silva
 */
public class TestNGListeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(tests.ReqResTests.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test failed but within success percentage: " + result.getName());
    }

    public void onStart(ITestContext context) {
        logger.info("Test started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("Test finished: " + context.getName());
    }

}

