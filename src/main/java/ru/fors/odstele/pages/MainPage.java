package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru
 *         Date: 16.08.15
 */
public class MainPage {
	
	By userRole = By.xpath("//*[@id='logo']//div[2]"); //роль пользователя
	By reportPageLink = By.linkText("Отчеты"); //ссылка для перехода в отчеты
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("Пользователь проверяет свою роль")
	public String getUserRole() {
		return driver.findElement(userRole).getText();
	}
	@Step("Пользователь переходит на вкладку отчеты")
	public ReportsPage userGotoReportsPage(){
		driver.findElement(reportPageLink).click();
		return new ReportsPage(driver);
	}

}
