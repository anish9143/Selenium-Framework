package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPMMTEPage extends BaseTest {

	
	@FindBy(xpath="//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[1]/div[2]/form/label[2]/div")
	WebElement BUKButton;
	
	
	@FindBy(xpath="//*[@id=\"QV018\"]/section/div/table/tbody[3]/tr/td[7]")
	WebElement MMTEProgressbar;
	
	

	public IPMMTEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickMMButton()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BUKButton)); 


        BUKButton.click();
	}
	public void clickMMTEProgressbar()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(MMTEProgressbar)); 


        MMTEProgressbar.click();
	}
	
}
