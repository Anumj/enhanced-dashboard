package com.EnhancedDashBoard.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver LocalDriver;
	
	public LoginPage(WebDriver RemoteDriver)//Constructor
	{
		//Intialize local driver is equal to RemoteDriver
		LocalDriver=RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);	
	}

	
	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type=\'password\']")
	WebElement Password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement login;

	@FindBy(xpath="//img[@alt='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//*[@class='alert alert-danger alert-dismissible fade in']//button[@aria-label='Close']")
	WebElement closeicon;
	
	@FindBy(xpath="//*[@class='alert alert-danger alert-dismissible fade in']")
	WebElement messagediv;
	
	
	
	
	 
	
// Action Methods
public void setUsername(String Uname) 
{
	username.sendKeys(Uname);
}

public void setPassword(String pwd)
{
	Password.sendKeys(pwd);
}
public void Clicklogin()
{
	login.click();
}
public void clicklogout()
{
	logout.click();
}
public void closeicon()
{
	closeicon.click();
}



} 