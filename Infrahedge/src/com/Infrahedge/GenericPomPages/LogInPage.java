package com.Infrahedge.GenericPomPages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class LogInPage extends BaseTest{
	
	
	//identifying elements in loginPage to be used
		
		@FindBy(id="txtUserName")
		private WebElement userName;
		
		@FindBy(id="txtPwd")
		private WebElement passWord;
		
		@FindBy(id="btnLogin")
		private WebElement loginButton;
		
		@FindBy(xpath="//*[@id=\"btnAgreeTC\"]")
		private WebElement agreeButton;
		
		@FindBy(xpath="//*[contains(text(),'Barclays_IRF_May')]")
		private WebElement BarclaysReport;
		
		
		@FindBy(xpath = "//*[@class='fa fa-calendar']")
		WebElement calendarIcon;
		
		@FindBy(xpath = "//*[@day='30' and @month='3' and @year='2019']")
		WebElement datePicker;
		
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
		public void clickLogin(WebDriver driver){
			//WebDriverWait wait = new WebDriverWait(driver, 10);

	        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginButton)); 
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", loginButton);
			
			//loginButton.click();
		}
		public void clickAgreeButton(WebDriver driver){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", agreeButton);
		}
		public void clickBarclaysReport(WebDriver driver) throws InterruptedException{
			System.out.println("click the April report");
			Actions action =new Actions(driver);
			action.moveToElement(BarclaysReport);
			Thread.sleep(2000);
		//	BarclaysReport.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", BarclaysReport);
		}
	
		public void clickCalendar() throws InterruptedException
		{
			Thread.sleep(3000);
			calendarIcon.click();
		}
		
		public void datePicker()
		{
			
			WebDriverWait wait = new WebDriverWait(driver, 10);

			
				WebElement element = wait.until(ExpectedConditions.visibilityOf(datePicker));
			datePicker.click();
		}
}
