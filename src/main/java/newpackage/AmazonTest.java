package newpackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTest {
	
	@Parameters({"browser"})
	@Test(groups = {"amazon","regression"})
	public void amazonTest(String browser) {
		System.out.println("Browser:="+browser);
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.com");
		driver.quit();
	}
	
	@Test(groups = {"amazon","sanity"})
	public void amazonTest2() {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.com");
		driver.quit();
	}

}
