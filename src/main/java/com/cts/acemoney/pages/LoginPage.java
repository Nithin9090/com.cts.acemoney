package com.cts.acemoney.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.acemoney.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id="txtUsername")
	public WebElement userName;
	
	
	@FindBy(name="txtPassword")
	public WebElement password; ////
	
	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement loginBtn;
	
	
	@FindBy(id="welcome")
	public WebElement logOutIcon;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutbtn;
	
	
	@FindBy(id="forgotPasswordLink")
	WebElement forgotPassword;
	
	@FindBy(id="logInPanelHeading")
	WebElement loginPanel;
	
	
	public LoginPage() throws IOException
	{
		super();
		
		PageFactory.initElements(driver, this); ////
	}
	
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	public String verifyLoginPanelText()
	{
		return loginPanel.getText();
	}
	
	public String verifyForgotaccountText()
	{
		return forgotPassword.getText();
	}
	
	
	
	
	

}
