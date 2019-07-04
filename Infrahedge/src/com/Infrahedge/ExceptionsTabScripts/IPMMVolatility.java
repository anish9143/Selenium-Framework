package com.Infrahedge.ExceptionsTabScripts;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Infrahedge.GenericPomPages.LogInPage;
import com.Infrahedge.PomPages.ExceptionsPages.ExceptionSummaryPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPMMVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPSAAVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPTAAVolatilityPage;
import com.Infrahedge.generic.BaseTest;
//import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.Library;

public class IPMMVolatility extends BaseTest  {


	@Test()
	
	public void fetch_IP_Model_Vol() throws InterruptedException, IOException, AWTException
	{
		
		ValidLogin login = new ValidLogin();
		login.testLogin();
		
		//Click on the Vol progress bar
		IPMMVolatilityPage ipMMVol = new IPMMVolatilityPage(driver);
		Thread.sleep(2000);
		///ipMMVol .clickMMButton();
		Thread.sleep(2000);
		ipMMVol .clickMMVolProgressbar(); 

		
		Thread.sleep(2000);
	
		
 ArrayList<String> riskProfileList=new ArrayList<String>();
	     
	     riskProfileList.add("IP1");
	     riskProfileList.add("IP2");
	     riskProfileList.add("IP3");
	     riskProfileList.add("IP4");
	     riskProfileList.add("IP5");
	     riskProfileList.add("Dynamic");
	     riskProfileList.add("Charities");
	     
	     String MM = "MM";
		
		//Click on Vol and read write excel 
		Library.readWriteProfileCategories(riskProfileList,MM);
		Thread.sleep(1000);
		        
		 		//	click BREACH SUMMARY 		
		 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		 Thread.sleep(2000);

		

		
		
		
		

	}
	
	
}
 