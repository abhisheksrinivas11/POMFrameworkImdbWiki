package com.qa.imbdwiki.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.imbdwiki.pages.WikiPage;
import com.qa.imbdwiki.utils.Constants;

public class WikiPageTest extends BaseTest {
	
	
	@Test()
	public void releaseDateTest() {
		String relDate = wikipage.getReleaseDateText();
		System.out.println("Releasedate value in wiki is "+relDate);
		Assert.assertEquals(relDate, Constants.WIKI_RELEASE_DATE);
		
		
	}
	
	@Test()
	public void countryTest() {
		String country = wikipage.getCountry();
		System.out.println("Country value in wiki is "+country);
		Assert.assertEquals(country, Constants.WIKI_COUNTRY);
	}
	

}
