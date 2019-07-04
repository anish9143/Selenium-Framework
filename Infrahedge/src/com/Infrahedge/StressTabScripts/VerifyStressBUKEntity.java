package com.Infrahedge.StressTabScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Infrahedge.ExceptionsTabScripts.ValidLogin;
import com.Infrahedge.PomPages.StressPages.StressAssetPage;
import com.Infrahedge.PomPages.StressPages.StressPageBUK;
import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class VerifyStressBUKEntity extends BaseTest {

StressPageBUK stressbuk = new StressPageBUK(driver);
StressAssetPage asset = new StressAssetPage(driver);
	
	ValidLogin login = new ValidLogin();
	
	@Test(priority = 0,description="BUK - Test LogIn Page")
		
		public void testLogin() throws InterruptedException, IOException, AWTException
		{
			login.testLogin();
		}
	
	@Test(priority = 1,description="BUK - Test Stress Link")
	public void testStressLink() throws InterruptedException, IOException 
	{
		stressbuk = new StressPageBUK(driver);
		stressbuk.clickStressTab();
				
	}
	@Test(priority = 2, description="Stress_01      BUK - Verify the Stress page layout \r"
								  + "Stress_20      BUK - Verify the presence of Ellipsis \r"
								  + "Stress_24      BI - Verify the display AUM and Accounts")
	public void testStresspageLayout( ) throws InterruptedException, IOException 
	{
		stressbuk.verifyBUKbutton();
		stressbuk.verifyStressTable();
		stressbuk.verifyAUMElement();
		stressbuk.verifyAccountselement();
		stressbuk.verifyLockButton();
		stressbuk.verifySettingsButton();
		stressbuk.verifyEllipsisButton();
	}

	@Test(priority = 3, description = "Stress_02      BUK - Verify Breadcrumb")
	public void testBUKStressNotClickable()
	{
		stressbuk.StressNotClickable();
		
	}
	
	@Test(priority = 4, description = "Stress_03      BUK - Verify that user is able to navigate to other tabs")
	public void testBUKOtherTabs() throws InterruptedException
	{
		stressbuk.ClickOnOtherTabs();
		
	}
	
	@Test(priority=5, description="Stress_12      BUK - Verify the scenarios displayed under \"Predective Event\" in settings popup\r"
			                     + "Stress_13      BUK - Verify the scenarios displayed under \"Historic Event\" in settings popup\r"
			                     + "Stress_15      BUK - Verify the order of arrangement of Scenarios in Settings popup\r"
			                     + "Stress_19      BUK - Verify the deselect functionality in Stress scenarios ")
	public void testBUKSettingsPopup() throws InterruptedException
	{
		stressbuk.SettingsPopup();
	}
	
	@Test(priority=6, description="Stress_17     BUK - Verify that user is able to add Stress scenarios ")
	public void testBUKAddedColumn() throws InterruptedException
	{
		stressbuk.newlyAddStresColumn();
	}
	
	@Test(priority=7, description="Stress_18      BUK - Verify the deselect functionality in Stress scenarios")
	public void testBUKDefaultCol() throws InterruptedException
	{
		stressbuk.uncheckdefaultcolumn();
	}
	
	@Test(priority=8, description="Stress_21     BUK - Verify the functionality of Export button")
	public void testBUKExportbutton()
	{
		stressbuk.exportButton();
	}
	
	@Test(priority=9, description = "Stress_25      BUK - Verify the filter button \r" + "\n"
									+"Stress_26      BUK - Verify filters displayed \r"
									+"Stress_32      BUK - Verify the functionality of Clear all button \r"
									+"Stress_35      BI - Verify the resulatant table after selecting a Risk profile")
	public void testBUKFilterButton()
	{
		stressbuk.filterOptiontest();
	}
		
	//Filter-Verify the Portfolio Managers displayed
	@Test(priority=10, description = "Stress_27      BUK - Verify the Portfolio Managers displayed")
	public void testBUKFilterPortManager() throws InterruptedException
	{
				
		stressbuk.filterPortManager();
	}
			
	@Test(priority=11, description = "Stress_28      BUK - Verify the Strategy displayed")
	public void testBUKFilterstrategy() throws InterruptedException
	{
		stressbuk.filterstrategy();
	}
	@Test(priority=12, description = "Stress_30      BUK - Verify the Risk profile displayed")
	public void testBUKFilterRP() throws InterruptedException
	{
		stressbuk.filterRiskProfileBUK();
	}
			
	@Test(priority=13, description = "Stress_31      BI - Verify the Category displayed \r"
			+ "Stress_37      BI - Verify the Category Filter option selection")
	public void testBUKFiltercategory() throws InterruptedException
	{
		stressbuk.filtercategory();
	}
			
		@Test(priority=14, description = "Stress_39,Stress_40      BI - Verify search option in filter")
		public void testBUKFiltersearch() throws InterruptedException
		{
			stressbuk.filterSearch();
		}
		
		
		@Test(priority=15, description = "Asset_01      BUK - Verify the Asset page")
		public void testBUKNavigateToAssetPage() throws InterruptedException
		{
			stressbuk.assetPage();
		}
		
		
		@Test(priority=16, description="Asset_07      BI - Verify the scenarios displayed under \"Predective Event\" in settings popup \r"
									 + "Asset_08      BI - Verify the scenarios displayed under \"Historic Event\" in settings popup \r"
									 + "Asset_10      BI - Verify the order of arrangement of Scenarios in Settings popup"	)
		public void testBUKAssetSettingsPopup() throws InterruptedException
		{
			
			stressbuk.SettingsPopup();
		}
		
		@Test(priority=17, description="Asset_15      BUK - Verify the presence of Ellipsis ")
		public void testBUKAssetEllipsisExport() throws InterruptedException
		{
			
			stressbuk.exportButton();
		}
		
		@Test(priority=18, description="Asset_12      BUK - Verify that user is able to add Stress scenarios ")
		public void testBUKAssetAddedColumn() throws InterruptedException
		{
			
			stressbuk.assetNewlyAddStresColumn();
		}
		
		@Test(priority=19, description="Asset_13      BUK - Verify the deselect functionality in Stress scenarios ")
		public void testBUKAssetDefaultCol() throws InterruptedException
		{
			stressbuk.assetuncheckdefaultcolumn();
		}
		
			
		@Test(priority=20, description = "Asset_24      BUK - Verify the filter button")
		public void testBUKAssetFilterButton()
		{
			
			stressbuk.assetfilterOptiontest();
		}
		
		@Test(priority=21, description = "Asset_02      BUK - Verify the Asset page layout \r" + 
				                         "Asset_18      BUK - Verify the Functionality of Expand  button \r" + 
										 "Asset_20      BUK - Verify the Functionality of Collapse  button \r")
		public void testBUKAssetPageLayout() throws InterruptedException, IOException
		{
			stressbuk.assetPageLayout();
		}
		
		@Test(priority=22, description = "Asset_26      BUK - Verify the Portfolio Managers displayed \r"
				                       + "Asset_28      BUK - Verify the resulatant table after selecting a Portfolio Manager \r"
				                       + "Asset_29      BUK - Verify the filter option deselection")
		public void testBUKFilterPortManagerAsset() throws InterruptedException, IOException
		{
			stressbuk.filterPortManager();
		}
		
		@Test(priority=23, description = "Asset_30      BUK - Verify search option in filter\n"
										+"Asset_31      BUK - Verify search option in filter")
		public void testBUKFilterSearch() throws InterruptedException
		{
			stressbuk.filterSearch();
		}
		
		@Test(priority=24, description = "Asset_27      BUK - Verify the functionality of Clear all button")
		public void testBUKFilterClearAll() throws InterruptedException
		{
			stressbuk.testAssetFilterClearAll();
		}
		
		
		
		@Test(priority=25, description = "Stress_06 - BUK - Verify that user is able to view the complete table using scroll")
		public void testBUKCompleteTable() throws AWTException, InterruptedException
		{
			stressbuk.viewCompleteTable();

		}
		
		@Test(priority=26, description="Stress_11      BUK - Verify that user is able to drag the columns")
		public void testBUKAbletoDragColumns() throws InterruptedException
		{
			stressbuk.abletoDragColumn();
		}
		
		@Test(priority=27, description="Stress_09      BUK - Verify that user is not able to drag the columns")
		public void testBUKNotAbletoDragCol() throws InterruptedException
		{
			stressbuk.notAbletoDragColumn();
			
		}
		
		@Test(priority=28, description = "Stress_04      BUK - Verify the columns in Stress table")
		public void testStressTableCol() throws InterruptedException, AWTException, IOException
		{
			stressbuk.StressTableCols();

		}
		@Test(priority = 29, description = "BUK - Close Application")
		public void closeApplication() throws InterruptedException {
			driver.quit();
			
			test.log(Status.INFO, "Browser is closed !!!");
		}
}
