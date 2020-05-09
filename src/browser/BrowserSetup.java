package browser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BrowserSetup {
  public static WebDriver driver;
	/**
	 * @return
	 */
	public static WebDriver setBrowser() {   
		Scanner scan = new Scanner(System.in);  // to take input from user
														
		System.out.println(						// Displaying message to Choose any one of the Browsers
				"Which browser would you like to execute the script on? \r\n "
				+ "1. Opera "
				+ "2. Google Chrome \r\n "
				+ "3.Mozilla Firefox "
				+ "4.Internet Explorer");
		
		int browserChoice = scan.nextInt();
		scan.close();   
		
		
		if (browserChoice == 1) {     // if else condition to Execute the User selected Browser
			driver = setOperaDriver();
		} else if (browserChoice == 2) {
			driver = setChromeDriver();
		} else if(browserChoice == 3) {
			driver = setFirefoxDriver();
		}
		else if(browserChoice == 4) {
			driver = setInternetExplorerDriver();
			}
		else {
			System.out.println("Invalid Input");  
		}
		return driver;
	}
	
	
	public static WebDriver setOperaDriver() {   //Setting opera driver
		String driverPath = System.getProperty("user.dir") + "\\Drivers\\operadriver.exe";
		System.setProperty("webdriver.opera.driver",driverPath);
		WebDriver driver1=new OperaDriver();	//Instantiate  opera driver
		
		return driver1;
	}
	public static WebDriver setChromeDriver() { //Setting chrome driver
		String driverPath = System.getProperty("user.dir") +"/Drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver",driverPath);
		WebDriver driver2=new ChromeDriver(); //Instantiate chrome driver
		return driver2;
	}
	
	public static WebDriver setFirefoxDriver() {    // Setting  firefox Driver
		String driverPath = System.getProperty("user.dir") + "/Drivers/geckodriver"; 
				System.setProperty("webdriver.gecko.driver",driverPath);
				WebDriver driver3=new FirefoxDriver(); //instantiate firefox driver
		return driver3;
	}
	public static WebDriver setInternetExplorerDriver() {    // Setting  internetexplorer Driver
		String driverPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe"; 
				System.setProperty("webdriver.ie.driver",driverPath);
				WebDriver driver4=new InternetExplorerDriver(); //instantiate internetexplorer driver
		return driver4;
	}

	public static void getUrl() throws InterruptedException, IOException {
		 
		Properties prop= new Properties();			// Used to Instantiate properties
		String projectpath = System.getProperty("user.dir");
		InputStream input = new FileInputStream(projectpath+ "/Application.properties");  //providing the path of Properties file
		prop.load(input);
		 String url = prop.getProperty("url");
		 
		driver.get(url);  // to open the Website
		driver.manage().window().maximize();   // this is used to maximize the browser
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public static void closeBrowser() {      //to close the browser
		driver.close();
		
	}

  

}
