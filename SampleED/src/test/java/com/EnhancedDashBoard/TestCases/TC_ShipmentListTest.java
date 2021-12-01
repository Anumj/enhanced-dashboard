package com.EnhancedDashBoard.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EnhancedDashBoard.PageObject.ShipmentListPage;

public class TC_ShipmentListTest extends TC_LoginTest1_001
{
	@SuppressWarnings("deprecation")
	@Test
	public void shipmentlistActivity() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		ShipmentListPage list=new ShipmentListPage(driver);
		System.out.println("title is :"	+driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals("https://oainsight-angular.azurewebsites.net/shipment-list"))
		{
		    Assert.assertTrue(true);
			log.info("We are on the shipment listing page");
			
		}
		else
		{
			//captureScreen( driver, "loginTest");
			Assert.assertTrue(false);
			log.info("shipment listing Failed");
		}
		/****************************/
		list.dropdownClick();
		String str = driver.findElement(By.xpath("//*[contains(text(),\"Complete\")]")).getText();
		assertEquals(str, "Complete");
		log.info("Clicked on dropdown pass ");
		/******************************/
		Thread.sleep(3000);
		list.shipmentClick();
		log.info("clicked on shipment ");
		String str1 = driver.findElement(By.xpath("//p[contains(text(),'Shipment Report - RVNewAlaram1_S')]")).getText();
        assertEquals(str1, "Shipment Report - RVNewAlaram1_S");
       /******************************/
		list.toggleCClick();
		log.info("Clicked on C");
		WebElement str2 = driver.findElement(By.xpath("//th[9][contains(text(),'°C')]"));
		String strc=str2.getText();
		assertEquals(strc, "Outside Temp (°C)");
		/*****************************/
		list.toggleFClick();
		log.info("Clicked on F");
	    WebElement str3 = driver.findElement(By.xpath("//th[9][contains(text(),'°F')]"));
		String strf=str3.getText();
		assertEquals(strf, "Outside Temp (°F)");
		/*****************************/
		list.clickExpand();
		log.info("Clicked on Expand map");
		 Actions at = new Actions(driver);
    	 Thread.sleep(1000);
         at.sendKeys(Keys.PAGE_DOWN).build().perform();
         Thread.sleep(1000);
         at.sendKeys(Keys.PAGE_DOWN).build().perform();
         Thread.sleep(1000);
         at.sendKeys(Keys.PAGE_UP).build().perform();
         
		/*****************************/
		list.collpaseexpand();
		log.info("Clicked on collapse map");
		/*****************************/
		list.unselectcheckBoxes();
		log.info("Unselect checkboxes");
		/*****************************/
		list.unselectcheckBoxes();
		log.info("selected checkboxes");
		/*****************************/
		list.selectSentinel();
		log.info("Switched 1st sentinel");
		/*****************************/
		list.select24();
		log.info("Selected 24 time duration ");
		/*****************************/
		Thread.sleep(20000);
		list.select7();
		log.info("Selected 7 days in  time duration ");
		/*****************************/
		list.exportbtn();
		log.info("clicked on Export btn");
		/*****************************/
		list.exportcsv();
		log.info("CSV downloaded");
		Thread.sleep(20000);
		/*****************************/
		list.backbutton();
		log.info("navigated to main page");
		/*****************************/
		list.searbutton();
		log.info("Clicked on Search button of the shipment listing page");
		/*****************************/
		list.mainpagerefresh();
		log.info("main refresh page");
		/*****************************/
		list.logout();
		log.info("shipment listing page verified--> Pass");
		Thread.sleep(2000);
		
	}
	
}
/*WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
// click on the compose button as soon as the "compose" button is visible
driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();*/

//Actions at = new Actions(driver);
//at.sendKeys(Keys.PAGE_DOWN).build().perform();


//List<WebElement> st = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
//Assert.assertFalse(st.size() > 0, "Text not found!");