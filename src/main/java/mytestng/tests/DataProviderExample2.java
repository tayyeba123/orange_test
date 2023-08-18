package mytestng.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample2 {
	
	//Define the data provide method with required data
	@DataProvider(name = "loginData")
	public Object[][] getData() {
		Object[][] myData= {
				{"Admin","admin123"},
				{"Admin1","Welcome123"},
				{"Admin2","Xyz23"}
		};
		return myData;
	}
	
	@DataProvider(name = "loginData1")
	public Object[][] getData1() {
		Object[][] myData= {
				{"Admin","admin123"},
				{"Admin1","Welcome123"},
				{"Admin2","Xyz23"}
		};
		return myData;
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String user,String password) {
		ChromeDriver driver=new ChromeDriver();
		//Implicit wait in order to wait for the element to be displayed on the page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	}

}
