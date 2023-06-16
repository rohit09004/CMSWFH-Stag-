package com.csm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.csm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSMBase {
	
	public static WebDriver driver;
	public static  Properties prop;
	
	public CSMBase()
	{
		try
		{
		prop = new Properties();
		//FileInputStream ip= new FileInputStream("D:\\CCSMAAutomation\\src\\main\\java\\com\\csm"+"/qa/config/config.properties");
		FileInputStream ip= new FileInputStream("D:\\Eclipse_rohit\\CMSWFH(Stag)\\src\\main\\java\\com\\csm\\qa\\config\\configg.properties");
		prop.load(ip);
		
	    }catch(FileNotFoundException e)
		{
	    	e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	// read the property
	public static void initialize() throws InterruptedException
	{
	 
		//System.setProperty("webdriver.chrome.driver","D:\\Eclipse_rohit\\EclipseSetup_Library\\ChromeDriverJune2023\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageload_wait));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
		 driver.get(prop.getProperty("url"));//url is launched 
	
		 
	}
}