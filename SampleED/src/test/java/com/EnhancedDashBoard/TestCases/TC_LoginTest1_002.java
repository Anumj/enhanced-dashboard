package com.EnhancedDashBoard.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.EnhancedDashBoard.PageObject.Compare;
import com.EnhancedDashBoard.PageObject.LoginPage;
import com.EnhancedDashBoard.Utilities.XLUtils;


public class TC_LoginTest1_002 extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	
	public void LoginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		//Compare compare=new Compare();
		
		
		lp.setUsername(user);
		log.info("username provided");
		lp.setPassword(pwd);
		log.info("password provided");
		lp.Clicklogin();
		log.info("Clicked on login button");
		Thread.sleep(2000);
		if(isAlertPresent1()==true)
		{
			driver.switchTo().alert();
			lp.closeicon();
			//driver.switchTo().alert().accept();
     		//driver.navigate().refresh();
			//driver.switchTo().defaultContent(); 
			Assert.assertTrue(false); 
			//Assert.assertEquals(driver.getCurrentUrl(), "https://oainsight-angular.azurewebsites.net/shipment-list");
			Thread.sleep(2000);
			
			log.warn("Login failed");

		}
		else
		{
			Assert.assertTrue(true);
			//Assert.assertEquals(driver.getCurrentUrl(), "https://oainsight-angular.azurewebsites.net/shipment-list");
			Thread.sleep(20000);
			lp.clicklogout(); 
			
			log.info("Login passed");
			
			
		}
		/*if(isAlertPresent1()==true)
		{
			//driver.switchTo().alert();
			//driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible fade in']//button[@aria-label='Close']")).click();
			//driver.switchTo().alert().accept();
     		//driver.navigate().refresh();
			//driver.switchTo().defaultContent(); 
			Assert.assertTrue(false); 
			Thread.sleep(2000);
			lp.clicklogout(); 
			//lp.closeicon();
			log.warn("Login pass");

		}
		else
		{
			Assert.assertTrue(true);
			Thread.sleep(2000);
			//lp.clicklogout(); 
			log.info("Login fail");
			
			
		}*/
	
 }//Actual TestMethod
			
	public boolean isAlertPresent1()//User defined method created to checkalert is present or not
	{
		try 
		{
			driver.switchTo().alert();
			return true;
							
		}
	catch(NoAlertPresentException e)
	{
		return false;
	}
	}
	
	

	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\EnhancedDashBoard\\TestData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//i=1 j=0 
			}
		}
		
		return logindata;
	}
	
}
