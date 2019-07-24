package com.wallethub.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//fb-username: whuserps@grr.la
//fb-pass: whuserps123
import org.testng.annotations.Test;

public class Assignment1 extends BrowserFactory
{

	WebDriver driver= startBrowser("chrome");
	WebDriverWait wait = new WebDriverWait(driver,3);
	Actions act = new Actions(driver);
	String URL="http://facebook.com";
	
	public void login() throws IOException, Exception
	{
		driver.get(URL);
		
		WebElement userName=driver.findElement(By.id("email"));
		WebElement userPassword=driver.findElement(By.id("pass"));
		WebElement btnLogin=driver.findElement(By.id("loginbutton"));
		
		wait.until(ExpectedConditions.titleContains("Facebook"));
		
		userName.clear();
		userName.sendKeys(ReadUserInput.getUsername());
		
		userPassword.clear();
		userPassword.sendKeys(ReadUserInput.getUserPassword());
		
		btnLogin.click();

		WebElement newsfeedOption=driver.findElement(By.xpath("//div[contains(text(),'News Feed')]"));
		
		wait.until(ExpectedConditions.elementToBeClickable(newsfeedOption));
		
		newsfeedOption.click();
		System.out.println("Login successful on facebook");
	}
	
	public void postStatusMessage() throws IOException, Exception
	{
		wait.until(ExpectedConditions.titleContains("Facebook"));
		Thread.sleep(2000);
		
		WebElement postMessageArea=driver.findElement(By.xpath("//textarea[contains(@class,'navigationFocus')]"));
		wait.until(ExpectedConditions.elementToBeClickable(postMessageArea));
		act.moveToElement(postMessageArea).click().build().perform();
		postMessageArea.sendKeys("Hello World");
		WebElement btnSharePost=driver.findElement(By.xpath("//button[@data-testid='react-composer-post-button' and @type='submit']"));
		btnSharePost.click();
		System.out.println("You have posted successfully on facebook!!!");
	}
}
