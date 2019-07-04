package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class CharitiesMMTEPage extends BaseTest{

	@FindBy(xpath="//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[1]/div[2]/form/label[2]/div")
	WebElement BUKButton;
	
	
	@FindBy(xpath="//*[@id=\"QV018\"]/section/div/table/tbody[18]/tr/td[7]/div/div[3]")
	WebElement CharitiesMMProgressbar;
	
	

	public CharitiesMMTEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickMMButton()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BUKButton)); 


        BUKButton.click();
	}
	public void clickCharitiesMMTEProgressbar()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(CharitiesMMProgressbar)); 


        CharitiesMMProgressbar.click();
}
}