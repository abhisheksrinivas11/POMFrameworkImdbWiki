package com.qa.imbdwiki.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WikiPageTest extends BaseTest {

	@DataProvider
	public Object[][] movieDetails() {
		return new Object[][] { { "Pushpa: The Rise", "17 December 2021", "India" },
				{ "K.G.F: Chapter 2", "14 April 2022", "India" } };
	}

	@Test(dataProvider = "movieDetails")
	public void movieInfoTest(String movieName, String releaseDate, String countryOfOrigin) {
		softAssert = new SoftAssert();
		wikiHomPage.doSearchByMovie(movieName);
		wikiInfopage = wikiHomPage.doClick();
		String reldate = wikiInfopage.getReleaseDateInfo();
		String country = wikiInfopage.getCountryInfo();
		System.out.println("Release date of " + movieName + " in Wiki is " + reldate);
		System.out.println("Country of Origin of " + movieName + " in Wiki is " + country);
		softAssert.assertEquals(reldate, releaseDate, "Release Date of " + movieName + "not matched");
		softAssert.assertEquals(country, countryOfOrigin, "Country of" + movieName + " not matched");
		softAssert.assertAll();
	}

}
