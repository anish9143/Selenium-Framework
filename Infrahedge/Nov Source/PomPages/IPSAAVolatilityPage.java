package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPSAAVolatilityPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[3]/div)[1]")
	WebElement sAAVolProgressbar;

	public IPSAAVolatilityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicksAAVolProgressbar()
	{
		sAAVolProgressbar.click();
	}
	
}
