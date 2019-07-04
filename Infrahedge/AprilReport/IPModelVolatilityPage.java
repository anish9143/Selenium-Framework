package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPModelVolatilityPage extends BaseTest{

	
	@FindBy(xpath="//*/div/table/tbody/tr/td[5]/div[1]")
	WebElement ModelVolProgressbar;

	public IPModelVolatilityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickModelVolProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 12);
try {
       WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelVolProgressbar)); 
		
		ModelVolProgressbar.click();
}
catch(Exception e)
{
	System.out.println("Element not found");
}
	}
	
}
