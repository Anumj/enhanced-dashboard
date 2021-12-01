package com.EnhancedDashBoard.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author anupama.mj
 *
 */
public class ShipmentListPage 
{
	WebDriver LocalDriver;
	
	public ShipmentListPage(WebDriver rdriver)
	{
		LocalDriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath="//body/app-root[1]/div[1]/app-shipment-list[1]/div[2]/div[2]/select[1]")
	WebElement dropdown;
	
	@FindBy(xpath="//tbody[1]/tr[46]/td[1]")
	WebElement shipment;
	
	@FindBy(xpath="//label[@class='labelF']")
			WebElement toggleF;
	
	@FindBy(xpath="//label[@class='labelC']//span[contains(text(),'C')]")
	WebElement toggleC;
	
	@FindBy(xpath="//button[@class='expand']")
	WebElement clickExpand;
	
	@FindBy(xpath="//button[@class='dimnish']")
	WebElement collpaseexpand;
	
	@FindBy(xpath="//div[@class='light sensorsWidget']//div[@class='lightDetail']//div//input[@type='checkbox']")
	WebElement selectcheckBoxes;
	
	@FindBy(xpath="//div[@class='shock sensorsWidget']//div[@class='shockDetail']//div//input[@type='checkbox']")
	WebElement unselectcheckBoxes;
	
	@FindBy(xpath="//div[@class='dashboard-header']//td[2]")
	WebElement selectSentinel;
	
	@FindBy(xpath="//button[normalize-space()='Last 24 Hours']")
	WebElement select24;
	
	@FindBy(xpath="//button[normalize-space()='Last 7 Days']")
	WebElement select7;
	
	@FindBy(xpath="//button[@class='exportData']")
	WebElement exportbtn;
	
	@FindBy(xpath="//div[@class='dashboard-header']//div//div[@class='exportOption']//div//button[contains(text(),'Export to CSV')]")
	WebElement exportcsv;
	
	@FindBy(xpath="//h4[normalize-space()='Back']")
	WebElement backbutton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searbutton;
	
	@FindBy(xpath="//img[@alt='refresh_icon']")
			WebElement mainpagerefresh;
	
	@FindBy(xpath="//img[@alt='Logout']")
	WebElement logout;
	
	public void dropdownClick() throws InterruptedException
	{
		dropdown.click();
		Select oSelect = new Select(dropdown);
		 oSelect.selectByVisibleText("Complete");
		 Thread.sleep(3000);
	}
	
	public void shipmentClick()
	{
		shipment.click();
	}
	
	public void toggleFClick()
	{
		toggleF.click();
	}
	
	public void toggleCClick()
	{
		toggleC.click();
	}
	
	public void clickExpand()
	{
		clickExpand.click();
	}
	
	public void collpaseexpand()
	{
		collpaseexpand.click();
	}
	
	public void selectcheckBoxes()
	{
		selectcheckBoxes.click();
	}
	public void unselectcheckBoxes()
	{
		unselectcheckBoxes.click();
	}
	public void selectSentinel()
	{
		selectSentinel.click();
	}
	public void select24()
	{
		select24.click();
	}
	public void select7()
	{
		select7.click();
	}
	public void exportbtn()
	{
		exportbtn.click();
	}
	public void exportcsv()
	{
		exportcsv.click();
	}
	public void backbutton()
	{
		backbutton.click();
	}
	public String searbutton()
	{
		searbutton.sendKeys("_S");
		return null;
	}
	
	public void mainpagerefresh()
	{
		mainpagerefresh.click();
	}
	
	public void logout()
	{
		logout.click();
	}
}
