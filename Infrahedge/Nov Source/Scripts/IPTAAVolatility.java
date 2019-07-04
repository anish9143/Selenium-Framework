package com.Infrahedge.Scripts;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.BreachSummaryPage;
import com.Infrahedge.PomPages.IPSAAVolatilityPage;
import com.Infrahedge.PomPages.IPTAAVolatilityPage;
import com.Infrahedge.PomPages.LogInPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.Library;

public class IPTAAVolatility extends BaseTest  {

	//public static  WebDriver driver;
	DatabaseConnectivity connect=new DatabaseConnectivity();
	@Test()
	
	public void fetch_IP_TAA_Vol() throws InterruptedException, IOException, AWTException
	{
		
		Thread.sleep(2000);
		
		//Click on the Vol progress bar
		 IPTAAVolatilityPage ipTAAVol= new IPTAAVolatilityPage(driver);
	     ipTAAVol.clicktAAVolProgressbar();
		
//	     WebElement progressBarSuccess = driver.findElement(By.xpath("//table/tbody[1]/tr/td[3]/div/div[1]"));
//		String percentageOfProgress = progressBarSuccess.getText();
//		System.out.println("percentage of progress is-->" + percentageOfProgress);
//		Thread.sleep(2000);
//		progressBarSuccess.click();
		
		Thread.sleep(2000);
		//Create excel work book
//		String wbname="VolatileUI";
//		Library.CreateNewWorkBook(wbname);
//		
		
 ArrayList<String> riskProfileList=new ArrayList<String>();
	     
	     riskProfileList.add("IP1");
	     riskProfileList.add("IP2");
	     riskProfileList.add("IP3");
	     riskProfileList.add("IP4");
	     riskProfileList.add("IP5");
	     
	     String TAA = "TAA";
		
		//Click on Vol and read write excel 
		Library.readWriteProfileCatagories(riskProfileList,TAA);
		Thread.sleep(1000);
		        
		 		//	click BREACH SUMMARY 		
		 driver.findElement(By.xpath("//*[text()='BREACH SUMMARY ']")).click();
		 Thread.sleep(2000);
//		 		
//		 		//Click on Var read write all risk profiles and categories
//		 driver.findElement(By.xpath("//table/tbody[2]/tr[1]/td[3]/div/div[1]")).click();
//		 Thread.sleep(2000);
//		 Library.readWriteProfileCatagories(riskProfileList);
//	
		//Asset sub asset level pages.
	//	readPortfolioAssetValue();
		//System.out.println("Next ");
	//	readSAAAssetSubAssetValue();
		

		
		
		
		

	}
	
	
}
 