package utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class Listeners extends CommonOps implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("------------------------------------------------------- Staring Automation Tests -------------------------------------------------------");
        System.out.println(getData("AsciiPrint"));
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("------------------------------------------------------- Ending Automation Tests -------------------------------------------------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(arg0);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("----------- Test: " + result.getName() + " Failed -----------");
        saveScreenshot();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public void saveScreenshot(){
        Allure.addAttachment("PageSS", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
