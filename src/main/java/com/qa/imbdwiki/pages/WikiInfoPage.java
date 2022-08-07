package com.qa.imbdwiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.imbdwiki.utils.ElementUtil;

public class WikiInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By releaseDate = By
			.xpath("//table[@class='infobox vevent']//th/div[text()='Release date']/../following-sibling::td//li");
	private By country = By.xpath("//table[@class=\"infobox vevent\"]//th[text()='Country']/following-sibling::td");

	public WikiInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getReleaseDateInfo() {
		return eleUtil.doGetText(releaseDate, 10);
	}

	public String getCountryInfo() {
		return eleUtil.doGetText(country, 10);
	}

}
