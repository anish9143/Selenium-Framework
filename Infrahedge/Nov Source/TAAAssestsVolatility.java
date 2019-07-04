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

import com.Infrahedge.PomPages.IPTAAVolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class TAAAssestsVolatility extends BaseTest {
	
	
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
	      	columnList.add("TAA Weight");
	      	columnList.add("TAA Volatility");
	      	columnList.add("TAA CVOL");
 //Add Column names for Asset SubAsset for excel book	   
	       	   webtableReader.addColumnAssetSubAssetSheet(sheetName,category ,kpi ,Pro,columnList);
  	   
  Thread.sleep(1000);
	driver.findElement(By.cssSelector("div.topLeftProgress")).click();
	List<WebElement> TAARows = driver.findElements(By.xpath("//*[@id='QV019']//table/tbody/tr/td[1]"));
	System.out.println("Asset count="+TAARows.size());
	
	// Get all the ranges
			List<WebElement> allRanges = driver.findElements(By.xpath("//div[@class='topLeftProgress']//*[contains(@class, 'progress-bar')]"));

		// Select all the ranges
		for (int j = 2; j >= 0; j--) {
			allRanges.get(j).click();
			Thread.sleep(2000);
			try{

				// getting all TAA values from TAA category
				for (int i=1; i<=TAARows.size(); i++) {
					Thread.sleep(2000);
					WebElement TAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[" + i + "]/td[2]"));
			
					TAAElement.click();
			
					Thread.sleep(5000);
					WebElement expandAll = driver
							.findElement(By.xpath("//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse']"));
			
					expandAll.click();
					Thread.sleep(1000);
					webtableReader.getAssetSubAssetwithCol(sheetName,category,columnList);
			
					// navigates to previous page
					WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='TAA'])[2]"));
					assetDropDown.click();
			
					Thread.sleep(2000);
					driver.findElement(By.cssSelector("div.topLeftProgress")).click();
					Thread.sleep(2000);
			
				}
	  
			//For scroll
			
			try{
			
				int count=1;
				WebElement secondLastElement = driver
						.findElement(By.xpath("//table/tbody/tr[18]/td[2]/div/div/span"));
				String text17=secondLastElement.getText();
				System.out.println("secondLastElement--"+text17);
				for(int s=1;s<=count;s++){
					WebElement scrollBar = driver.findElement(By.xpath(
							"//div[@class='scrollbar-animation scrollbar-track ng-scope ng-isolate-scope vertical']//div[starts-with(@class,'scrollbar-thumb')]"));
					Actions actions = new Actions(driver);
					actions.moveToElement(scrollBar).build().perform();
					actions.click(scrollBar).build().perform();
					Robot robot = new Robot();
					System.out.println("Key down");
					for(int k=1;k<=count;k++){
						Thread.sleep(1000);
						robot.keyPress(KeyEvent.VK_DOWN);
						System.out.println("Scroll arrow down key pressed");
					}
					// scrollBar.isEnabled();
						WebElement LastElement = driver
							.findElement(By.xpath("//table/tbody/tr[18]/td[2]/div/div/span"));
					String text18 = LastElement.getText();
					System.out.println("last number----" + text18);
					
					if (text17 != text18) {
						System.out.println("Scrolled number " + count);
						Thread.sleep(2000);
						WebElement PortfolioElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[18]/td[2]"));
						PortfolioElement.click();
				
						Thread.sleep(6000);
						WebElement expandAll = driver
								.findElement(By.xpath("//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse']"));
				
						expandAll.click();
						Thread.sleep(1000);
						webtableReader.getAssetSubAssetwithCol(sheetName,category,columnList);
				
						// navigates to previous page
						WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='TAA'])[2]"));
						assetDropDown.click();
				
						Thread.sleep(2000);
						driver.findElement(By.cssSelector("div.topLeftProgress")).click();
						Thread.sleep(2000);		
						count++;
						System.out.println("Last Number ---" + text18);
						text17 = text18;

					}

					else {
						System.out.println("Scroll completed breaked on matching values");
						break;
					}
					
				}
			}
			finally{
				System.out.println("No data present in the webtable");

			}
				
			}

		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("No data present in the webtable");
		} 
	}		
}


	@Test
	public void fecthTAAAssets() throws InterruptedException, IOException, AWTException {

		//Click on the Vol progress bar
		 IPTAAVolatilityPage ipTAAVol= new IPTAAVolatilityPage(driver);
	     ipTAAVol.clicktAAVolProgressbar();

		

		//KPI
		String kpi="Volatility";
		String category="TAA";
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
