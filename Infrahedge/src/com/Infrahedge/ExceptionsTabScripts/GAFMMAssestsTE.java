package com.Infrahedge.ExceptionsTabScripts;

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

import com.Infrahedge.PomPages.ExceptionsPages.CharitiesMMTEPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPMMTEPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPMMVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPSAAVolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class GAFMMAssestsTE extends BaseTest {
	
	
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
       	columnList.add("RPF Weight");
       	columnList.add("SAA Selection");
       	columnList.add("SAA Allocation");
       	columnList.add("TAA Selection");
       	columnList.add("TAA Allocation");

 //Add Column names for Asset SubAsset for excel book	   
  	   webtableReader.addColumnAssetSubAssetSheet(sheetName,category ,kpi ,Pro,columnList);
  	   
  Thread.sleep(1000);
	driver.findElement(By.cssSelector("div.topLeftProgress")).click();
	List<WebElement> catRows = driver.findElements(By.xpath("//*[@id='QV019']//table/tbody/tr/td[1]"));
	System.out.println("Asset count="+catRows.size());
	// Get all the ranges
		List<WebElement> allRanges = driver.findElements(By.xpath("//div[@class='topLeftProgress']//*[contains(@class, 'progress-bar')]"));
	
	// Select all the ranges
	for (int j = 2; j >= 0; j--) {
		allRanges.get(j).click();
		Thread.sleep(2000);
		try{
	// getting all  values from  category
	for (int i=1; i<=catRows.size(); i++) {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[" + i + "]/td[2]"));

		element.click();

		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse']"));

		expandAll.click();
		Thread.sleep(1000);
		webtableReader.getAssetSubAssetwithCol(sheetName,category,columnList);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='MM'])[2]"));
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
	public void fecthMMssets() throws InterruptedException, IOException, AWTException {

		ValidLogin login = new ValidLogin();
		login.testLogin();
		// Click on the Vol progress bar
		IPMMTEPage ipMMTE = new IPMMTEPage(driver);
		Thread.sleep(2000);
		ipMMTE .clickMMButton();
		Thread.sleep(2000);
		ipMMTE .clickMMTEProgressbar(); 
		

		//KPI
		String kpi="TE";
		String category="MM";
//		String ip1="IP1";
//		readassetSubAssetValue(ip1,category,kpi);
	//	String ip2="IP2";
		//readassetSubAssetValue(ip2,category,kpi);
//		String ip3="IP3";
//		readassetSubAssetValue(ip3,category,kpi);
// 		String ip4="IP4";
//		readassetSubAssetValue(ip4,category,kpi);
//		String ip5="IP5";
//		readassetSubAssetValue(ip5,category,kpi);

		String Charities="GAF";
		readassetSubAssetValue(Charities,category,kpi);
		
//		click BREACH SUMMARY 		
			 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
			 Thread.sleep(2000);
	

	}

}
