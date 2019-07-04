package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPPortfolioTEPage extends BaseTest {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[6]/div)[3]")
	WebElement PortfolioTEProgressbar;

	public IPPortfolioTEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPortfolioTEProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(PortfolioTEProgressbar));
		PortfolioTEProgressbar.click();
	
	}
	catch(Exception e)
	{
		System.out.println("Element not found");
}
	}
}
