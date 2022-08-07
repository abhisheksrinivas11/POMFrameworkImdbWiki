package com.qa.imbdwiki.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ImdbPageTest extends BaseTest {

	@DataProvider
	public Object[][] movieDetails() {
		return new Object[][] { { "Pushpa: The Rise", "January 7, 2022 (United States)", "India" },
				{ "K.G.F: Chapter 2", "April 13, 2022 (United States)", "India" } };
	}

	@Test(dataProvider = "movieDetails")
	public void movieInfoTest(String movieName, String releaseDate, String countryOfOrigin) {
		softAssert = new SoftAssert();
		homePage.doSearchByMovie(movieName);
		movInfoPage = homePage.selectMovie(movieName);
		String reldate = movInfoPage.getReleaseDateInfo();
		String country = movInfoPage.getCountryOfOriginInfo();
		System.out.println("Release date of " + movieName + " in imdb is " + reldate);
		System.out.println("Country of Origin of " + movieName + " in imdb is " + country);
		softAssert.assertEquals(reldate, releaseDate, "Release Date of " + movieName + "not matched");
		softAssert.assertEquals(country, countryOfOrigin, "Country of" + movieName + " matched");
		softAssert.assertAll();
	}

}
