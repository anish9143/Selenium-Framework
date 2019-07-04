package com.Infrahedge.PomPages.ExposurePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class ExposurePage extends com.Infrahedge.generic.BaseTest {

	@FindBy(xpath = "//div['current-selections']//preceding-sibling::span[text()='Exposure']")
	WebElement exposureTab;
	
	@FindBy(xpath = "//*[text()='AUM']")
	WebElement AUMelement;
	
	@FindBy(xpath = "//*[text()='Accounts']")
	WebElement Accountselement;
	
	@FindBy(xpath = "(//*[@type='radio' and @value='BI'])[3]")
	WebElement BIbutton;
	
	@FindBy(xpath = "(//input[@name='radioB' and @value = 'BUK'])[3]")
	WebElement BUKbutton;
	
	
	
	@FindBy(xpath = "//*[@class='fa fa-filter']")
	WebElement filterICon;
	
	@FindBy(xpath = "//*[text()='Exposure'and @class='exposure-header active']")
	WebElement exposureSubTab;
	
	@FindBy(xpath = "//*[text()='Search'and @class='exposure-header']")
	WebElement searchSubTab;
	
	@FindBy(xpath = "//*[@id='selected_date']")
	WebElement lastRunServerDate;
	
	@FindBy(xpath = "//*[text()='Model' and @title='Model']")
	WebElement model;
	
	@FindBy(xpath = "//*[text()='Account Number' and @title='Account Number']")
	WebElement accountNumber;
	
	@FindBy(xpath = "//*[text()='Clear All']")
	WebElement clearAll;
	
	

	public ExposurePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickExposureTab() throws InterruptedException {
		// exposureTab.click();
		Thread.sleep(10000);
		//WebDriverWait wait = new WebDriverWait(driver, 1);
		String title = driver.getTitle();
		System.out.println("title++++" + title);
		System.out.println(exposureTab.isDisplayed());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", exposureTab);
		test.log(Status.INFO, "Clicked on Exposure Tab !!");

	}
	
	public void verifyAUMElement()
	{
		if(AUMelement.isDisplayed())
		{
			String text = driver.findElement(By.xpath("//*[text()='AUM']/following-sibling::span")).getText();
			System.out.println("AUM element is displayed !!");
			test.log(Status.INFO, "AUM element is displayed as : "  +text);
		}
		
		else
		{
			System.out.println("AUM element is not displayed !!");
			test.log(Status.INFO, "AUM element is not displayed !!");
		}
	}
	
	public void verifyAccountselement()
	{
		if(Accountselement.isDisplayed())
		{
			String text = driver.findElement(By.xpath("//*[text()='Accounts']/following-sibling::span")).getText();
			System.out.println("Accounts element is displayed !!");
			test.log(Status.INFO, "Accounts element is displayed as : "  +text);
		}
		
		else
		{
			System.out.println("Accounts element is not displayed !!");
			test.log(Status.INFO, "Accounts element is not displayed !!");
		}
	}
	
	
	public void verifyBIbutton()
	{
/*		if(BIbutton.isDisplayed())
		{*/
			BIbutton.click();
			System.out.println("BI account is selected !!");
			test.log(Status.INFO, "BI account is selected !!");
		//}
		
/*		else
		{
			System.out.println("BI account is not selected  !!");
			test.log(Status.INFO, "BI account is selected by default !!");
		}*/
	}
	
	public void verifyfilterICon()
	{
		if(filterICon.isDisplayed())
		{
			System.out.println("filterICon is displayed !!");
			test.log(Status.INFO, "filterICon is displayed !!");
			
		}
		
		else
		{
			System.out.println("filterICon is not displayed  !!");
			test.log(Status.INFO, "filterICon is not displayed !!");
		}
	}
	
	
	public void exposureSubTab()
	{
		if(exposureSubTab.isDisplayed())
		{
			System.out.println("exposureSubTab is displayed !!");
			test.log(Status.INFO, "exposureSubTab is displayed !!");
		}
		
		else
		{
			System.out.println("exposureSubTab is not displayed  !!");
			test.log(Status.INFO, "exposureSubTab is not displayed !!");
		}
	}
	
	public void searchSubTab()
	{
		if(searchSubTab.isDisplayed())
		{
			System.out.println("searchSubTab is displayed !!");
			test.log(Status.INFO, "searchSubTab is displayed !!");
		}
		
		else
		{
			System.out.println("searchSubTab is not displayed  !!");
			test.log(Status.INFO, "searchSubTab is not displayed !!");
			
		}
	}
	
	public void verifyBUKbutton() throws InterruptedException
	{
		//if(BUKbutton.isDisplayed())
	//	{
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			System.out.println("BUK Button is displayed ? "+BUKbutton.isDisplayed());
	        //WebElement element = wait.until(ExpectedConditions.visibilityOf(BUKbutton)); 
		Thread.sleep(5000);
	        BUKbutton.click();
			System.out.println("BUK account is selected !!");
			test.log(Status.INFO, "BUK account is displayed !!");
		//}
		
//	else
//		{
//			System.out.println("BUK account is not selected  !!");
//		}
	}
	
	public void lastRunServerDate()
	{
		if(lastRunServerDate.isDisplayed())
		{
			
			System.out.println("Report date is-->"+lastRunServerDate.getAttribute("day"));
			test.log(Status.INFO, "Report Published Date is:"+ lastRunServerDate.getAttribute("day"));
		}
		
	else
		{
			System.out.println("lastRunServerDate is not displayed !!");
		}
	}
	
	public void clickFilterIcon()
	{
		filterICon.click();
		test.log(Status.INFO, "filterICon is clicked !!");
		
	}
	 
	public void verifyModelElement()
	{
		if(model.isDisplayed())
		{
			String text = model.getText();
			
			if(text.equals("Model"))
			{
				System.out.println("Model is present in filter options");
				test.log(Status.INFO, "Model is present in filter options !!");
			}
			else
			{
				System.out.println("Model is not present in filter options");
				test.log(Status.INFO, "Model is not present in filter options !!");
			}
		
		}
		else
		{
			System.out.println("Model element is not displayed");
		}
	}
	
	
	public void verifyAccountNumberElement()
	{
		if(accountNumber.isDisplayed())
		{
			String text = accountNumber.getText();
			
			if(text.equals("Account Number"))
			{
				System.out.println("Account Number is present in filter options");
				test.log(Status.INFO, "Account Number is present in filter options !!");
			}
			else
			{
				System.out.println("Account Number is not present in filter options");
				test.log(Status.INFO, "Account Number is not present in filter options !!");
			}
		
		}
		else
		{
			System.out.println("Account Number element is not displayed");
		}
	}
	
	public void clickModelElement()
	{
		model.click();
		test.log(Status.INFO, "Model Option is selected in filter options !!");
	}
	
	public void clickAccountNumberElement()
	{
		accountNumber.click();
		test.log(Status.INFO, "AccountNumber Option is selected in filter options !!");
	}
	
	public void clickClearAll()
	{
		clearAll.click();
		
	}
	public void clickSearchSubTab()
	{
		searchSubTab.click();
		
	}
	
}
