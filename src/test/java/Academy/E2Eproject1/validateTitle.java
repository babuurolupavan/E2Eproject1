package Academy.E2Eproject1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
@BeforeTest
public void initialize() throws IOException {
	
	driver=initializeDriver();
	String  URL=prop.getProperty("url");
	
	driver.navigate().to(URL);
}
	@Test
	public void basePageNavigation() throws IOException {
		
		
		 
		LandingPage  L=new LandingPage(driver);
		
		System.out.println(L.getTitle().getText());
		Assert.assertEquals(L.getTitle().getText(),"FEATURED COURSES");
		
		System.out.println(L.getTitle().getText());
	}
	
	@AfterTest
	public void  teardown() {
		
		driver.close();
	}

}
