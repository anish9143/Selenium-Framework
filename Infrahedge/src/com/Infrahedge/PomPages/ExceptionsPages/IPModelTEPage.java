package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPModelTEPage extends BaseTest{

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[5]/div)[3]")
	WebElement ModelTEProgressbar;

	public IPModelTEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickModelTEProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ModelTEProgressbar));
		ModelTEProgressbar.click();
	}
	
}
