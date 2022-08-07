package com.qa.imbdwiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.imbdwiki.utils.ElementUtil;

public class WikiHomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By search = By.xpath("//div[@id='simpleSearch']//input[@id='searchInput']");
	private By searchBtn = By.id("searchButton");
	
	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);	
	}
	
	public void doSearchByMovie(String movieName) {
		eleUtil.doSendKeys(search, movieName);
	}
	
	public WikiInfoPage doClick() {
		eleUtil.doClick(searchBtn);
		return new WikiInfoPage(driver);
	}
	

}
