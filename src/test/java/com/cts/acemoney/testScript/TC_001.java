package com.cts.acemoney.testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cts.acemoney.base.TestBase;
import com.cts.acemoney.pages.LoginPage;
import com.cts.acemoney.utility.ExcelConfig;
import com.cts.acemoney.utility.Util_lib;

public class TC_001 extends TestBase
{

    LoginPage lp;	
	
	public TC_001() throws IOException 
	{
		
		super();
		
		
	}
	
	
	@BeforeTest
	public void setUp() throws IOException
	{
		initBrowser();
		
		lp=new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateTitle()
	{
		String actualTitle= lp.verifyTitle();
		
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority = 2)
	public void validateUrl()
	{
		String actualUrl=lp.verifyUrl();
		
		Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/");
	}
	
	
	@Test(priority = 3)
	
	public void validateLoginPanelText()
	{
		String loginpanel=lp.verifyLoginPanelText();
		
		Assert.assertEquals(loginpanel, "LOGIN Panel");
	}
	
	
	@Test(priority = 4, dataProvider = "s1")
	public void validateLogin(String user, String pass)
	{
		lp.userName.sendKeys(user);
		
		lp.password.sendKeys(pass);
		
		lp.loginBtn.click();
		
		Util_lib.implicit_Wait(30);
		
		lp.logOutIcon.click();
		
		lp.logoutbtn.click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name="s1")
	public Object[][] LoginData()
	{
		ExcelConfig e=new ExcelConfig(".\\src\\main\\java\\com\\cts\\acemoney\\Excel\\orangehrmddf.xlsx");
		
		int rows=e.getRowSize("Sheet1");
		
		int cols=e.getColSize("Sheet1");
		
		Object[][] obj=new Object[rows][cols];
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				obj[i][j]=e.getExcelData("Sheet1", i, j);
			}
		}
		
		return obj;
	}

}
