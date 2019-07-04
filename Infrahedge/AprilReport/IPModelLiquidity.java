package com.Infrahedge.Scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.IPModelLiquidityPage;
import com.Infrahedge.PomPages.IPModelVolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class IPModelLiquidity extends BaseTest {

	

	@Test()
	
	public void fetch_IP_Model_Liquidity() throws InterruptedException, IOException, AWTException
	{
	ValidLogin login = new ValidLogin();
	login.testLogin();
	Thread.sleep(2000);
	
	//Click on the Vol progress bar
	System.out.println("click on ProgressBar");
	
	IPModelLiquidityPage ipModelLiquid= new IPModelLiquidityPage(driver);
	 
	ipModelLiquid.clickmodelLiquidityProgressbar();
	 
	
	Thread.sleep(2000);

	
ArrayList<String> riskProfileList=new ArrayList<String>();
      
     riskProfileList.add("IP1");
 //    riskProfileList.add("IP2");
//     riskProfileList.add("IP3");
//     riskProfileList.add("IP4");
//     riskProfileList.add("IP5");
//     riskProfileList.add("Dynamic");

     
     String Model = "Liquidity";
	
	//Click on Vol and read write excel 
	Library.readWriteProfileCategories(riskProfileList,Model);
	Thread.sleep(1000);
	        
	 		//	click BREACH SUMMARY 		
	 driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
	 Thread.sleep(2000);
}
}