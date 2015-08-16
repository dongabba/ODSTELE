package ru.fors.odstele.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */

public class TestBase {

	protected static WebDriver driver;
	// String url = "http://ods.fors.ru/udo-telemetry/index.html?0";
	// String dept_login = "dept_test";
	// String dept_pass = "dept_test";

	String url = "http://ods.mos.ru/udo-telemetry/index.html?0";
	String dept_login = "WST_DEPT";
	String dept_pass = "WST_DEPT1";
	String cust_odh_login = "AD";
	String cust_odh_pass = "fors";

	@BeforeMethod
	public void init() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	protected static WebDriver getWebDriver() {
		return driver;
	}

	public static void quit() {
		driver.quit();
	}

}
