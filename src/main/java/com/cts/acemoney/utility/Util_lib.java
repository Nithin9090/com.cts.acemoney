package com.cts.acemoney.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.cts.acemoney.base.TestBase;

public class Util_lib  extends TestBase
{
	
	static Select sel;
	
	static Alert alt;
	
	static File src;

	public Util_lib() throws IOException 
	{
		super();
		
	}
	
	public static void max_win()
	{
		try
		{
		driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void implicit_Wait(int time)
	{
		try
		{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static  void selectByValue(WebElement ele, String value) //dropdown method
	{
		sel=new Select(ele);

		
		sel.selectByValue(value);
	}
	
	public static void selectByVisibletext(WebElement ele, String value)
	{
		sel=new Select(ele);
		
		sel.selectByVisibleText(value);
	}
	
	public static void selectByindex(WebElement ele, int opt)
	{
		sel=new Select(ele);
		
		sel.selectByIndex(opt);
	}
	
	public static void Alert_OK_btn()
	{
		alt=driver.switchTo().alert();
		
		alt.accept();
	}
	
	public static void Alert_Cancle_btn()
	{
		alt=driver.switchTo().alert();
		
		alt.dismiss();
	}
	
	public static void Takes_Screenshot()
	{
		try
		{
		src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File(".\\Screenshot\\Fb_"+System.currentTimeMillis()+".png"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


}
