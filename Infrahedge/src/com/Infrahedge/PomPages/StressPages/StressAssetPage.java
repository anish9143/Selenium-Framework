package com.Infrahedge.PomPages.StressPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;


			


public class StressAssetPage extends com.Infrahedge.generic.BaseTest{

	
	@FindBy(xpath="(//div[@class='lui-icon lui-icon--cogwheel'])[2]")
	WebElement assetsettingsButton;

	@FindBy(xpath = "//*[@class='fa fa-filter']")
	WebElement filterICon;
	
	@FindBy(xpath="b")
	WebElement expandAll;
	
	@FindBy(xpath="//*[@id='page-top']/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[2]/text()")
	WebElement collapseAll;
	
	@FindBy(xpath="//*[@id='page-top']/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]/button/span")
	WebElement ellipsisButton;
	
	@FindBy(xpath ="//div['current-selections']//preceding-sibling::span[text()='Stress']")
	WebElement stressTab;
	
		public StressAssetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
	
	public void assetPage() throws InterruptedException {
		//Click on the first Model
	//	stressTab.click();
	//	Thread.sleep(2000);
		//WebElement model = driver.findElement(By.xpath("(//span[@class='ng-binding ng-scope'])[5]"));
		WebElement model = driver.findElement(By.xpath("//*[@id='QVStress']/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[5]/div/div/span"));
		model.click();
		Thread.sleep(5000);
		String Asset = driver.findElement(By.xpath("(//span[@class='ng-binding'])[11]")).getText();
		if(Asset.equals("Asset Class"))
		{
			System.out.println("Clicked on Model successfully");
			test.log(Status.INFO, "Clicked on Model successfully");
		}
		
	}
	
	public void aumaccountValue() throws InterruptedException {
		try {
		Thread.sleep(2000);
		WebElement model = driver.findElement(By.xpath("(//span[@class='ng-binding ng-scope'])[5]"));
		model.click();
		Thread.sleep(2000);
		String aum = driver.findElement(By.xpath("//span[@class='text-value ng-binding']")).getText();
		String acc = driver.findElement(By.xpath("(//span[@class='text-value ng-binding'])[2]")).getText();
		Thread.sleep(2000);
		if(aum.equals("£ 0.00m") && acc.equals("0"))
		{
			System.out.println("AUM and Account Number displays 0");
			test.log(Status.INFO, "AUM and Account Number displays 0");
		}
		
		}catch(Exception e) {
			System.out.println("Caught Exception"+e.getMessage());
		}
	}
	
