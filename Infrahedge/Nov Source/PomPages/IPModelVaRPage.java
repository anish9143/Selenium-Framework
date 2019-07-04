package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPModelVaRPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[5]/div)[2]")
	WebElement ModelVaRProgressbar;

	public IPModelVaRPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickModelVaRProgressbar()
	{
		ModelVaRProgressbar.click();
	}
	
}
