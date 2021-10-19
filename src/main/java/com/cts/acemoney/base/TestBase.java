package com.cts.acemoney.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.cts.acemoney.utility.Util_lib;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	File f;
	
	FileInputStream fis;
	
	Properties pro;
	
	
	public TestBase() throws IOException
	{
		f=new File(".\\src\\main\\java\\com\\cts\\acemoney\\property\\Config.properties");
		
		fis=new FileInputStream(f);
		
		pro=new Properties();
		
		pro.load(fis);
	}
	
	public void initBrowser()
	{
		String browsername=pro.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", pro.getProperty("chromepath"));
			
			driver=new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", pro.getProperty("operapath"));
			
			driver=new OperaDriver();
		}
		
		else
		{
			System.out.println("Given browser name is wrong");
		}
		
		driver.get(pro.getProperty("url"));
		
		Util_lib.max_win();
		
		Util_lib.implicit_Wait(30);
		
	}

}
