package mytestng.tests;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test
	public void loginTest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();


		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);


		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		try
		{
			driver.findElement(By.tagName("button")).click();
		}
		catch(Exception e) {
			return;
		}
		//skip remaining lines of test
		System.out.println("Testing the return");
	}

}
