package home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainDiff {

	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir") + "/Drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zigwheels.com/upcoming-Honda-bikes");
		driver.manage().window().maximize();
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='carModels']/ul/li[2]/div/div[3]/a/strong")));
		
		List<WebElement> bikeNames = driver.findElements(By.xpath("//*[@id='carModels']/ul/li/div/div[3]/a/strong"));
		List<WebElement> bikePrice = driver.findElements(By.xpath("//*[@id='carModels']/ul/li/div/div[3]/div[1]"));
		List<WebElement> bikeLaunch = driver.findElements(By.xpath("//*[@id='carModels']/ul/li/div/div[3]/div[2]"));

		for (int i = 0; i < bikePrice.size(); i++) {
			String sPrice = bikePrice.get(i).getText();			
			if (sPrice.contains("lakh")) {
				sPrice = sPrice.replaceAll("lakh", "");
				sPrice = sPrice.replaceAll("onwards", "");
				
				int val = Double.valueOf(sPrice).intValue();
				
				if (val > 4) {
					bikePrice.remove(bikePrice.get(i));
					bikeNames.remove(bikeNames.get(i));
					bikeLaunch.remove(bikeLaunch.get(i));
				}
			} else {
				sPrice = sPrice.replace("onwards", "");
			}

		}
		
		for (int i = 0; i < bikePrice.size(); i++) {
			System.out.println("\r\n" + bikeNames.get(i).getText() + "\n" + bikePrice.get(i).getText().replaceAll("onwards", "") + "\n"
					+ bikeLaunch.get(i).getText());		
			}
		driver.quit();


	}

}
