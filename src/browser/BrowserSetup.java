package browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserSetup {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static WebDriver setBrowser() {
//		Scanner scan = new Scanner(System.in); // to take input from user
//		System.out.println( // Displaying message to Choose any one of the Browsers
//				"Which browser would you like to execute the script on?\r\n" + "1. Google Chrome\r\n"
//						+ "2. Mozilla Firefox\r\n" + "3. Internet Explorer\r\n");
//
//		int browserChoice = scan.nextInt();
//		scan.close();
//
//		if (browserChoice == 1) {
//			driver = setChromeDriver();
//		} else if (browserChoice == 2) {
//			driver = setFirefoxDriver();
//		} else if (browserChoice == 3) {
//			driver = setInternetExplorerDriver();
//		} else {
//			System.out.println("Invalid Input");
//		}
		String filePath = System.getProperty("user.dir") + "/Application.properties";
		Properties prop = null;
		try {
			prop = new Properties(); // Used to Instantiate properties
			FileInputStream file = new FileInputStream(filePath); // providing the path of properties file
			prop.load(file);
		} catch (IOException e) {
			System.out.println("Error while reading the file at" + filePath);
			e.printStackTrace();
		}
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = setChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = setFirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("internet explorer")) {
			driver = setInternetExplorerDriver();
		}
		else {
			System.out.println("Please check the driver configuration");
		}
		
		return driver;
	}

	public static WebDriver setChromeDriver() { // Setting chrome driver
		String driverPath = System.getProperty("user.dir") + "/Drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless", "--window-size=1920,1200","--ignore-certificate-errors","--start-maximized");
		driver = new ChromeDriver(); // instantiate chrome driver
		return driver;
	}

	public static WebDriver setFirefoxDriver() { // Setting firefox Driver
		String driverPath = System.getProperty("user.dir") + "/Drivers/geckodriver";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver(); // instantiate firefox driver
		return driver;
	}

	public static WebDriver setInternetExplorerDriver() { // Setting internetexplorer Driver
		String driverPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver(); // instantiate internetexplorer driver
		return driver;
	}

	public static void getUrl() {
		String filePath = System.getProperty("user.dir") + "/Application.properties";
		Properties prop = null;
		try {
			prop = new Properties(); // Used to Instantiate properties
			FileInputStream file = new FileInputStream(filePath); // providing the path of properties file
			prop.load(file);
		} catch (IOException e) {
			System.out.println("Error while reading the file at" + filePath);
			e.printStackTrace();
		}
		String url = prop.getProperty("url"); // retrieve url from properties file
		driver.get(url); // to open the Website
		driver.manage().window().maximize(); // this is used to maximize the browser
		wait=new WebDriverWait(driver,15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-search-field']")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getUrl2() {
		String filePath = System.getProperty("user.dir") + "/Application.properties";
		Properties prop = null;
		try {
			prop = new Properties(); // Used to Instantiate properties
			FileInputStream file = new FileInputStream(filePath); // providing the path of properties file
			prop.load(file);
		} catch (IOException e) {
			System.out.println("Error while reading the file at" + filePath);
			e.printStackTrace();
		}
		String url = prop.getProperty("url2"); // retrieve url from properties file
		driver.navigate().to(url); // to open the Website
		driver.manage().window().maximize(); // this is used to maximize the browser
		wait=new WebDriverWait(driver,15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-search-field']")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	public static void closeBrowser() { // to close the browser
		driver.close();
	}

}
