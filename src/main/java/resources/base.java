package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		 prop=new Properties();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\laxmi\\eclipse-workspace\\E2Eproject1\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String  browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome") ){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Tools\\chromedriver.exe");
		       driver= new  ChromeDriver();
		}
		
		else if(browserName=="firefox") {
			System.setProperty("webdriver.gecko.driver", "C:\\Dev\\Tools\\geckodriver.exe");
		       driver= new  FirefoxDriver();
			
		}
		
		
		
		return driver;
		
	}
	
	
	public void getScreenShotPath(String testcaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		
		FileUtils.copyFile(source,new File(destinationFile));
		
	}
}
