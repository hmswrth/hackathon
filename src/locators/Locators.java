package locators;

import java.util.*;

import org.openqa.selenium.*;

import browser.BrowserSetup;

public class Locators extends BrowserSetup {
	public static WebElement element;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static WebElement searchtTextBox() { // returns search box webElement
		element = driver.findElement(By.xpath("//*[@id='header-search-field']"));
		return element;
	}

	public static WebElement filter() {
		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		return element;
	}

	public static WebElement filter1() {
		element = driver.findElement(By.xpath("//*[@id='filter-form--13']/fieldset[3]/div[2]/label/span"));
		return element;
	}

	public static WebElement filter2() {
		element = driver.findElement(By.xpath("//*[@id='filter-form--13']/fieldset[4]/div[1]/label/span"));
		return element;
	}

	public static WebElement submit() {
		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button[1]"));
		return element;
	}

	public static List<WebElement> listOfCourses() {
		List <WebElement> listOfCourses = new ArrayList<WebElement>();
		List <WebElement> courseNames = driver.findElements(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[2]/div/div/a/div/div[2]/div[1]/h4")); //course names
		List <WebElement> authorNames = driver.findElements(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[2]/div/div/a/div/div[2]/div[4]/div/span[2]")); //authors
		List <WebElement> lecturesCount = driver.findElements(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[2]/div/div/a/div/div[2]/div[2]/div/span[1]")); //lectures
		List <WebElement> duration = driver.findElements(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[2]/div/div/a/div/div[2]/div[2]/div/span[2]")); //total hours
		List <WebElement> rating = driver.findElements(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[2]/div/div/a/div/div[2]/div[5]/div[2]/div/span[1]")); //rating
		List <WebElement> totalRating = driver.findElements(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[2]/div/div/a/div/div[2]/div[5]/div[2]/div/span[2]")); //total ratings
		listOfCourses.addAll(courseNames);
		listOfCourses.addAll(authorNames);
		listOfCourses.addAll(lecturesCount);
		listOfCourses.addAll(duration);
		listOfCourses.addAll(rating);
		listOfCourses.addAll(totalRating);
		return listOfCourses;
		
	}

}