package com.wallethub.pages;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ReadUserInput 
{
	static String path="./UserDetails.properties";
	
	public static String getUsername() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String uname=prop.getProperty("sUsername");
								
				return uname;
		}
	
	public static String getUserPassword() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String password=prop.getProperty("sPassword");
								
				return password;
		
	}
	
	public static String getPostMessage() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String postMessage=prop.getProperty("sPostMessage");
				
				return postMessage;
		}
	
	public static String getWHUserName() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String URL=prop.getProperty("sWalletHubUsername");
				
				return URL;		
	}
	
	public static String getWHPassword() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String URL=prop.getProperty("sWalletHubPassword");
				
				return URL;
	}
	
	public static String getWHReview() throws Exception, IOException
	{
		File src = new File(path);
		
		FileInputStream fileInput = new FileInputStream(src);
				
				Properties prop = new Properties();
				
				prop.load(fileInput);
				
				String URL=prop.getProperty("sWalletHubReview");
				
				return URL;
	}
	
	public static String getUName() throws IOException, Exception
	{
		String sUName=ReadUserInput.getWHUserName();
		String [] userName = sUName.split("@", 0);
		String uName = userName[0]; 
		return uName;
	}
}
