package com.qa.imbdwiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiPage {
	
	private WebDriver driver;
	
	private By releaseDate = By.xpath("//table[@class='infobox vevent']//th/div[text()='Release date']/../following-sibling::td//li");
	private By country = By.xpath("//table[@class=\"infobox vevent\"]//th[text()='Country']/following-sibling::td");
	
	public WikiPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public String getReleaseDateText() {
		return getElement(releaseDate).getText();
	}
	
	
	public String getCountry() {
		return getElement(country).getText();
	}
	
		

}
