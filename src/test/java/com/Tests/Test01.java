package com.Tests;

import com.Pages.Page01;
import com.ReportFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.ReportFactory.captureScreenshot;

@Tag("LOGIN")
public class Test01 {
	private WebDriver driver;
	private WebDriverWait wait;
	static ExtentSparkReporter info = new ExtentSparkReporter("reports/Login-Test.html");
	static ExtentReports extent;

	@BeforeAll
	public static void run() {
		extent = ReportFactory.getInstance();
		extent.attachReporter(info);
		System.out.println("<<< Register Started >>>");
	}

	@BeforeEach
	public void preConditions() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		Page01 loginPage = new Page01(driver, wait);
		loginPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
	}

	@Test
	@Tag("SUCCESSFUL")
	void testLoginSuccess() throws InterruptedException {
		ExtentTest test = extent.createTest("Login Success");
		test.log(Status.INFO, "Test Started");
		test.log(Status.PASS, "Login Test Joined Successfully");
		Page01 loginPage = new Page01(driver, wait);

		try{
			loginPage.clickMyAcount();
			loginPage.clickRegister();
			loginPage.completeFirstName("Fefo");
			loginPage.completeLastName("Rodriguez");
			loginPage.completeMail("feforodriguez@gmail.com");
			loginPage.completePhone("093846295");
			loginPage.completePass("123456789");
			loginPage.completeRePass("123456789");
			loginPage.clickPrivacyPolicy();
			loginPage.clickContinue();
		} catch (Exception error) {
			test.log(Status.FAIL, "LOGIN TEST FAILED" + error.getMessage());
			captureScreenshot(test, "FAIL_LoginSuccessful", driver);
		}
		test.log(Status.INFO, "TEST FINISHED");
	}
}

