package mytestng.tests;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(description = "Login test with valid credentials",priority = 2)
	public void loginTest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();


		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		boolean flag=driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		System.out.println("Dahboard text is displayed:="+flag);
		if(flag==true) {
			System.out.println("Test is successful");
		}
		else {
			System.out.println("Test is not successful");
		}
	}
	
	@Test(enabled = true,description = "Verify the login functionality with invalid credentails",priority = 1)
	public void loginTestWithInvalidCredentials() {
		ChromeDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();


		options.addArguments("--remote-allow-origins=*");

		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test(enabled = true,description = "Verify the login test1",priority = 0)
	public void loginTest1() {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.tagName("button")).click();
	}

}
