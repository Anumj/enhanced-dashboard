package com.EnhancedDashBoard.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.EnhancedDashBoard.Utilities.ReadConfig;




public class BaseClass 


{
	//From the config.properties file , readconfig.properties file read the data from this file and provide data to the Base class
	//common stuff required for every TC
//	public String baseURL="https://demo.guru99.com/V1/index.php";
//	public String username="mngr362138";
//	public String password="navubum";
	
	ReadConfig readconfig=new ReadConfig();
	
	
	public String baseURL=  readconfig.getApplicationURL();
	public String username= readconfig.getUserName();
	public String password= readconfig.getPassword();
	
    public static WebDriver driver;
	
	public static Logger log;
	

	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		//System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		/*C:\\Users\\anupama.mj\\eclipse-workspace\\SampleED\\ for this we can use 
		 * system.getproperty("user.dir") to get project path instead of path
		 *This will give the project home directory 
		 */
		 log=Logger.getLogger("OAInsight");
			PropertyConfigurator.configure("log4j.properties");
		
			if(br.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();	
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", readconfig.getgeckoPath());
				driver=new FirefoxDriver();
			}
			else if(br.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver", readconfig.getiePath());
				driver=new InternetExplorerDriver();
			}
				//Thread.sleep(30000);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
}
}
