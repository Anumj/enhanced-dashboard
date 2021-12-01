package com.EnhancedDashBoard.TestCases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EnhancedDashBoard.PageObject.LoginPage;

public class TC_LoginTest1_001 extends BaseClass
{

	/*
	 * setup()-->Pre-requities-->These are written @BeforeTC
	 * test()-->Main Testcases-->@Test
	 * teardown-->@After the class-->Close the browser related activities/exiting
	 * For every testcase setup and teardown is common so we create separate class called 
	 * as BASE class and we insert setup and teardown in this class.
	 * and will extend Baseclass into the Every Testcase class
	 * 
	 *  
	 */


@Test
	public void loginTest() throws InterruptedException, IOException
	{
		/* In the above we have taken baseURL from the BaseClass
		 * Here we need to call object of the Loginpage to call/implements those elements or methods
		 * LoginPage 
		 */
	    driver.get(baseURL);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    log.info("URL is OPened");
	    
		LoginPage lp=new LoginPage(driver);
		
		Thread.sleep(10000);
		
		lp.setUsername(username);
		log.info("Entered UserName");
		
		lp.setPassword(password);
		log.info("Entered Password");
		
		lp.Clicklogin();
		
		Thread.sleep(3000);
		
	    System.out.println("title is :"	+driver.getTitle());
		if(driver.getTitle().equals("OAInsight2"))
		{
		
			Assert.assertTrue(true);
			log.info("LoginTest passed");
			Thread.sleep(3000);
		}
		else
		{
			
			captureScreen( driver, "loginTest");
			Assert.assertTrue(false);
			log.info("LoginTest Failed");
		}
	}
	
}


