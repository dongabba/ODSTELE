package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru
 *         Date: 16.08.15
 */
public class LoginPage {
	
	By loginField = By.id("j_username"); //поле для ввода логина
	By passwordField = By.id("j_password"); //поле для ввода пароля
	By loginButton = By.linkText("Войти"); //кнопка Войти
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	private void userSetLogin(String login){
		driver.findElement(loginField).click();
		driver.findElement(loginField).clear();
		driver.findElement(loginField).sendKeys(login);
	}
	
	private void userSetPassword(String pass){
		driver.findElement(passwordField).click();
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(pass);
	}
	
	private void userClickLoginButton(){
		driver.findElement(loginButton).click();
	}
	@Step("Пользователь входит в систему как {0}")
	public MainPage userLogin(String login, String pass){
		userSetLogin(login);
		userSetPassword(pass);
		userClickLoginButton();
		return new MainPage(driver);
	}

}
