package com.Infrahedge.PomPages;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Infrahedge.generic.BaseTest;

public class LogInPage{
	
	
	//identifying elements in loginPage to be used
		
		@FindBy(id="txtUserName")
		private WebElement userName;
		
		@FindBy(id="txtPwd")
		private WebElement passWord;
		
		@FindBy(id="btnLogin")
		private WebElement loginButton;
		
		@FindBy(xpath="//*[@id=\"btnAgreeTC\"]")
		private WebElement agreeButton;
		
		@FindBy(xpath="//*[contains(text(),'Barclays_IRF_Nov')]")
		private WebElement BarclaysReport;
		
		
	public	LogInPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}
	
		//Utilizing the elements declared above
	
	public void setUsername(String un){
		userName.sendKeys(un);
		}
		public void setPassword(String pw){
			passWord.sendKeys(pw);
		}
		public void clickLogin(){
			loginButton.click();
		}
		public void clickAgreeButton(WebDriver driver){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", agreeButton);
		}
		public void clickBarclaysOctReport(WebDriver driver) throws InterruptedException{
			System.out.println("click the oct report");
			Actions action =new Actions(driver);
			action.moveToElement(BarclaysReport);
			Thread.sleep(2000);
			BarclaysReport.click();
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", BarclaysOctReport);
		}
	
		
}
