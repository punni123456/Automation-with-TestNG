package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing04 {

	WebDriver driver;
	
	@BeforeTest
	public void init() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=2)
	public void TestTitle() {
		
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle,"True");
		
	}
	
	@Test(priority=1)
	public void TestUrl() {
		
		String ExpectedUrl = "https://www.saucedemo.com/";
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpectedUrl,"True");
		
	}
	
	@Test(priority=3)
	public void LoginCheck() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
	}
	
}
