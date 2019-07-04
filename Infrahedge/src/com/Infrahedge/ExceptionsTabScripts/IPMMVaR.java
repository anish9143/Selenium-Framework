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
import com.Infrahedge.PomPages.ExceptionsPages.IPMMVaRPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPMMVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPSAAVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPTAAVolatilityPage;
import com.Infrahedge.generic.BaseTest;
//import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.Library;

public class IPMMVaR extends BaseTest  {


	@Test()
	
	public void fetch_IP_Model_Vol() throws InterruptedException, IOException, AWTException
	{
		
		ValidLogin login = new ValidLogin();
		login.testLogin();
		
		//Click on the Vol progress bar
		IPMMVaRPage ipMMVaR = new IPMMVaRPage(driver);
		Thread.sleep(2000);
		//ipMMVaR .clickMMButton();
		Thread.sleep(2000);
		ipMMVaR .clickMMVaRProgressbar(); 

		
		Thread.sleep(2000);
	
		
 ArrayList<String> riskProfileList=new ArrayList<String>();
	     
	     riskProfileList.add("IP1");
	     riskProfileList.add("IP2");
	     riskProfileList.add("IP3");
	     riskProfileList.add("IP4");
	     riskProfileList.add("IP5");
	     riskProfileList.add("Dynamic");

	     
	     String Model = "Model";
		
		//Click on Vol and read write excel 
		Library.readWriteProfileCategories(riskProfileList,Model);
		Thread.sleep(1000);
		        
		 		//	click BREACH SUMMARY 		
		 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		 Thread.sleep(2000);

		

		
		
		
		

	}
	
	
}
 