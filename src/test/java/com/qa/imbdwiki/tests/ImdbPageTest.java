package com.qa.imbdwiki.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ImdbPageTest extends BaseTest {
	


//	@BeforeClass ()
//	public void movieInfoPageSetUp() {
//		homePage.doSearch("pushpa");
//		movInfoPage = homePage.selectMovie("Pushpa: The Rise - Part 1");
//	}
//	
	@DataProvider
	public Object[][] movieName() {
		return new Object[][]{
			{"Pushpa: The Rise - Part 1", "January 7, 2022 (United States)", "India"}
		};
	}
	
	@Test(dataProvider = "movieName")
	public void releaseDateTest(String movieName, String releaseDate, String countryOfOrigin ) {
		homePage.doSearch("pushpa");
		movInfoPage = homePage.selectMovie("Pushpa: The Rise - Part 1");
		String reldate = movInfoPage.getReleaseDateInfo();
		String country = movInfoPage.getCountryOfOriginInfo();
		System.out.println("Release date of "+movieName+" in imdb is "+reldate);
		System.out.println("Country of Origin of "+movieName+" in imdb is "+country);
		softAssert.assertEquals(reldate, releaseDate);
		softAssert.assertEquals(country, countryOfOrigin);
		softAssert.assertAll();
	}
	
//	@Test
//	public void countryTest() {
//		homePage.doSearch("pushpa");
//		movInfoPage = homePage.selectMovie("Pushpa: The Rise - Part 1");
//		String origin = movInfoPage.getCountryOfOriginInfo();
//		System.out.println("Origin date info in imdb is "+origin);
//		Assert.assertEquals(origin, "India");
//		
//	}
}
