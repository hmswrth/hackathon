package home;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import browser.BrowserSetup;
import excel.*;
import locators.Locators;
import screenshot.CaptureScreen;

public class Home extends BrowserSetup {
	public static String errorMsg;
	public static String parentWindowHandle;
	public static Set<String> allWindowHandles;
	public static WebElement element;
	public static List<WebElement> courses;
	public static boolean result = true;
	public static Map<Integer, Object[]> dataset;

	public static void searchTextBox(String testData) { // pass testdata from excel to searchTextBox

		WebElement input = Locators.searchtTextBox();
		input.sendKeys(testData, Keys.RETURN);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='filter-button' and @data-purpose='open-filters']")));
	}

	public static void filter() {
		WebElement element = Locators.filter();
		element.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void levelListBoxExpand() {
		WebElement element = Locators.levelListBox();
		element.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='filter-form--13']/fieldset[4]/div[1]/label/span")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void levelFilter() {
		element = Locators.beginnerLevelFilter();
		element.click();
		try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}

	public static void languageListBoxExpand() {
		WebElement element = Locators.langListBox();
		element.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button[1]")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void languageFilter() {
		element = Locators.englishLangFilter();
		element.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void listOfCourses() {
		try {
			courses = Locators.listOfCourses();
			List<WebElement> courseTitles = courses.subList(0, 12);
			List<WebElement> authors = courses.subList(12, 24);
			List<WebElement> totalLectures = courses.subList(24, 36);
			List<WebElement> totalHours = courses.subList(36, 48);
			List<WebElement> rating = courses.subList(48, 60);
			List<WebElement> totalRating = courses.subList(60, 72);

			result = true;

			dataset = new TreeMap< Integer, Object[]>();
			dataset.put(1, new Object[] { "Course Title", "Author", "Total Lectures", "Total Hours", "Rating",
					"Total Ratings" });
			for (int i = 0; i < 12; i++) {
				dataset.put(i+2,
						new Object[] { courseTitles.get(i).getText(), authors.get(i).getText().replaceAll("By ", ""),
								totalLectures.get(i).getText(), totalHours.get(i).getText(), rating.get(i).getText(),
								totalRating.get(i).getText() });
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			
		}
	}
	
	public static void goBackHome() {
		driver.navigate().back();
	}
	
	public static void udemyBusiness() {
		setParentWindowHandle();
		element = Locators.udemyBusiness();
		element.click();
		changeToNewWindow();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void emailBox() {
		element = Locators.emailTextbox();
		element.sendKeys("breakers");
	}
	
	public static void getIntouch() {
		element = Locators.getInTouch();
		element.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void getErrorMsg() {
		element = Locators.errorMsg();
		errorMsg = element.getText();
//		System.out.println(errorMsg);
	}
	
	public static void getWindowHandles() {
		allWindowHandles = driver.getWindowHandles();
	}
	
	public static void setParentWindowHandle() {
		parentWindowHandle = driver.getWindowHandle();
	}
	
	public static void changeToNewWindow() { // focuses the driver on new window
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	
	
	public static void assert1() {
		try {
			Assert.assertTrue(result ? true : false);
			System.out.println("Pass");
			Write.writeExcel(dataset);
			Reporter.log("Execution Successful!");
		} catch (AssertionError e) {
			System.out.println("Assertion Failed");
			Reporter.log("Exection unsuccessful!");
		}
	}
	
	public static void assert2() {
		try {
			Assert.assertEquals(errorMsg, "Must be valid company email.\n" + 
					"example@yourdomain.com");
			System.out.println("Pass");
			Reporter.log("Exection Successful1");
		}catch(AssertionError e) {
			System.out.println("error assertion failed");
			Reporter.log("Exection unsuccessful!");
		}
	}

	public static void takeScreenshot() {
		CaptureScreen.screenshot(); // invoking screenshot method of CaptureScreen class to capture the screenshot

	}

}