package com.Infrahedge.Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.IPModelVolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class ModelAssestsVolatility extends BaseTest {
	
	
	  public void readassetSubAssetValue(String Pro, String category ,String kpi) throws InterruptedException, AWTException{
			String sheetName=category+"Asset"+kpi+Pro;

			WebTable_Reader webtableReader = new WebTable_Reader();
		//Selecting Profiles dynamically
			Thread.sleep(2000);
			Library.clickProfileDropDown();
         Thread.sleep(2000);
  	   //click categories
  	   WebElement PRO = driver.findElement(By.xpath("//*[text()='"+Pro+"']"));
  	   PRO.click();
   	   Thread.sleep(2000);
  	   driver.findElement(By.cssSelector("div.topLeftProgress")).click(); 
  	   
  	 //Add column   in list
    	 ArrayList<String> columnList=new ArrayList<String>();
	    	columnList.add(category+" Values");
	      	columnList.add("Asset");
	      	columnList.add("Model Weight");
	      	columnList.add("Model Volatility");
	      	columnList.add("Model CVOL");
 //Add Column names for Asset SubAsset for excel book	   
	       	   webtableReader.addColumnAssetSubAssetSheet(sheetName,category ,kpi ,Pro,columnList);
  	   
  Thread.sleep(1000);
	driver.findElement(By.cssSelector("div.topLeftProgress")).click();
	List<WebElement> ModelRows = driver.findElements(By.xpath("//*[@id='QV019']//table/tbody/tr/td[1]"));
	System.out.println("Asset count="+ModelRows.size());
	
	// Get all the ranges
			List<WebElement> allRanges = driver.findElements(By.xpath("//div[@class='topLeftProgress']//*[contains(@class, 'progress-bar')]"));

		// Select all the ranges
		for (int j = 2; j >= 0; j--) {
			allRanges.get(j).click();
			Thread.sleep(2000);
			try{

				// getting all Model values from Model category
				for (int i=1; i<=ModelRows.size(); i++) {
					Thread.sleep(2000);
					WebElement ModelElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[" + i + "]/td[3]"));
			
					ModelElement.click();
			
					Thread.sleep(5000);
					WebElement expandAll = driver
							.findElement(By.xpath("//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse']"));
			
					expandAll.click();
					Thread.sleep(1000);
					webtableReader.getAssetSubAssetwithCol(sheetName,category,columnList);
			
					// navigates to previous page
					WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Model'])[2]"));
					assetDropDown.click();
			
					Thread.sleep(2000);
					driver.findElement(By.cssSelector("div.topLeftProgress")).click();
					Thread.sleep(2000);
			
				}
			}
			catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("No data present in the webtable");
			} 
		}	
	
}


	@Test
	public void fecthModelAssets() throws InterruptedException, IOException, AWTException {

		//Click on the Vol progress bar
		 IPModelVolatilityPage ipModelVol= new IPModelVolatilityPage(driver);
	     ipModelVol.clickModelVolProgressbar();

		

		//KPI
		String kpi="Volatility";
		String category="Model";
//		String ip1="IP1";
//		readassetSubAssetValue(ip1,category,kpi);
//		String ip2="IP2";
//		readassetSubAssetValue(ip2,category,kpi);
//		String ip3="IP3";
//		readassetSubAssetValue(ip3,category,kpi);
 		String ip4="IP4";
		readassetSubAssetValue(ip4,category,kpi);
//		String ip5="IP5";
//		readassetSubAssetValue(ip5,category,kpi);

		
		
//		click BREACH SUMMARY 		
		 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
			 Thread.sleep(2000);
	

	}

}
