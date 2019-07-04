package com.Infrahedge.Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.IPPortfolioVolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class PortfolioAssestsVolatility extends BaseTest {
	
	
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
   	   System.out.println("Clicked Pro");
  	  driver.findElement(By.cssSelector("div.topLeftProgress")).click(); 
   	   
  	 //Add column   in list
   	 ArrayList<String> columnList=new ArrayList<String>();
	   	columnList.add(category+" Values");
	 	columnList.add("Asset");
	 	columnList.add("Portfolio Weight");
	 	columnList.add("Portfolio Volatility");
	 	columnList.add("Portfolio CVOL");
 //Add Column names for Asset SubAsset for excel book	   
    	   webtableReader.addColumnAssetSubAssetSheet(sheetName,category ,kpi ,Pro,columnList);
  	   
  Thread.sleep(1000);
	driver.findElement(By.cssSelector("div.topLeftProgress")).click();
	List<WebElement> PortfolioRows = driver.findElements(By.xpath("//*[@id='QV019']//table/tbody/tr/td[1]"));
	System.out.println("Asset count="+PortfolioRows.size());
	
	// Get all the ranges
			List<WebElement> allRanges = driver.findElements(By.xpath("//div[@class='topLeftProgress']//*[contains(@class, 'progress-bar')]"));

		// Select all the ranges
		for (int j = 2; j >= 0; j--) {
			allRanges.get(j).click();
			Thread.sleep(2000);
			try{

				// getting all Portfolio values from Portfolio category
				for (int i=1; i<=PortfolioRows.size(); i++) {
					Thread.sleep(2000);
					WebElement PortfolioElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[" + i + "]/td[4]"));
			
					PortfolioElement.click();
			
					Thread.sleep(5000);
					WebElement expandAll = driver
							.findElement(By.xpath("//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse']"));
			
					expandAll.click();
					Thread.sleep(1000);
					webtableReader.getAssetSubAssetwithCol(sheetName,category,columnList);
			
					// navigates to previous page
					WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Portfolio'])[2]"));
					assetDropDown.click();
			
					Thread.sleep(2000);
				   	//driver.findElement(By.xpath("//div[@class='col-md-4 pageNav']/div[1]")).click();
					driver.findElement(By.cssSelector("div.topLeftProgress")).click();
					System.out.println("CSS WOrks");
					Thread.sleep(2000);
			
				}
			}
			catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("No data present in the webtable");
			} 
		}	
	
}


	@Test
	public void fecthPortfolioAssets() throws InterruptedException, IOException, AWTException {

		//Click on the Vol progress bar
		 IPPortfolioVolatilityPage ipPortfolioVol= new IPPortfolioVolatilityPage(driver);
	     ipPortfolioVol.clickPortfolioVolProgressbar();

		

		//KPI
		String kpi="Volatility";
		String category="Portfolio";
//		String ip1="IP1";
//		readassetSubAssetValue(ip1,category,kpi);
		String ip2="IP2";
		readassetSubAssetValue(ip2,category,kpi);
//		String ip3="IP3";
//		readassetSubAssetValue(ip3,category,kpi);
// 		String ip4="IP4";
//		readassetSubAssetValue(ip4,category,kpi);
//		String ip5="IP5";
//		readassetSubAssetValue(ip5,category,kpi);

		
		
//		click BREACH SUMMARY 		
			 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
			 Thread.sleep(2000);
	

	}

}
