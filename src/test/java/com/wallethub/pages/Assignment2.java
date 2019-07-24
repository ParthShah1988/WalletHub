package com.wallethub.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//fb-username: whuserps@grr.la
//fb-pass: whuserps123
import org.testng.annotations.Test;

public class Assignment2 extends BrowserFactory
{	
	
	WebDriver driver= startBrowser("chrome");
	WebDriverWait wait = new WebDriverWait(driver,5);
	Actions act = new Actions(driver);
	String URL="https://wallethub.com/join/login";
	
	public void login() throws IOException, Exception
	{
		//Load the URL
		driver.get(URL);
		//WebElemets on LoginPage
		WebElement userName=driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		WebElement userPassword=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement btnLogin=driver.findElement(By.xpath("//button[@class='btn blue center reg-tabs-bt touch-element-cl']"));
		
		wait.until(ExpectedConditions.titleContains("Login"));
		
		userName.clear();
		userName.sendKeys(ReadUserInput.getWHUserName());
		
		userPassword.clear();
		userPassword.sendKeys(ReadUserInput.getWHPassword());
		
		btnLogin.click();
		
		wait.until(ExpectedConditions.titleContains(ReadUserInput.getUName()));
		System.out.println("Login successful on WalletHub!");
	}
	
	public void selectStarRating() throws IOException, Exception
	{
		driver.navigate().to("https://wallethub.com/profile/test_insurance_company/");
		wait.until(ExpectedConditions.titleContains("Test Insurance Company Reviews"));
		
		
		WebElement header=driver.findElement(By.xpath("//h1[@class='profile-name']"));
		wait.until(ExpectedConditions.elementToBeClickable(header));
		Thread.sleep(2000);
		//Scrolling down few pixels
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");
		
		WebElement starFive=driver.findElement(By.xpath("//div[@class='review-action ng-enter-element']//*[5]"));
		
		//Hovering and Clicking on Star-5
		act.moveToElement(starFive);
		Thread.sleep(2000);
		act.click().build().perform();
			
		wait.until(ExpectedConditions.titleContains("Test Insurance Company Reviews"));
		
		System.out.println("Navigated to submit review page successfully!");
	}
	
	public void submitReview() throws IOException, Exception
	{
		WebElement btnSubmit=driver.findElement(By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall' and contains(text(),'Submit')]"));
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		
		WebElement policyDropDown=driver.findElement(By.xpath("//span[contains(text(),'Select...')]"));
		WebElement healthPolicy=driver.findElement(By.xpath("//li[contains(text(),'Health Insurance')]"));
		
		//Selecting Health Policy from the drop down
		policyDropDown.click();
		act.moveToElement(healthPolicy).click().build().perform();
		
		//Writing review text
		WebElement reviewText=driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']"));
		reviewText.sendKeys(ReadUserInput.getWHReview());
		
		btnSubmit.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.titleContains("WalletHub - Review Confirmation"));
		
		WebElement reviewAck=driver.findElement(By.xpath("//h4[contains(text(),'Your review has been posted.')]"));
		
		System.out.println(reviewAck.getText());		
	}
	
	public void verifyReview() throws IOException, Exception
	{
		WebElement menu_Uname=driver.findElement(By.xpath("//span[contains(text(),'"+ReadUserInput.getUName()+"')]"));
		WebElement menu_Uname_Profile=driver.findElement(By.xpath("//a[@class='brgm-list-it'][contains(text(),'Profile')]"));
		
		act.moveToElement(menu_Uname).build().perform();
		act.moveToElement(menu_Uname_Profile).click().build().perform();
		
		WebElement tab_Activity=driver.findElement(By.xpath("//li[@class='selected']//a[1]"));
		WebElement tab_Reviews=driver.findElement(By.xpath("//div[@id='wh-body']//li[3]//a[1]"));
		WebElement tab_Activity_Feed_Desc=driver.findElement(By.xpath("//p[@class='feeddesc']"));
		WebElement tab_Activity_Reviewer_Name=driver.findElement(By.xpath("//a[@data-username='"+ReadUserInput.getUName()+"']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(tab_Activity_Reviewer_Name));
		
		tab_Activity.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(tab_Activity_Feed_Desc));
		
		//Redirecting to reviews page
		tab_Reviews.click();
		Thread.sleep(2000);
		WebElement tab_Reviews_Feed_Desc=driver.findElement(By.xpath("//div[starts-with(@id,'review')]//p"));
		
		wait.until(ExpectedConditions.elementToBeClickable(tab_Reviews_Feed_Desc));
		
		String feedDesc = tab_Reviews_Feed_Desc.getText().trim();
		
		//Performing assertion on the review text
		Assert.assertTrue(feedDesc.equalsIgnoreCase(ReadUserInput.getWHReview().trim()), "Your feed has not been reviewed!!!");
		
		System.out.println("Your feed is reviewed and published on WalletHub!!!");
	}
	
	
}
