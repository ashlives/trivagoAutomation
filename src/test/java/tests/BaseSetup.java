package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjectModels.ContactPageObjectModel;
import pageObjectModels.CookiesNoticePageObjectModel;
import pageObjectModels.FooterPageObjectModel;
import pageObjectModels.PollPopUpObjectModel;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class BaseSetup {
    WebDriver driver;
    FooterPageObjectModel objFooter;
    ContactPageObjectModel objContact;
    CookiesNoticePageObjectModel objCookies;
    PollPopUpObjectModel objPoll;

    ExtentReports extent;
    ExtentTest logger;
    ExtentHtmlReporter htmlReporter;
    String htmlReportPath = System.getProperty("user.dir")+"/test-output/MyOwnReport.html"; //Path for the HTML report to be saved

  @BeforeClass //Initialize ExtentReports
    public void report(){
        htmlReporter = new ExtentHtmlReporter(htmlReportPath);
        extent = new ExtentReports();
        htmlReporter.setAppendExisting(true);
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Trivago - Automation QA Task");
    }

    @BeforeTest
    public void setUp(){
        htmlReporter = new ExtentHtmlReporter(htmlReportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        System.setProperty("webdriver.chrome.driver", "WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://room5.trivago.com/");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            logger.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
        }

    }

    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.close();
    }

}
