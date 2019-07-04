package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPMMVaRPage extends BaseTest {

	
	@FindBy(xpath="//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[1]/div[2]/form/label[2]/div")
	WebElement BUKButton;
	
	
	@FindBy(xpath="(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='MM'])[2]")
	WebElement MMVaRProgressbar;
	
	

	public IPMMVaRPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickMMButton()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(BUKButton)); 


        BUKButton.click();
	}
	public void clickMMVaRProgressbar() throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(MMVaRProgressbar));
			Thread.sleep(6000);
			MMVaRProgressbar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			MMVaRProgressbar.click();
		}

	}
	
}
