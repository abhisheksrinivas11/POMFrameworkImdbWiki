package com.qa.imbdwiki.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.imbdwiki.utils.ElementUtil;

public class ImdbHomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By search = By.id("suggestion-search");
	private By searchSuggList = By.xpath(
			"//ul[contains(@class,'react-autosuggest__suggestions-list')]//li//a[@data-testid='search-result--const']//div[@class='sc-d2740ffb-1 duOqOv']//div[contains(@class,'searchResult__constTitle')]");

	public ImdbHomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public void doSearchByMovie(String movieName) {
		eleUtil.doSendKeys(search, movieName);
	}

	public ImdbMovieInfoPage selectMovie(String movieName) {
		List<WebElement> movieList = eleUtil.waitForElementsVisible(10, searchSuggList);
		for (WebElement e : movieList) {
			String text = e.getText();
			if (text.contains(movieName)) {
				e.click();
				break;
			}
		}
		return new ImdbMovieInfoPage(driver);

	}
}
