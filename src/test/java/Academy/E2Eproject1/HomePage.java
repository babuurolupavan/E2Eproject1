package Academy.E2Eproject1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		
		
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password) throws IOException {
		driver=initializeDriver();	
String  URL=prop.getProperty("url");
		
		driver.navigate().to(URL);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		LandingPage  L=new LandingPage(driver);
		
		//L.getClose().click();
		
		L.getLogin().click();
		
		LoginPage L1=new LoginPage(driver);
		
		L1.getEmail().sendKeys(username);
		L1.getPassword().sendKeys(password);
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		 Object[][] data =new Object[2][2];
		 data[0][0]="rahul ";
		data[0][1]="1234 ";
		//data[0][2]="restrict user ";
		
		data[1][0]="rahul1 ";
		data[1][1]="12345 ";
		//data[1][2]="non restrict user ";
		return data;
	}
	@AfterTest
	public void  teardown() {
		
		driver.quit();
	}

}
