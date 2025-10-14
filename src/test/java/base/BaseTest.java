package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {
        //Reporting
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();

    }

        @AfterMethod
        public void tearDown (ITestResult result) {

            if (result.getStatus() == ITestResult.FAILURE){
                test.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Pass");
            }else {
                test.skip("Test Skipped");
            }

            extent.flush();

            if (browser != null) browser.close();
            if (playwright != null) playwright.close();



        }
    }


