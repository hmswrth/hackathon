package locators;

import java.util.*;

import org.openqa.selenium.*;

import browser.BrowserSetup;

public class Locators extends BrowserSetup {
	public static WebElement element;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static WebElement searchTextBox() { // returns search box webElement
		element = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
		return element;
	}

	public static WebElement filter() {
//		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button"));
		element = driver.findElement(By.xpath("//label[@for='filter-button' and @data-purpose='open-filters']"));	
//		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[4]/div/div/div[5]/div[1]/div[1]/div[1]/button"));			
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		return element;
	}
	public static WebElement levelListBox() {
		element = driver.findElement(By.xpath("//*[@id='filter-form']/div/div[5]/label"));
		return element;
	}
	public static WebElement beginnerLevelFilter() {
		element = driver.findElement(By.xpath("//*[@id='filter-form']/div/div[5]/div/div/div/div/div/fieldset/label[2]"));
		return element;
	}
	
	public static WebElement langListBox() {
		element = driver.findElement(By.xpath("//*[@id='filter-form']/div/div[6]/label"));
		return element;
	}
	public static WebElement englishLangFilter() {
		element = driver.findElement(By.xpath("//*[@id='filter-form']/div/div[6]/div/div/div/div/div/fieldset/label[1]"));
		return element;
	}
	

//	public static WebElement filter1() {
//		element = driver.findElement(By.xpath("//*[@id='filter-form--13']/fieldset[3]/div[2]/label/span"));
//		return element;
//	}
//
//	public static WebElement filter2() {
//		element = driver.findElement(By.xpath("//*[@id='filter-form--13']/fieldset[4]/div[1]/label/span"));
//		return element;
//	}
//
//	public static WebElement submit() {
//		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button[1]"));
//		return element;
//	}

	public static List<WebElement> listOfCourses() {
		List <WebElement> listOfCourses = new ArrayList<WebElement>();
		List <WebElement> courseNames = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[1]")); //course names
//		System.out.println(courseNames.size());
		List <WebElement> authorNames = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[2]")); //authors
//		System.out.println(authorNames.size());
		List <WebElement> lecturesCount = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[4]/span[2]")); //lectures
//		System.out.println(lecturesCount.size());
		List <WebElement> duration = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[4]/span[1]")); //total hours
//		System.out.println(duration.size());
		List <WebElement> rating = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[3]/span[1]/span[2]")); //rating
//		System.out.println(rating.size());
		List <WebElement> totalRating = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[3]/span[3]")); //total ratings
//		System.out.println(totalRating.size());
		listOfCourses.addAll(courseNames);
		listOfCourses.addAll(authorNames);
		listOfCourses.addAll(lecturesCount);
		listOfCourses.addAll(duration);
		listOfCourses.addAll(rating);
		listOfCourses.addAll(totalRating);
//		System.out.println(listOfCourses.size());
		return listOfCourses;
		
	}
	
	public static WebElement udemyBusiness() {
		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[3]/div[9]/div/div/div/div/div/div[2]/a"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		return element;
	}
	
	public static WebElement emailTextbox() {
		element = driver.findElement(By.xpath("//*[@id='Email']"));
		return element;
	}
	public static WebElement errorMsg() {
		element = driver.findElement(By.xpath("//*[@id=\"mktoForm_1356\"]/div[2]/div[1]/div[2]/div[2]/div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		return element;
	}
	
	public static WebElement getInTouch() {
		element =  driver.findElement(By.xpath("//*[@id=\"mktoForm_1356\"]/div[17]/span/button"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		return element;
	}

	public static WebElement getResultPageTitle() {
		element = driver.findElement(By.xpath("//*[@id='udemy']/div[2]/div[4]/div/div/div[2]/div/h1"));
		return element;
	}

}