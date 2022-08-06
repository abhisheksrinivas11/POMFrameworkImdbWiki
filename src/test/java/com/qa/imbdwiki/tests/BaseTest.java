package com.qa.imbdwiki.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.imbdwiki.pages.ImdbHomePage;
import com.qa.imbdwiki.pages.ImdbMovieInfoPage;
import com.qa.imbdwiki.pages.WikiPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	WikiPage wikipage;
	ImdbHomePage homePage;
	ImdbMovieInfoPage movInfoPage;
	
	SoftAssert softAssert;
	
	
	@Parameters({"site","url"})
	@BeforeTest
	public void setUp(String site, String url) {
		if(site.equals("wiki")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			wikipage = new WikiPage(driver);
		}else if(site.equals("imdb")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			homePage = new ImdbHomePage(driver);
			softAssert = new SoftAssert();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}

