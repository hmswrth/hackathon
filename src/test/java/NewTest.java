package test.java;

import org.testng.annotations.*;

import browser.BrowserSetup;
import excel.Read;
import home.Home;

public class NewTest extends BrowserSetup {
	@Test(priority=0)
	public void getURL() {
		Home.getUrl();
	}

	@Test(dataProvider = "dp", priority=1)
	public void udemyA(String s) {
		Home.searchTextBox(s);
	}

	@Test(priority=2)
	public void levelListBox() {
		Home.levelListBoxExpand();
	}

	@Test(priority=3)
	public void levelFilter() {
		Home.levelFilter();
	}

	@Test(priority=4)
	public void languageListBox() {
		Home.languageListBoxExpand();
	}

	@Test(priority=5)
	public void languageFilter() {
		Home.languageFilter();
	}

	@Test(priority=6)
	public void filterBtn() {
		Home.filter();
	}

	@Test(priority=7)
	public void listOfCourses() {
		Home.listOfCourses();
	}

	@Test(priority=8)
	public void takeScreenshot() {
		Home.takeScreenshot();
	}

	@Test(priority=9)
	public void assert1() {
		Home.assert1();
	}
	// Home.udemyBusiness();

	@Test(priority=10)
	public void udemyB() {
		Home.getUrl2();
	}

	@Test(priority=11)
	public void emailBox() {
		Home.emailBox();
	}

	@Test(priority=12)
	public void getInTouchBtn() {
		Home.getIntouch();
	}

	@Test(priority=13)
	public void getErrorMsg() {
		Home.getErrorMsg();
	}

	@Test(priority=14)
	public void takeScreenShot() {
		Home.takeScreenshot();
	}

	@Test(priority=15)
	public void assert2() {
		Home.assert2();
	}

	@DataProvider
	public Object[][] dp() {
		Object[][] testData = new Object[1][1];
		testData[0][0] = Read.readExcel();
		return testData;
	}

	@BeforeClass
	public void beforeTest() {
		setBrowser();
	}

	@AfterClass
	public void afterTest() {
		closeBrowser();
	}

}
