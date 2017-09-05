package com.crm.utils;



import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import com.crm.config.BaseConfiguration;

public class CommonUtils {
	
	public static WebDriver wd = null;
	
//	public static void validatePage(String title, WebDriver wd) {
//		Assert.assertEquals(title, wd.getTitle());
//	}
	
	public static void clickLink(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("link")){
			wd.findElement(By.linkText(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("plink")) {
			wd.findElement(By.partialLinkText(locator)).click();
		}
	}
	
	public static void clickButton(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
	}
	
	public static void clickRadioButton(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
	}
	
	public static void insertText(String identifiedBy, String locator, String text, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(text);
		}
	}
	
	public static String getInsertedText(String identifiedBy, String locator, String text, WebDriver wd) {
		String txt = null;
		if(identifiedBy.equalsIgnoreCase("id")) {
			txt = wd.findElement(By.id(locator)).getAttribute("value");
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			txt = wd.findElement(By.name(locator)).getAttribute("value");
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			txt = wd.findElement(By.xpath(locator)).getAttribute("value");
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			txt = wd.findElement(By.cssSelector(locator)).getAttribute("value");
		}
		return txt;
	}
	
	public static void accetAlert(WebDriver wd) {
		Alert alert = wd.switchTo().alert();
		alert.accept();
	}
	
	public static void selectDropDownItem(String identifiedBy, String locator, String itemType, String value, WebDriver wd) {
		WebElement element = null;
		if(identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		}
		
		Select selectObj = new Select(element);
		if(itemType.equalsIgnoreCase("value")) {
			selectObj.selectByValue(value);
		}
		else if(itemType.equalsIgnoreCase("index")) {
			selectObj.selectByIndex(Integer.parseInt(value));
		}
		else if(itemType.equalsIgnoreCase("text")) {
			selectObj.selectByVisibleText(value);
		}
	}
	
	public static void pageRefresh(WebDriver wd) {
		wd.navigate().refresh();
	}
	
	public static void pageNavigateBack(WebDriver wd) {
		wd.navigate().back();
	}
	
	public static void pageNavigateForward(WebDriver wd) {
		wd.navigate().forward();
	}
	
	public static String getTextFromPage(String identifiedBy, String locator, WebDriver wd) {
		String txt = null;
		if(identifiedBy.equalsIgnoreCase("id")) {
			txt = wd.findElement(By.id(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			txt = wd.findElement(By.name(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			txt = wd.findElement(By.xpath(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			txt = wd.findElement(By.cssSelector(locator)).getText();
		}
		return txt;
	}

	
	public static boolean isElementPresent(String identifiedBy, String locator, WebDriver wd) {
		Boolean state = null;
		if(identifiedBy.equalsIgnoreCase("id")) {
			state = wd.findElement(By.id(locator)).isDisplayed();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			state = wd.findElement(By.name(locator)).isDisplayed();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			state = wd.findElement(By.xpath(locator)).isDisplayed();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			state = wd.findElement(By.cssSelector(locator)).isDisplayed();
		}
		return state;
	}
	
	public static void wait(int timeout) throws InterruptedException {
		int timeoutVal = timeout * 1;
		for(int second = 0; second < timeoutVal; second++) {
			Thread.sleep(1000);
		}
	}
	
	public static void takeScreenShot(WebDriver wd) {
		try {
			int count = 0;
			String NewFileNamePath;
			//File directory = new File(".");
			DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
			Date date = new Date();
			
			NewFileNamePath = "C:\\Users\\KOSMIK\\Desktop\\ScreenShots\\" + dateformat.format(date)+ "_" + ".png";
			BufferedImage screenCapture = new Robot().createScreenCapture(new Rectangle(968, 1009));
			
			File file = new File(NewFileNamePath);
			ImageIO.write(screenCapture, "png", file);
			count++;
			
			File screenshot = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(NewFileNamePath));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
