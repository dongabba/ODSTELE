package ru.fors.odstele.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru
 *         Date: 16.08.15
 */

public class CheckElementsTools {

	public static void waitForElementValuePresent(final By locator, int timeout, WebDriver driver, final String value) throws Exception {
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		new WebDriverWait(driver, timeout){
			}.until(new ExpectedCondition<Boolean>(){
				@Override
				public Boolean apply(WebDriver d) {
					return d.findElement(locator).getText().equals(value);
				}
			});
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}catch (Exception e){
		e.printStackTrace();
		}
	}
	
	public static Object waitForAjaxIndicatorOff (WebDriver driver, int timeout){
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			new WebDriverWait(driver, timeout){
			}.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax-indicator")));
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			
		}catch (Exception e){
		e.printStackTrace();
		}
		return null;	
	}
	public static Object waitForElementVisible (WebDriver driver, By locator, int timeout){
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			new WebDriverWait(driver, timeout){
			}.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			
		}catch (Exception e){
		e.printStackTrace();
		}
		return null;	
	}
	public static Object waitForElementInVisible (WebDriver driver, By locator, int timeout){
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			new WebDriverWait(driver, timeout){
			}.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			
		}catch (Exception e){
		e.printStackTrace();
		}
		return null;	
	}
	
	public static Boolean isElementPresent(WebDriver driver, By element) {
		try{
			//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driver.findElement(element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
	
	public static Object waitForElementPresent (WebDriver driver, By locator, int timeout){
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			new WebDriverWait(driver, timeout){
			}.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			
		}catch (Exception e){
		e.printStackTrace();
		}
		return null;	
	}
	public static boolean isElementVisible(WebDriver driver, By element) {
				boolean value = false;
		        if (driver.findElement(element).isDisplayed()) {
		            value = true;
		        }
		        return value;
		    }
	
	public static Object waitForMapLoadingIndicatorOff (WebDriver driver, int timeout){
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			new WebDriverWait(driver, timeout){
			}.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".map-loading")));
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			
		}catch (Exception e){
		e.printStackTrace();
		}
		return null;	
	}
	public static boolean isAlertPresentInMapPage (WebDriver driver, int timeout){
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			new WebDriverWait(driver, timeout){
			}.until(ExpectedConditions.alertIsPresent());
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
			return true;
		}catch (NoAlertPresentException e){
			return false;	
		}
		
	}
	
}

