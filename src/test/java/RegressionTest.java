package test.java;

import org.testng.annotations.Test;

import browser.BrowserSetup;
import excel.Read;
import home.Home;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RegressionTest extends BrowserSetup {
	@Test(dataProvider = "dp")
	public void udemyA( String s) {
		Home.getUrl();
		Home.searchTextBox(s);
		Home.levelListBoxExpand();
		Home.levelFilter();
		Home.languageListBoxExpand();
		Home.languageFilter();
		Home.filter();
		Home.listOfCourses();
		Home.takeScreenshot();
		Home.assert1();
	
	}
	
	@DataProvider
	public Object[][] dp() {
		Object[][] testData = new Object[1][1];
		testData[0][0] = Read.readExcel();
		return testData;
	}

	@BeforeTest
	public void beforeTest() {
		setBrowser();
	}

	@AfterTest
	public void afterTest() {
		closeBrowser();
	}

}
