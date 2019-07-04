package com.Infrahedge.ExceptionsTabScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.ExceptionsPages.IPModelLiquidityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPPortfolioLiquidityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class IPPortfolioLiquidity extends BaseTest {

	

	@Test()
	
	public void fetch_IP_Portfolio_Liquidity() throws InterruptedException, IOException, AWTException
	{
	ValidLogin login = new ValidLogin();
	login.testLogin();
	Thread.sleep(4000);
	
	//Click on the Vol progress bar
	System.out.println("click on ProgressBar");
	
	IPPortfolioLiquidityPage ipModelLiquid= new IPPortfolioLiquidityPage(driver);
	 
	ipModelLiquid.clickportfolioLiquidityProgressbar();
	 
	
	Thread.sleep(2000);

	
ArrayList<String> riskProfileList=new ArrayList<String>();
      
     riskProfileList.add("IP1");
 //    riskProfileList.add("IP2");
//     riskProfileList.add("IP3");
//     riskProfileList.add("IP4");
//     riskProfileList.add("IP5");
//     riskProfileList.add("Dynamic");

     
     String Portfolio= "Liquidity";
	
	//Click on Vol and read write excel 
	Library.readWriteProfileCategories(riskProfileList,Portfolio);
	Thread.sleep(1000);
	        
	 		//	click BREACH SUMMARY 		
	 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
	 Thread.sleep(2000);
}
}