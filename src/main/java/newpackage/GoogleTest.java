package newpackage;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	
	@Test(groups = {"google","regression"})
	public void googleTest() {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		driver.quit();
	}

	@Test(groups = {"google","sanity"})
	public void googleTest2() {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		driver.quit();
	}
}
