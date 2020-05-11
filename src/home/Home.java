package home;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.testng.Reporter;

import browser.BrowserSetup;
import excel.*;
import locators.Locators;

public class Home extends BrowserSetup  {
	


public void SearchTextBox(String testData) throws IOException {  //pass testdata from excel to searchTextBox

	WebElement input = Locators.searchtTextBox();	
	input.sendKeys(testData);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void filter() throws InterruptedException {  
	WebElement filteroption = Locators.filter();
	filteroption.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
public void filter1() throws InterruptedException { 
	WebElement level = Locators.filter1();
	level.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void filter2()  throws InterruptedException { 
	WebElement language = Locators.filter2();
	language.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void submit() throws InterruptedException { 
     WebElement filterdone =Locators.submit();
 	filterdone.click();
}

public void listofcourse()   throws Exception {  
		String course=  Locators.listofcourse() 
		System.out.println(course);
		Write.writeExcel("course  :" + course);
		Reporter.log("course are found succesfully");  // logging in test output report on success
		
}
public static void closeDriver() {
			BrowserSetup.closeBrowser(); // invoking method from browser class to close the browser
		}
public static void takeScreenshot() throws Exception {
			CaptureScreen.screenShot();    // invoking screenshot method of CaptureScreen class to capture the screenshot
		}
		
}