package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;
import utils.ScreenshotUtils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import static base.testbase.prop;

public class listener extends ScreenshotUtils implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    public void configureReport(){
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\Test-output\\ExtentReports\\ExtentListenerReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        //Adding System Information.
        reports.setSystemInfo("Machine", System.getProperty("os.arch"));
        reports.setSystemInfo("OS", System.getProperty("os.name"));
        reports.setSystemInfo("OS version", System.getProperty("os.version"));
        reports.setSystemInfo("Application URL", prop.getProperty("browser"));
        reports.setSystemInfo("Email", prop.getProperty("username"));
        reports.setSystemInfo("Password", prop.getProperty("password"));
        reports.setSystemInfo("Java Version", System.getProperty("java.version"));

      //configuration to change look and feel of report
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("Report for...");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @Override

    public void onStart(ITestContext context) {
        configureReport();
        ITestListener.super.onStart(context);
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Class: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testname = result.getName();
        System.out.println("Test case " +testname+ " Passed!" );
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is: " + result.getName(), ExtentColor.GREEN));
        WebDriver driver;
        try{
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            getScreenshotPassed(driver, testname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testname = result.getName();
        System.out.println("Test case " +testname+ " Failed!" );
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
        WebDriver driver;
        try{
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
//        File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String DestinationScreenshot = System.getProperty("user.dir")+"\\Test-output\\ExtentReports\\" + testname + ".png";
        try {
             String DestinationScreenshot = ScreenshotUtils.getScreenshotFailed(driver,testname);
            test.addScreenCaptureFromPath(DestinationScreenshot);
            test.log(Status.INFO,result.getThrowable());
            test.log(Status.FAIL, testname+ "got failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        String testname = result.getName();
        System.out.println("Test Skipped " +testname+ "Skipped!...");
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is: " + result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        reports.flush();
    }
}