	//To newly add Stress Columns and verify
		public void assetNewlyAddStresColumn() throws InterruptedException
		{
			
			Thread.sleep(6000);
			try {
				//To hover mouse on Settings button
				Actions action = new Actions(driver);
				action.moveToElement(assetsettingsButton).build().perform();
				
				//To click on FTSE 100+10%
				driver.findElement(By.xpath("(//div[@class='checkbox-stress'])[2]/label")).click();
				Thread.sleep(2000);
				
				//To verify if the column is added to the Table
				List<WebElement> headerNames = driver.findElements(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/table/tbody/tr/th"));
				boolean isFound = false;
				for(WebElement ele : headerNames)
				{
					if(ele.getText().equals("FTSE 100 +10%"))
					{
						isFound = true;
						break;
					}
					else
					{
						isFound = false;
					}
				}
				if(isFound==true)
				{
					System.out.println("New column added successfully");
					test.log(Status.INFO, "New column added successfully");
				}
				
			} catch (Exception e) {
				System.out.println("Caught exception" + e.getMessage());
			}
		}
		
		//To uncheck default column and verify
		public void assetuncheckdefaultcolumn() throws InterruptedException
		{
			Thread.sleep(4000);
			try {
				//To hover mouse on Settings button
				Actions action = new Actions(driver);
				action.moveToElement(assetsettingsButton).build().perform();
				
				//To click on FTSE 100+10%
				driver.findElement(By.xpath("//div[@class='checkbox-stress']/label")).click();
				Thread.sleep(2000);
				
				//To verify the checkbox is unchecked
				String check = driver.findElement(By.xpath("//div[@class='checkbox-stress']/label/preceding-sibling::input")).getAttribute("ng-checked");
				if(Integer.parseInt(check)==0)
				{
					System.out.println("Default column is unchecked successfully");
					test.log(Status.INFO, "Default column is unchecked successfully");
				}
				else
				{
					System.out.println("Default column is not unchecked successfully");
					test.log(Status.INFO, "Default column is not unchecked successfully");
				}
				
				//To verify if the column is removed from the Table
				List<WebElement> headerNames = driver.findElements(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/table/tbody/tr/th"));
				boolean isFound = false;
				for(WebElement ele : headerNames)
				{
					if(!(ele.getText().equals("FTSE 100 -10%")))
					{
						isFound = false;
					}
					else
					{
						isFound = true;
						break;
					}
				}
				if(isFound==false)
				{
					System.out.println("Default column is removed from the table");
					test.log(Status.INFO, "Default column is removed from the table");
				}
				else
				{
					System.out.println("Default column is not removed from the table - Failed");
					test.log(Status.INFO, "Default column is not removed from the table - Failed");
				}
			} catch (NumberFormatException e) {
				System.out.println("Caught exception" + e.getMessage());
			}
		}
	
		//To click on Filter option on Stress page
		public void assetfilterOptiontest()
		{
			filterICon.click();
			try {
				
				WebElement portfolio = driver.findElement(By.xpath("//span[@title='Portfolio Manager']"));
				
				Thread.sleep(3000);
				//Verify the filter option
				if(portfolio.isDisplayed())
				{
					System.out.println("Filter options are displayed");
					test.log(Status.INFO, "Filter options are displayed");
				}
				else
				{
					System.out.println("Filter options are not displayed - Failed");
					test.log(Status.INFO, "Filter options are not displayed - Failed");
				}
				
				//Verify the "Clear All" button
				Thread.sleep(2000);
				WebElement clear = driver.findElement(By.xpath("//*[text()='Clear All']"));
				if(clear.isDisplayed())
				{
					System.out.println("Clear All button is displayed");
					test.log(Status.INFO, "Clear All button is displayed");
				}
				else
				{
					System.out.println("Clear All button is not displayed - Failed");
					test.log(Status.INFO, "Clear All button is not displayed - Failed");
				}
				
				//click again on filter option and verify it disappears
				filterICon.click();
				if(!(portfolio.isDisplayed()))
				{
					System.out.println("Filter pop up disappeared successfully");
					test.log(Status.INFO, "Filter pop up disappeared successfully");
				}
				else
				{
					test.log(Status.INFO, "Filter pop up did not disappearsuccessfully - Failed");
				}
							
			}catch(Exception e) {
				System.out.println("Caught exception" + e.getMessage());
			}
		}
		
		//verify Asset page layout
		public void assetPageLayout() throws InterruptedException
		{
			
				Thread.sleep(2000);
				WebElement model = driver.findElement(By.xpath("(//span[@class='ng-binding ng-scope'])[5]"));
				model.click();
				//Verify Expand All and Collapse All
				if(expandAll.isDisplayed())
				{
					System.out.println("Expand All and Collapse All is displayed");
					test.log(Status.INFO, "Expand All and Collapse All is displayed");
				}
				else
				{
					System.out.println("Expand All and Collapse All are not displayed - Failed");
					test.log(Status.INFO, "Expand All and Collapse All are not is displayed - Failed");
				}	
				
				//verify Settings Ellipsis
				if(assetsettingsButton.isDisplayed() && ellipsisButton.isDisplayed())
				{
					System.out.println("Settings and Ellipsis are displayed");
					test.log(Status.INFO, "Settings and Ellipsis are displayed");
				}
				else
				{
					System.out.println("Settings and Ellipsis are displayed - Failed");
					test.log(Status.INFO, "Settings and Ellipsis are displayed - Failed");
				}
				String assetcolor = driver.findElement(By.xpath("//i[@class='lui-icon lui-icon--stop']")).getCssValue("color");
					System.out.println(assetcolor);
			}
		}
	

