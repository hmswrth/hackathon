package test.java;

import org.testng.annotations.Test;

import browser.BrowserSetup;
import excel.Read;
import home.Home;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest extends BrowserSetup {
	@Test(dataProvider = "dp")
	public void f( String s) {
		Home.searchTextBox(s);
		Home.filter();
		Home.filter1();
		Home.filter2();
		Home.submit();
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
//		setBrowser();
		setChromeDriver();
		getUrl();
	}

	@AfterTest
	public void afterTest() {
		closeBrowser();
	}

}
