package home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) throws Exception {
		String driverPath = System.getProperty("user.dir") + "/Drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.udemy.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("web development",Keys.RETURN);
		//driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[2]/div[3]/form/div/button")).click();
		Thread.sleep(2000);
//		try {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='filter-form']/div/div[5]/label")));
		driver.findElement(By.xpath("//*[@id='filter-form']/div/div[5]/label")).click();
//		}catch(Exception e) {
//			driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[4]/div/div/div[5]/div[1]/div[1]/div[1]/button")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div/div[5]/label")).click();
//		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div/div[5]/div/div/div/div/div/fieldset/label[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div/div[6]/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div/div[6]/div/div/div/div/div/fieldset/label[1]")).click();
		Thread.sleep(2000);
		try {
		driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[4]/div/div/div[6]/div[2]/div[1]/div[1]/div/label")).click();
		}catch(Exception e) {
			System.out.println("closing filter fail");
		}
		List <WebElement> names = driver.findElements(By.xpath("//*[@id='udemy']/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div/div[1]/a[1]/div[1]/div[1]"));
		for(WebElement el : names) {
			System.out.println(el.getText());
		}
//		for(int i=1; i<17;i++) {
//		if(i==4) {
//			continue;
//		}
//		String name = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div[2]/div[2]/div["+i+"]/div[1]/a[1]/div[1]/div[1]")).getText();
//		System.out.println(name);
//		}
//		driver.close();
	}

}
