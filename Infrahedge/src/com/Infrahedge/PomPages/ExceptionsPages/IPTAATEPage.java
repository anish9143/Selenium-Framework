package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPTAATEPage extends BaseTest {

	
	@FindBy(xpath="//*[@id=\"QV018\"]/section/div/table/tbody[3]/tr/td[4]")
	WebElement tAATEProgressbar;

	public IPTAATEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicktAATEProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(tAATEProgressbar));
		tAATEProgressbar.click();
	}

	
	
}
