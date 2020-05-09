package locators;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import browser.BrowserSetup;

public class Locators extends BrowserSetup {
	public static void main(String[] args) throws InterruptedException, IOException {
		setBrowser();
		getUrl();

		driver.findElement(By.xpath("//*[@id='header-search-field']")).sendKeys("Web Development", Keys.RETURN);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
	
        WebElement filterElement = driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button"));

		js.executeScript("arguments[0].scrollIntoView(true)",filterElement);
		
		filterElement.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement beginnerEl = driver.findElement(By.xpath("//*[@id=\"filter-form--13\"]/fieldset[3]/div[2]/label/span"));
	beginnerEl.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement englishEl = driver.findElement(By.xpath("//*[@id=\"filter-form--13\"]/fieldset[4]/div[1]/label/span"));
	englishEl.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement doneBtn = driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div/div/div[5]/div[1]/div[1]/div[1]/button[1]"));
	doneBtn.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	for(int i=0; i<3 ; i++) {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div/div/div[5]/div[2]/div["+(i+1)+"]/div/a/div/div[2]/div[1]/h4")).getText());	
	}
	
		driver.close();
	
	}
}
