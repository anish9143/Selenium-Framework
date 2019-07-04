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

import com.Infrahedge.PomPages.ExceptionSummaryPage;
import com.Infrahedge.PomPages.IPModelVolatilityPage;
import com.Infrahedge.PomPages.IPSAAVolatilityPage;
import com.Infrahedge.PomPages.IPTAAVolatilityPage;
import com.Infrahedge.PomPages.LogInPage;
import com.Infrahedge.generic.BaseTest;
//import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.Library;

public class IPModelVolatility extends BaseTest  {


	@Test()
	
	public void fetch_IP_Model_Vol() throws InterruptedException, IOException, AWTException
	{
		ValidLogin login = new ValidLogin();
		login.testLogin();
		Thread.sleep(4000);
		
		//Click on the Vol progress bar
		System.out.println("click on ProgressBar");
		
		 IPModelVolatilityPage ipModelVol= new IPModelVolatilityPage(driver);
		 
	     ipModelVol.clickModelVolProgressbar();
		 System.out.println("clicked on ProgressBar");
		
		Thread.sleep(2000); 
	
		
 ArrayList<String> riskProfileList=new ArrayList<String>();
	      
	     riskProfileList.add("IP1");
	     riskProfileList.add("IP2");
//	     riskProfileList.add("IP3");
//	     riskProfileList.add("IP4");
//	     riskProfileList.add("IP5");
//	     riskProfileList.add("Dynamic");

	     
	     String Model = "Model";
		
		//Click on Vol and read write excel 
		Library.readWriteProfileCategories(riskProfileList,Model);
		Thread.sleep(1000);
		        
		 		//	click BREACH SUMMARY 		
		 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		 Thread.sleep(2000);

		

		
		
		// fixed for new report
		

	}
	
	
}
 