package com.Tests;

import com.Pages.Page02;
import com.ReportFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ReportFactory.captureScreenshot;

public class Test02 {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reports/Search-and-Add-to-Cart-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void run() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< Search and Add to Cart Started >>>");
    }

    @Test
    @Tag("SEARCH_AND_ADD_TO_CART")
    @Tag("SUCCESSFUL")
    public void testSearchSuccess() throws InterruptedException {
        ExtentTest test = extent.createTest("Search Success");
        test.log(Status.INFO, "Test Started");
        test.log(Status.PASS, "Test Joined Successfully");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        Page02 searchPage = new Page02(driver, wait);

        try {
            searchPage.setUp();
            searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
            searchPage.search("Iphone");
            searchPage.clickSearch();
            searchPage.addCart();
            searchPage.close();
        } catch (Exception error) {
            test.log(Status.FAIL, "TEST FAILED" + error.getMessage());
            captureScreenshot(test, "FAIL_SearchSuccessful", driver);
        }
        test.log(Status.INFO, "TEST FINISHED");
    }
}