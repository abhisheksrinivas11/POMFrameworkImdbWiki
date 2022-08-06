package com.qa.imbdwiki.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator, String Value) {
		WebElement ele = getElement(locator);
		ele.sendKeys(Value);
	}
	
	public String doGetText(By locator,int timeout) {
		return waitForElementVisible(locator, timeout).getText();
	}
	
	public List<WebElement> waitForElementsVisible(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
