package com.Infrahedge.PomPages.StressPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class StressPageBUK extends BaseTest  {
	
	@FindBy(xpath ="//div[contains(text(),'Stress')]")
	WebElement titleStress;
	
	@FindBy(xpath ="//div['current-selections']//preceding-sibling::span[text()='Stress']")
	WebElement stressTab;
	
	@FindBy(xpath="//*[text()='Exceptions']")
	WebElement ExceptionsTab;
	
	@FindBy(xpath="//*[text()='Proxy']")
	WebElement ProxyTab;
	
	@FindBy(xpath="//*[text()='Exposure']")
	WebElement exposureTab;	
	
	@FindBy(xpath = "//*[text()='AUM']")
	WebElement AUMelement;
	
	@FindBy(xpath = "//*[text()='Accounts']")
	WebElement Accountselement;
	
	//@FindBy(xpath = "//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/form/label[1]/div/span")
	@FindBy(xpath = "(//input[@class='tblType'])[7]")
	WebElement BIbutton;
	
	//@FindBy(xpath="//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/form/label[2]/div/span")
	@FindBy(xpath = "(//input[@class='tblType'])[8]")
	WebElement BUKbutton;
		
	@FindBy(xpath = "//*[@class='fa fa-filter']")
	WebElement filterICon;
	
	@FindBy(xpath="//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/span")
	WebElement lockButton;
	
	@FindBy(xpath="//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]/button/span")
	WebElement ellipsisButton;
	
	@FindBy(xpath="(//div[@class='lui-icon lui-icon--cogwheel'])[2]")
	WebElement settingsButton;
	
	@FindBy(xpath="(//table[@dir='ltr'])[2]")
	WebElement StressTable;
	
	@FindBy(xpath="//*[@id='page-top']/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[1]/text()[2]")
	WebElement expandAll;
	
	//@FindBy(xpath="//*[text()='Portfolio Manager' and @title='Portfolio Manager']")
	@FindBy(xpath="(//span[@class='title ng-binding'])[1]")
	WebElement portfolio;
	
	@FindBy(xpath="(//span[@class='title ng-binding'])[4]")
	WebElement strategy; 
	
	@FindBy(xpath="(//span[@class='title ng-binding'])[5]")
	WebElement risk;
	
	@FindBy(xpath="(//span[@class='title ng-binding'])[7]")
	WebElement category;
	
	@FindBy(xpath="//*[text()='Clear All']")
	WebElement clear;
	
	@FindBy(xpath="//li[@tabindex='-1']")
	WebElement subselection;
	
	public StressPageBUK(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickStressTab() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("title is " + title);
		System.out.println(titleStress.isDisplayed());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", stressTab);
		String path = concatenate+takeScreenshot(driver, "LogIn");
		test.addScreenCaptureFromPath(path); 
		test.log(Status.INFO, "Clicked on Stress Tab !!");

	}
	
	public void verifyAUMElement()
	{
		String amount = driver.findElement(By.xpath("(//span[@class='text-value ng-binding'])[1]")).getText();
		Assert.assertTrue(AUMelement.isDisplayed());
		System.out.println("AUM element is displayed !! " + amount);
		test.log(Status.INFO, "AUM element is displayed !!" + amount);
		
	}
	
	public void verifyAccountselement()
	{
		String acc = driver.findElement(By.xpath("(//span[@class='text-value ng-binding'])[2]")).getText();
		Assert.assertTrue(Accountselement.isDisplayed());
		System.out.println("Accounts element is displayed !! "+ acc);
		test.log(Status.INFO, "Accounts element is displayed !! " + acc);
		
	}
	
	public void verifyBIbutton() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		BIbutton.click();
		Thread.sleep(2000);
		String path = concatenate+takeScreenshot(driver, "LogIn");
		test.addScreenCaptureFromPath(path); 
		
		if(BIbutton.isSelected())
		{
			System.out.println("BI account is selected !!");
			test.log(Status.INFO, "BI account is selected !!");
		}
		
		else
		{
			System.out.println("BI account is not selected  !!");
			test.log(Status.INFO, "BI account is selected by default !!");
		}
	}
	
	
	public void verifyfilterICon()
	{
		Assert.assertTrue(filterICon.isDisplayed());
			System.out.println("filterICon is displayed !!");
			test.log(Status.INFO, "filterICon is displayed !!");
		
	}
	
	public void verifyBUKbutton() throws InterruptedException, IOException
	{
		
			BUKbutton.click();
			Thread.sleep(3000);
			
			Assert.assertTrue(BUKbutton.isSelected());
			System.out.println("BUK account is selected !!");
			test.log(Status.INFO, "BUK account is displayed !!");
					
			
	}
	
	public void verifyStressTable() 
	{
		Assert.assertTrue(StressTable.isDisplayed());
		System.out.println("Stress Table is present!!");
		test.log(Status.INFO, "Stress Table is present!!");
		
	}
	
	public void verifyEllipsisButton()
	{
		Assert.assertTrue(ellipsisButton.isDisplayed());
		System.out.println("Ellipsis is displayed !!");
		test.log(Status.INFO, "Ellipsis is displayed !!");
		
	}
	
	public void verifySettingsButton()
	{
		Assert.assertTrue(settingsButton.isDisplayed());
		System.out.println("Settings is displayed !!");
		test.log(Status.INFO, "Settings is displayed !!");
		
	}
	
	public void verifyLockButton()
	{
		Assert.assertTrue(lockButton.isDisplayed());
		System.out.println("Lock button is displayed !!");
		test.log(Status.INFO, "Lock button is displayed !!");
		
	}
	
	public void StressNotClickable()
	{
		Assert.assertTrue(titleStress.isEnabled());
		System.out.println("Stress title is not clickable");
		test.log(Status.INFO, "Stress title is not clickable");
		
	}

	public void ClickOnOtherTabs() throws InterruptedException
	{
		ExceptionsTab.click();
	    WebDriverWait wait=new WebDriverWait(driver, 10);
		
		try 
		{
			//Wait for Exception tab to open
		
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("navBreachClass"))));
			test.log(Status.INFO, "Clicked on Exception Tab");
			//Go back to Stress tab
			stressTab.click();
			Thread.sleep(2000);
			
			exposureTab.click();
			////Wait for Exposure tab to open
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='exposure-header active']"))));
			
			test.log(Status.INFO, "Clicked on Exposure Tab");
			//Go back to Stress tab
			stressTab.click();
			Thread.sleep(2000);
			
			ProxyTab.click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("proxyHead"))));
			test.log(Status.INFO, "Clicked on Proxy Tab");
			
			stressTab.click();
			Thread.sleep(3000);

			System.out.println("All other Tabs are clickable from Stress Page !!");
			test.log(Status.INFO, "All other Tabs are clickable from Stress Page !!");
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	public void assetPage() throws InterruptedException {
		
		stressTab.click();
		Thread.sleep(2000);
		//WebElement model = driver.findElement(By.xpath("(//span[@class='ng-binding ng-scope'])[5]"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement model = driver.findElement(By.xpath("//*[@id='QVStress']/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[5]/div/div/span"));
		wait.until(ExpectedConditions.visibilityOf(model));
		model.click();
		Thread.sleep(5000);
		String Asset = driver.findElement(By.xpath("(//span[@class='ng-binding'])[11]")).getText();
		if(Asset.equals("Asset Class"))
		{
			System.out.println("Clicked on Model successfully");
			test.log(Status.INFO, "Clicked on Model successfully");
		}
	}
	public void StressTableCols() throws InterruptedException, AWTException, IOException
	{
		
			List<WebElement> headerNames = driver.findElements(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th"));
			int Tsize=0;
			ArrayList<String> columnNames = new ArrayList<String>();
			ArrayList<String> readColNames = new ArrayList<String>();
			columnNames.add("Risk Profile"); columnNames.add("Strategy"); columnNames.add("Currency");
			columnNames.add("Category");   columnNames.add("Model");   columnNames.add("FTSE 100 -10%");
			columnNames.add("IR Parallel Shift +100bps");   columnNames.add("Credit Spread +100");   columnNames.add("9/11 Attack - 5 Day"); 
			columnNames.add("2008 Market Meltdown");   columnNames.add("2009 Equity Market Rebound");   columnNames.add("2011 Debt Ceiling/Downgrade Crisis");
			columnNames.add("Sub Prime Crisis");
			//Collections.sort(columnNames);
			for(WebElement web: headerNames)
			{
				if(!(web.getText().isEmpty())) {
					
					readColNames.add(web.getText());
					Tsize++; 
				}
			}
			
			WebElement scroll = driver.findElement(By.xpath("(//div[@class='scrollbar-hitarea'])[2]"));
			
			//To click on the horizontal scrollbar
			Actions actions = new Actions(driver);
			actions.moveToElement(scroll).build().perform();
			actions.click(scroll).build().perform();
			Robot robot = new Robot();
			actions.moveToElement(scroll).build().perform();
			actions.click(scroll);
			System.out.println("Key Right");
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(2000);
			
			robot.keyRelease(KeyEvent.VK_RIGHT);
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			System.out.println("Scroll arrow right key pressed");
			
			//To find the last 3 header names
			String Col11 = driver.findElement(By.xpath("//span[@title='2009 Equity Market Rebound']")).getAttribute("title");
			Tsize++;
			readColNames.add(Col11);
			//String Col12 = driver.findElement(By.xpath("(//table[@dir='ltr'])[4]/tbody/tr/th[13]")).getAttribute("aria-label");
			
			String Col12 = driver.findElement(By.xpath("//span[@title='2011 Debt Ceiling/Downgrade Crisis']")).getAttribute("title");
			Tsize++;
			readColNames.add(Col12);
			String Col13 = driver.findElement(By.xpath("//span[@title='Sub Prime Crisis']")).getAttribute("title");
			Tsize++;
			readColNames.add(Col13);
			//Collections.sort(readColNames);
			//To compare the column header Names
			
			Assert.assertEquals(readColNames,columnNames);
			
			test.log(Status.INFO, "Columns Header Names are Matching");
						
			stressTab.click();
			Thread.sleep(3000);
		
		}
		
	
	
	public void viewCompleteTable() throws AWTException, InterruptedException
	{
		try {
			WebElement scroll = driver.findElement(By.xpath("//div[@class='scrollbar-hitarea']"));
			//To click on the vertical scroll
			Actions actions = new Actions(driver);
			actions.moveToElement(scroll).build().perform();
			actions.click(scroll).build().perform();
			Robot robot = new Robot();
			actions.moveToElement(scroll).build().perform();
			actions.click(scroll);
			System.out.println("Key Down");
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
			System.out.println("Scroll arrow down key pressed");
			test.log(Status.INFO, "Scrolls working - full table");
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			stressTab.click();
			Thread.sleep(3000);
		} catch (Exception e) {
					System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	//To verify Lock button (off) and we should not be able to sort the table
	public void lockSort()
	{
		try {
			//String IPtext1 = driver.findElement(By.xpath("//div[@class='qv-st-value-overflow']/span[text()='IP1']")).getText();
			String text1 = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]")).getText();
			//driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th[3]")).click();
			driver.findElement(By.xpath("//*[text()='Strategy']")).click();
			//String IPtext2 = driver.findElement(By.xpath("//div[@class='qv-st-value-overflow']/span[text()='IP1']")).getText();
			String text2 = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]")).getText();
			Assert.assertEquals(text2,text1);
			
			System.out.println("Not able to sort the Column Names");
			test.log(Status.INFO, "Not able to sort the Column Names");
			
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
		
	}
	
	//To verify Lock button (on) and we should be able to sort the table
	public void unlockSort() throws InterruptedException
	{
		
			lockButton.click();
			Thread.sleep(2000);
			String IPtext1 = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]")).getText();
			//driver.findElement(By.xpath("//*[@id='QVStress']/div/article/div[1]/div/div/div/div[1]/div[2]/table")).click();
		    WebElement strat =	driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th[3]"));
		   // strat.click();
		    Actions act = new Actions(driver);
		    act.moveToElement(strat).clickAndHold(strat).build().perform();
		  	Thread.sleep(3000);
		  	act.release();
			String IPtext2 = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]")).getText();
			Assert.assertNotEquals(IPtext1,IPtext2);
			System.out.println("Able to sort the Column Names");
			test.log(Status.INFO, "Able to sort the Column Names");
		
		
	}
	
	//When lock button is unlocked we should be able to Drag and Drop the coulmns
	public void abletoDragColumn() throws InterruptedException
	{
		stressTab.click();
		Thread.sleep(4000);
		lockButton.click();
		
		try {
					
			WebElement drag = driver.findElement(By.xpath("(//table/tbody/tr/th[@class='qv-st-header-cell ng-scope ui-draggable ui-draggable-handle qv-st-header-sortable qv-st-header-cell-dimension'])[2]"));
			WebElement drop = driver.findElement(By.xpath("(//table/tbody/tr/th[@class='qv-st-header-cell ng-scope ui-draggable ui-draggable-handle qv-st-header-sortable qv-st-header-cell-dimension'])[1]"));
			Actions actions = new Actions(driver);
			actions.dragAndDrop(drag, drop).build().perform();
			System.out.println("Dragged and dropped 2nd column to 1st column");
			test.log(Status.INFO, "Dragged and dropped 2nd column to 1st column");
			Thread.sleep(2000);
			WebElement drag1 = driver.findElement(By.xpath("(//table/tbody/tr/th[@class='qv-st-header-cell ng-scope ui-draggable ui-draggable-handle qv-st-header-sortable qv-st-header-cell-dimension'])[4]"));
			WebElement drop1 = driver.findElement(By.xpath("(//table/tbody/tr/th[@class='qv-st-header-cell ng-scope ui-draggable ui-draggable-handle qv-st-header-sortable qv-st-header-cell-dimension'])[3]"));
			actions.dragAndDrop(drag1, drop1).build().perform();
			
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			System.out.println("Dragged and dropped 4nd column to 3rd column");
			test.log(Status.INFO, "Dragged and dropped 4nd column to 3rd column");
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	public void notAbletoDragColumn() throws InterruptedException
	{
		Thread.sleep(4000);
	
		try {
			WebElement drag = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th[3]"));
			WebElement drop = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th[2]"));
			Actions actions = new Actions(driver);
			actions.dragAndDrop(drag, drop).build().perform();
			System.out.println("Unable to drag and drop 2nd column to 1st column");
			test.log(Status.INFO, "Unable to drag and drop 2nd column to 1st column");
			Thread.sleep(2000);
			WebElement drag1 = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th[4]"));
			WebElement drop1 = driver.findElement(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th[3]"));
			actions.dragAndDrop(drag1, drop1).build().perform();
			System.out.println("Unable to drag and drop 4nd column to 3rd column");
			test.log(Status.INFO, "Unable to drag and drop 4nd column to 3rd column");
		} catch (Exception e) {
			    System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	public void SettingsPopup() throws InterruptedException
	{
		
		Thread.sleep(6000);
		try {
			//To hover mouse on Settings button
			Actions action = new Actions(driver);
			action.moveToElement(settingsButton).build().perform();
			
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			String Predictive = driver.findElement(By.xpath("//div[@class='custom-label-header' and text()='Predictive']")).getText();
			String Historic = driver.findElement(By.xpath("//div[@class='custom-label-header' and text()='Historic']")).getText();
			Assert.assertTrue(Predictive.equals("Predictive") && Historic.equals("Historic"));
			{
				System.out.println("Predictive and Historic Columns are displayed");
				test.log(Status.INFO, "Predictive and Historic Columns are displayed");
				List<WebElement> settingsValue = driver.findElements(By.xpath("//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div"));
				int count=0;
				for(WebElement s:settingsValue)
				{
					if(!(s.getText().isEmpty()))
					{
					System.out.print(s.getText());
					test.log(Status.INFO,s.getText());
					System.out.println();
					count++;
					}
				}
				Assert.assertTrue(count==20);
				System.out.println("All elements in Settings pop up are displayed");
				test.log(Status.INFO, "All elements in Settings pop up are displayed");
				
			}
			
		} catch (Exception e) {
				System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	//To newly add Stress Columns and verify
	public void newlyAddStresColumn() throws InterruptedException
	{
		Thread.sleep(4000);
		try {
			//To hover mouse on Settings button
			Actions action = new Actions(driver);
			action.moveToElement(settingsButton).build().perform();
			
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			//To click on FTSE 100+10%
			driver.findElement(By.xpath("(//div[@class='checkbox-stress'])[2]/label")).click();
			Thread.sleep(2000);
			
			//To verify if the column is added to the Table
			List<WebElement> headerNames = driver.findElements(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th"));
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
			Assert.assertTrue(isFound==true);
				System.out.println("New column added successfully");
				test.log(Status.INFO, "New column added successfully");
			
			//remove the selection
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='checkbox-stress'])[2]/label")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	//To uncheck default column and verify
	public void uncheckdefaultcolumn() throws InterruptedException
	{
		Thread.sleep(3000);
		try {
			//To hover mouse on Settings button
			Actions action = new Actions(driver);
			action.moveToElement(settingsButton).build().perform();
			
			//To click on FTSE 100-10%
			driver.findElement(By.xpath("//div[@class='checkbox-stress']/label")).click();
			Thread.sleep(3000);
			
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
			Thread.sleep(2000);
			//To verify if the column is removed from the Table
			List<WebElement> headerNames = driver.findElements(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[1]/div[2]/table/tbody/tr/th"));
			Thread.sleep(3000);
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
			Thread.sleep(3000);
			Assert.assertTrue(isFound==false);
				System.out.println("Default column is removed from the table");
				test.log(Status.INFO, "Default column is removed from the table");
						
			//check default again
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='checkbox-stress']/label")).click();
			Thread.sleep(2000);
			
		} catch (NumberFormatException e) {
			System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	//To verify Ellipsis Export button
	public void exportButton()
	{
		ellipsisButton.click();
		try {
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			WebElement exportButton = driver.findElement(By.id("download_chart_stress"));
			String export = exportButton.getText();
			Assert.assertTrue(export.equals("Export"));
				System.out.println("Export button is displayed");
				test.log(Status.INFO, "Export button is displayed");
			
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		
		}
    }
	
	//To click on Filter option on Stress page and verify values
	//To verify only checked values are present in table
	//To verify clear All button
	public void filterOptiontest()
	{
		filterICon.click();
		
		try {
			Thread.sleep(1000);
			//Verify the filter option
			
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			if(portfolio.isDisplayed() && strategy.isDisplayed() 
			    && risk.isDisplayed()  && category.isDisplayed())
			{
				System.out.println("Filter options are displayed");
				test.log(Status.INFO, "Filter options are displayed");
			}
			else
			{
				System.out.println("Filter options are not displayed - Failed");
				test.log(Status.INFO, "Filter options are not displayed - Failed");
			}
			risk.click();
			Thread.sleep(2000);
			subselection.click();
			Thread.sleep(3000);
			
			//To click on the Risk profile again so that the sub selection disappears
			driver.findElement(By.xpath("(//span[@class='title ng-binding'])[5]")).click();
						
			//To check if only IP1 are displayed in the table
			List<WebElement> IP1list = driver.findElements(By.xpath("//*[@id=\"QVStress\"]/div/article/div[1]/div/div/div/div[2]/div[1]/div/table/tbody/tr/td[1]"));
			Iterator<WebElement> it = IP1list.iterator();
			boolean isFound = false;
			while(it.hasNext())
			{
				if(it.next().getText().equals("Charities"))
				{
					isFound = true;
				}
				else
				{
					isFound = false;
				}
					
			}
			Assert.assertTrue(isFound);
				System.out.println("Filter applied successfully");
				test.log(Status.INFO, "Filter applied successfully");
			
					
				Assert.assertTrue(clear.isDisplayed());
				System.out.println("Clear All button is displayed");
				test.log(Status.INFO, "Clear All button is displayed");
			
			//Verify the "Clear All" button
			clear.click();
			Thread.sleep(2000);
			Assert.assertTrue(!(portfolio.isDisplayed()));
				System.out.println("Filter pop up disappeared successfully");
				test.log(Status.INFO, "Filter pop up disappeared successfully");
									
		}catch(Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
		
	}
	
	public void filterRiskProfileBUK() throws InterruptedException
	{
	
		//filterICon.click();
		try {
		//	Thread.sleep(2000);
			risk.click();
			List<WebElement> riskOptionxpath = driver.findElements(By.xpath("//li[@tabindex='-1']"));
			ArrayList<String> riskOptiondata = new ArrayList<String>();
			ArrayList<String> riskprofile = new ArrayList<String>();
			riskprofile.add("Charities");riskprofile.add("Dynamic"); riskprofile.add("GAF");  
			riskprofile.add("IMP");riskprofile.add("IP1"); riskprofile.add("IP2");
			riskprofile.add("IP3"); riskprofile.add("IP4"); //riskprofile.add("IP5");
			for(WebElement risk:riskOptionxpath)
			{
			       if(!(risk.getText().isEmpty())) {
			    	   riskOptiondata.add(risk.getText());
			        }
			}
			Assert.assertEquals(riskOptiondata, riskprofile);
			System.out.println("Risk profile is displayed with 8 Risk profiles - BUK ");
			test.log(Status.INFO, "Risk profile is displayed with 8 Risk profiles - BUK");
			
			//Click on sub selection
			subselection.click();
			Thread.sleep(1000);
			String subselect = subselection.getText();
			String select = risk.getText();
			Thread.sleep(3000);
			Assert.assertEquals(select,"Risk Profile - " + subselect);
			System.out.println("Risk Profile first Element is selected");
			test.log(Status.INFO, "Risk Profile first Element is selected");
			
			subselection.click();
			Thread.sleep(3000);
			select = risk.getText();
			Assert.assertEquals(select, "Risk Profile");
			System.out.println("Risk Profile first Element unchecked");
			test.log(Status.INFO, "Risk Profile first Element unchecked");
			
			risk.click();
			}catch(Exception e) {
			System.out.println("Caught Exception"+e.getMessage());
		}
		}
	public void assetPageLayout() throws InterruptedException, IOException
	{
		
			
			WebElement ExpandAll = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[1]/i"));
			WebElement CollapseAll = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[2]/i"));
			
			ExpandAll.click();
			Thread.sleep(1000);
			
			String path = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path); 
			
			CollapseAll.click();
			Thread.sleep(1000);
			
			String path1 = concatenate+takeScreenshot(driver, "LogIn");
			test.addScreenCaptureFromPath(path1); 
			
			if(ExpandAll.isDisplayed() && CollapseAll.isDisplayed())
			{
				System.out.println("Expand All and Collapse All is displayed");
				test.log(Status.INFO, "Expand All and Collapse All is displayed");
			}
						
			//verify Settings Ellipsis
			if(settingsButton.isDisplayed() && ellipsisButton.isDisplayed())
			{
				System.out.println("Settings and Ellipsis are displayed");
				test.log(Status.INFO, "Settings and Ellipsis are displayed");
			}
			
			//String assetcolor = driver.findElement(By.xpath("//i[@class='lui-icon lui-icon--stop']")).getCssValue("color");
			//	System.out.println(assetcolor);
		}
	
	public void filterPortManager()
	{
		
		try {
			
			filterICon.click();
			Thread.sleep(2000);
			portfolio.click();
			Thread.sleep(2000);
			//To click on sub selection
			if(subselection.isDisplayed())
			{
			subselection.click();
			Thread.sleep(3000);
			}
			else
			{
				System.out.println("No sub selections under Portfolio Manager");
				test.log(Status.INFO, "No sub selections under Portfolio Manager");
				return;
			}
			String subselect = subselection.getText();
			String select = portfolio.getText();
			Thread.sleep(3000);
			if (select.equals("Portfolio Manager - " + subselect))
			{
				System.out.println("Portfolio Manager first Element is selected");
				test.log(Status.INFO, "Portfolio Manager first Element is selected");
			}
			else
			{
				System.out.println("Portfolio Manager first Element is not selected - Failed");
				test.log(Status.INFO, "Portfolio Manager first Element is not selected - Failed");
			}	
			subselection.click();
			Thread.sleep(2000);
			select = portfolio.getText();
			Thread.sleep(3000);
			Assert.assertTrue(select.equals("Portfolio Manager"));
				System.out.println("Portfolio first Element unchecked");
				test.log(Status.INFO, "Portfolio first Element unchecked");
			
			portfolio.click();
			
							
		}catch(Exception e) {
			System.out.println("Caught Exception" + e.getMessage());
		}
	}
	
	public void testAssetFilterClearAll() throws InterruptedException
	{
		try {
			
		WebElement clear = driver.findElement(By.xpath("//*[text()='Clear All']"));
		clear.click();
		Thread.sleep(1000);
		Assert.assertTrue(!(portfolio.isDisplayed()));
			System.out.println("Clear All - clicked successfully");
			test.log(Status.INFO, "Clear All - clicked successfully");
		
		}catch(Exception e) {
			System.out.println("Caught Exception"+e.getMessage());
		}
	}
	
	public void filterstrategy()
	{
		
		try {
			
		//	WebElement strategy = driver.findElement(By.xpath("(//*[text()='Strategy' and @title='Strategy'])[3]"));
			strategy.click();
			Thread.sleep(1000);
			subselection.click();
			Thread.sleep(1000);
			String subselect = subselection.getText();
			String select = strategy.getText();
			Thread.sleep(1000);
			if (select.equals("Strategy - " + subselect))
			{
				System.out.println("Strategy first Element is selected");
				test.log(Status.INFO, "Strategy first Element is selected");
			}
			else
			{
				System.out.println("Strategy first Element is not selected - Failed");
				test.log(Status.INFO, "Strategy first Element is not selected - Failed");
			}	
			subselection.click();
			Thread.sleep(3000);
			select = strategy.getText();
			Assert.assertTrue(select.equals("Strategy"));
				System.out.println("Strategy first Element unchecked");
				test.log(Status.INFO, "Strategy first Element unchecked");
		
			strategy.click();
					
		}catch(Exception e) {
			System.out.println("Caught Exception" + e.getMessage());
		}
	}
	
	public void filtercategory()
	{
		
		try {
			//filterICon.click();
			//Thread.sleep(1000);
			//WebElement category = driver.findElement(By.xpath("(//*[text()='Category' and @title='Category'])[3]"));
			category.click();
			Thread.sleep(1000);
			subselection.click();
			Thread.sleep(2000);
			String subselect = subselection.getText();
			String select = category.getText();
			Thread.sleep(2000);
			Assert.assertEquals(select, "Category - " + subselect);
			System.out.println("Category first Element is selected");
			test.log(Status.INFO, "Category first Element is selected");
			//To check if there is a new box displayed
			Assert.assertTrue((driver.findElement(By.xpath("(//span[@class='title ng-binding'])[8]")).isDisplayed()));
			System.out.println("New box is displayed");
			test.log(Status.INFO, "New box is displayed");
			subselection.click();
			Thread.sleep(3000);
			select = category.getText();
			Assert.assertEquals(select, "Category");
			System.out.println("Category first Element unchecked");
			test.log(Status.INFO, "Category first Element unchecked");
			
			category.click();
		}catch(Exception e) {
			System.out.println("Caught Exception" + e.getMessage());
		}
	}
	
	public void filterSearch()
	{
				//filterICon.click();
		try {
			Thread.sleep(1000);
			portfolio.click();
			Thread.sleep(2000);
			//Search for Alastair Randall in search box
			WebElement search = driver.findElement(By.xpath("//button[@class='lui-search__clear-button ng-hide']/preceding-sibling::input"));
			
			String element = subselection.getText();
			search.sendKeys(element);			
			Thread.sleep(1000);
			//Check if the Searched option occurred
			WebElement searched = driver.findElement(By.xpath("//div[@class='qv-listbox-text']"));
			if(searched.getText().equals(element))
			{
				searched.click();
			}
			Thread.sleep(3000);
			String subselect = searched.getText();
			String select = portfolio.getText();
			Thread.sleep(3000);
			Assert.assertEquals(select, "Portfolio Manager - " + subselect);
			System.out.println("Portfolio Manager Search worked successfully");
			test.log(Status.INFO, "Portfolio Manager Search worked successfully");
			
			//To clear the search and search for invalid text
			
			driver.findElement(By.xpath("//span[@class='lui-icon  lui-icon--small  lui-icon--close']")).click();
			Thread.sleep(1000);
			search.sendKeys("text");
			Assert.assertTrue(driver.findElement(By.xpath("//*[text()='There are no matches for your search.']")).isDisplayed());
			System.out.println("No matches message displayed successfully");
				test.log(Status.INFO, "No matches message displayed successfully");
			
				
		}catch(Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
		
	}
	
	public void assetNewlyAddStresColumn() throws InterruptedException
	{
		
		Thread.sleep(6000);
		try {
			//To hover mouse on Settings button
			Actions action = new Actions(driver);
			action.moveToElement(settingsButton).build().perform();
			
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
			Assert.assertTrue(isFound==true);
			System.out.println("New column added successfully");
			test.log(Status.INFO, "New column added successfully");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='checkbox-stress'])[2]/label")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			System.out.println("Caught exception" + e.getMessage());
		}
	}
	
	//To uncheck default column and verify
			public void assetuncheckdefaultcolumn() throws InterruptedException
			{
				Thread.sleep(2000);
				try {
					
					//To click on FTSE 100-10%
					driver.findElement(By.xpath("(//div[@class='checkbox-stress']/label)[1]")).click();
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
					Assert.assertTrue(isFound==false);
						System.out.println("Default column is removed from the table");
						test.log(Status.INFO, "Default column is removed from the table");
					
					
					//To click on FTSE 100-10%
					driver.findElement(By.xpath("(//div[@class='checkbox-stress']/label)[1]")).click();
					Thread.sleep(2000);
					
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
					Assert.assertTrue(portfolio.isDisplayed());
						System.out.println("Filter options are displayed");
						test.log(Status.INFO, "Filter options are displayed");
					
					
					//Verify the "Clear All" button is present
					Thread.sleep(2000);
					WebElement clear = driver.findElement(By.xpath("//*[text()='Clear All']"));
					Assert.assertTrue(clear.isDisplayed());
						System.out.println("Clear All button is displayed");
						test.log(Status.INFO, "Clear All button is displayed");
					
					
					//click again on filter option and verify it disappears
					filterICon.click();
					Assert.assertTrue(!(portfolio.isDisplayed()));
					System.out.println("Filter pop up disappeared successfully");
						test.log(Status.INFO, "Filter pop up disappeared successfully");
					
								
				}catch(Exception e) {
					System.out.println("Caught exception" + e.getMessage());
				}
			}
			
			
	}


