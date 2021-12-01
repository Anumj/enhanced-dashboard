package com.EnhancedDashBoard.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
//Similar to PageObject
public class ReadConfig 
{

	Properties prop;// Object of the Properties class
	//To read the properties from the config.properties file we use Properties class object
	
	public ReadConfig()
	{
		//src is referrring to config.proprties file 
		File src=new File("./Configuration\\Config.properties");
		try
		{
			//We are reading the data from Config.properties so we need to use FileInputStream
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);//loads the complete config file , 
			//this properties class provides an methods
			//using these we can call config elements
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
public String getApplicationURL()
{
	String url =prop.getProperty("baseURL");
	return url;
	//baseURL is a property, prop.getProperty("baseURL") this statement will get the 
	//baseurl from the config.properties and that will be assigning to the url reference variable
	//and returning the string;
	
}
public String getUserName()
{
	String userName=prop.getProperty("username");
	return userName;
	
}
public String getPassword()
{
	String Password=prop.getProperty("password");
	return Password;
}
public String getChromePath()
{
	String chrome=prop.getProperty("chromepath");
	return chrome;
}
public String getgeckoPath()
{
	String gecko=prop.getProperty("geckopath");
	return gecko;
}
public String getiePath()
{
	String ie=prop.getProperty("iepath");
	return ie;
}
/*public String getiePath()
{
	String ie=prop.getProperty("iepath");
	return ie;
}
public String getgeckoPath()
{
	String gecko=prop.getProperty("geckopath");
	return gecko;
}*/
}
