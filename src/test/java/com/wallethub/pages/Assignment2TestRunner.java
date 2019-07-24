package com.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Assignment2TestRunner extends Assignment2
{	
	
	@Test(testName="Test2", priority = 2)
	public void runAssignment2() throws IOException, Exception
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Running Assignment2
		login();
		selectStarRating();
		submitReview();
		verifyReview();
		closeBrowser();
	}
}
