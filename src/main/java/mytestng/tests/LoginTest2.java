package mytestng.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LoginTest2 {
	ChromeDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
		driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		//To close the browser
		driver.quit();
	}

	public void loginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		boolean flag,profileFlag;
		try {
			flag=driver.findElement(By.xpath("//h6[text()='Dashboard1']")).isDisplayed();	
		}
		catch(NoSuchElementException e) {
			flag=false;
		}
		
		try {
			profileFlag=driver.findElement(By.xpath("//img[@alt='profile picture']")).isDisplayed();
		}
		catch(NoSuchElementException e) {
			profileFlag=false;
		}
		System.out.println("Dahboard text is displayed:="+flag);
		Assert.assertEquals(flag, true,"Verify 'Dashboard' is displayed on Home page");
		System.out.println("Verifying profile icon is displayed on home page");
		Assert.assertEquals(profileFlag, true,"Verify profile flag is displayed on the home page");
	}
	
	@Test(enabled=false)
	public void loginTestWithInvalidCredentials() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.tagName("button")).click();
	}
	@Test(enabled=false)
	public void loginTest1() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.tagName("button")).click();
	}

}
