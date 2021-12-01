package com.EnhancedDashBoard.PageObject;

import org.openqa.selenium.WebDriver;

public class Compare 
{
public static boolean  validateurl(WebDriver driver,String expURL)
{
	boolean result=false;
	if(driver.getCurrentUrl().equalsIgnoreCase(expURL))
	{
		System.out.println(driver.getCurrentUrl());
		result = true;
	}
	 return  result;
}
}
