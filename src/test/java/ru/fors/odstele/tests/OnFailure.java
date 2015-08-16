package ru.fors.odstele.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */

public class OnFailure extends TestListenerAdapter {

	@Step
	@Override
	public void onTestFailure(ITestResult tr) {
		takeAttach();
		TestBase.quit();
	}

	@Attachment("ScreenShot")
	public byte[] takeAttach() {
		return ((TakesScreenshot) TestBase.getWebDriver()).getScreenshotAs(OutputType.BYTES);
	}
}