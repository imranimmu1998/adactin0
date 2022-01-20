package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Base_Class_Testng {
	
	public static WebDriver driver;
	public static TakesScreenshot screenshot;
	
		
	//Get browser Launch 
	public static WebDriver getbrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+("\\Driver\\chromedriver.exe"));
		driver =new ChromeDriver();
		
		}
		
		else if (browser.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+("\\Driver\\msedgedriver.exe"));
		driver=new EdgeDriver(); 
		}
		else 
			System.out.println(".......Invalid Browser......");
		return driver;
	}
		
	// Get link Method 
	
	public static void getlink(String link1) {
		driver.get(link1);
		driver.manage().window().maximize();
		
	}
	
	
	// Browser Close Method 
		
		public static void closebrowser() {
			driver.close();
		}
	
	// Browser quit Method
		public static void quit() {
			driver.quit();
			
		}
		
	//Navigate To 
		public static void to(String tolink) {
			driver.navigate().to(tolink);
		}
		
				
	//Navigate back
		public static void back() {
			driver.navigate().back();
		}
		
	//Navigate forward
		
		public static void forward() {
			driver.navigate().forward();
		}
		
	//Navigate refresh
		
		public static void refresh() {
			driver.navigate().refresh();
		}
				
	//Take Screenshot
	public static void screenshot() throws IOException, InterruptedException {
	screenshot =(TakesScreenshot) driver;
	File scr = screenshot.getScreenshotAs(OutputType.FILE);
	File des = new File(System.getProperty("user.dir")+("\\Screenshot\\img.png"));
	FileUtils.copyFile(scr, des);
	Thread.sleep(2000);
		
	}
	
	//Click
		public static void click(WebElement element) throws InterruptedException {
			element.click();
			Thread.sleep(2000);
		}
	
	// Send key
		public static void sendvalue(WebElement element,String value) throws InterruptedException {
		element.sendKeys(value);
		Thread.sleep(2000);
	}
		
	public static  void sleep()  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//Alert
	public static  void alertbox(String value, String string) throws InterruptedException {
		
		if (value=="ok") {  // ok button
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		} 
		else if (value=="cancel") {		// cancel 
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		}
		else if (value=="ok"&& string != null) {
			driver.switchTo().alert().sendKeys(string);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}
		else if (value=="cancel"&& string != null) {
			driver.switchTo().alert().sendKeys(string);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			} 
					
	}
	
	//Action
	public static Actions actions() {  // actions class
		Actions ac1 =new Actions(driver);
		return ac1;
		
	}
	//Robot class
	
	public static Robot robot1() throws AWTException {
		Robot rb=new Robot();			
		return rb;
		
	}
	
	//Frame
	
	public static void frame(WebElement element) {
		driver.switchTo().frame(element);		
	}
	// Drop Down
	public static  void dropdown(WebElement element, String value) throws InterruptedException {
		Select sl = new Select(element);
		sl.selectByValue(value);
		Thread.sleep(2000);
	}
	
	//ScrollDown
	
	public static  void scrolldown() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(4000);
		
	}
		
		
} 
	
		//Windows Handling 
		
		//Check List 
		// is enable
		//Is Displayed
		//Is Select
		//Get Option
		//Get Title 
		//Get Current URL
		// Get text 
		// Get Attribute 
		//wait 
		 


