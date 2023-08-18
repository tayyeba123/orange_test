package mytestng.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DependsExample {


	ChromeDriver driver;
	@BeforeMethod
	public void beforeMethod() {
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
		//To close the browser
		//driver.quit();
	}

	@Test(priority = 0)
	public void loginTest() {
		System.out.println("Before method");
		driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");		
	
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin12");
		driver.findElement(By.tagName("button")).click();
		boolean flag,profileFlag;
		try {
			flag=driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();	
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
		//Soft assertion
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(flag, true,"Verify 'Dashboard' is displayed on Home page");
		System.out.println("Verifying profile icon is displayed on home page");
		softAssert.assertEquals(profileFlag, true,"Verify profile flag is displayed on the home page");
		softAssert.assertAll();//Call this method mandatorily 
	}
	
	@Test(priority = 1,dependsOnMethods = {"loginTest"})
	public void AdminSearchTest() {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//input[@class='oxd-input oxd-input--active']")).sendKeys("abcdef");
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	}
}
