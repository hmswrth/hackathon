package test.java;

import org.testng.annotations.*;

import browser.BrowserSetup;
import excel.Read;
import home.Home;

public class SmokeTest extends BrowserSetup {
	@Test(priority = 0)
	public void getURL() {
		Home.getUrl();
	}

	@Test(dataProvider = "dp", priority = 1)
	public void search(String s) {
		Home.searchTextBox(s);
	}

	@Test(priority = 2)
	public void getResultTitle() {
		Home.getResultPageTitle();
	}
	
	@Test(priority = 2)
	public void getResultScreenshot() {
		Home.takeScreenshot();
	}

	@Test(priority = 3)
	public void assertSmoke() {
		Home.assertSmoke();
	}

	@BeforeClass
	public void beforeTest() {
		setBrowser();
	}

	@AfterClass
	public void afterTest() {
		closeBrowser();
	}

	@DataProvider
	public Object[][] dp() {
		Object[][] testData = new Object[1][1];
		testData[0][0] = Read.readExcel();
		return testData;
	}

}
