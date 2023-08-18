package newpackage;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FlipkartTest {
	
	@Test(groups = {"flipkart","regression"})
	public void flipkartTest() {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com");
		Reporter.log("Luanching flipkart website");
		driver.quit();
	}
	
	@Test(groups = {"flipkart","sanity"})
	public void flipkartTest2() {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com");
		Reporter.log("Luanching flipkart website in method2");
		driver.quit();
	}

}
