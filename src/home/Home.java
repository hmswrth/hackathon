package home;

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
	public static WebElement element;
	public static List<WebElement> courses;
	public static boolean result = false;
	public static Map<Integer, Object[]> dataset;

	public static void searchTextBox(String testData) { // pass testdata from excel to searchTextBox

		WebElement input = Locators.searchtTextBox();
		input.sendKeys(testData, Keys.RETURN);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button")));

	}

	public static void filter() {
		WebElement element = Locators.filter();
		element.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='filter-form--13']/fieldset[3]/div[2]/label/span")));
	}

	public static void filter1() {
		WebElement element = Locators.filter1();
		element.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='filter-form--13']/fieldset[4]/div[1]/label/span")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void filter2() {
		WebElement element = Locators.filter2();
		element.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button[1]")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void submit() {
		WebElement element = Locators.submit();
		element.click();
	}

	public static void listOfCourses() {
		try {
			courses = Locators.listOfCourses();
			List<WebElement> courseTitles = courses.subList(0, 16);
			List<WebElement> authors = courses.subList(16, 32);
			List<WebElement> totalLectures = courses.subList(32, 48);
			List<WebElement> totalHours = courses.subList(48, 64);
			List<WebElement> rating = courses.subList(64, 80);
			List<WebElement> totalRating = courses.subList(80, 96);

			result = true;

			dataset = new TreeMap< Integer, Object[]>();
			dataset.put(1, new Object[] { "Course Title", "Author", "Total Lectures", "Total Hours", "Rating",
					"Total Ratings" });
			for (int i = 0; i < 16; i++) {
				dataset.put(i+2,
						new Object[] { courseTitles.get(i).getText(), authors.get(i).getText().replaceAll("By ", ""),
								totalLectures.get(i).getText(), totalHours.get(i).getText(), rating.get(i).getText(),
								totalRating.get(i).getText() });
			}
		} catch (Exception e) {
			result = false;
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

	public static void takeScreenshot() {
		CaptureScreen.screenshot(); // invoking screenshot method of CaptureScreen class to capture the screenshot

	}

}