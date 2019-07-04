package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPSAAVaRPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[3]/div)[2]")
	WebElement sAAVaRProgressbar;

	public IPSAAVaRPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicksAAVaRProgressbar()
	{
		sAAVaRProgressbar.click();
	}
	
}
