package com.qa.imbdwiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.imbdwiki.utils.ElementUtil;

public class ImdbMovieInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By releaseDate = By.xpath(
			"//div[@data-testid='title-details-section']//ul//li[@data-testid='title-details-releasedate']//div[contains(@class,'content-container')]//li//a[contains(@class,'content-item')]");
	private By countryOfOrigin = By.xpath(
			"//div[@data-testid='title-details-section']//ul//li[@data-testid='title-details-origin']//div[contains(@class,'content-container')]//li//a[contains(@class,'content-item')]");

	public ImdbMovieInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getReleaseDateInfo() {
		return eleUtil.doGetText(releaseDate, 10);
	}

	public String getCountryOfOriginInfo() {
		return eleUtil.doGetText(countryOfOrigin, 10);
	}

}
