package com.Infrahedge.StressTabScripts;

import java.awt.AWTException;
import java.io.IOException;


import org.testng.annotations.Test;
import com.Infrahedge.ExceptionsTabScripts.ValidLogin;
import com.Infrahedge.PomPages.StressPages.StressAssetPage;
import com.Infrahedge.PomPages.StressPages.StressPage;
import com.aventstack.extentreports.Status;

public class VerifyStressBIEntity extends com.Infrahedge.generic.BaseTest{

	StressPage stress = new StressPage(driver);
	StressAssetPage asset = new StressAssetPage(driver);
	
	ValidLogin login = new ValidLogin();
	
	@Test(priority = 0,description="BI - Test LogIn Page")
		
		public void testLogin() throws InterruptedException, IOException, AWTException
		{
			login.testLogin();
		}

	@Test(priority = 1,description="BI - Test Stress Link")
	public void testStressLink() throws InterruptedException, IOException 
	{
		stress = new StressPage(driver);
		stress.clickStressTab();
		
	}
//	@Test(priority = 2, description="Stress_01      BI - Verify the Stress page layout \r"
//								+   "Stress_20      BI - Verify the presence of Ellipsis \r"
//								+   "Stress_24      BI - Verify the display AUM and Accounts")
//	public void testStressPageLayout( ) throws InterruptedException, IOException 
//	{
//		stress.verifyBIbutton();
//		stress.verifyStressTable();
//		stress.verifyAUMElement();
//		stress.verifyAccountselement();
//		stress.verifyLockButton();
//		stress.verifySettingsButton();
//		stress.verifyEllipsisButton();
//	}
//
//	
//	@Test(priority = 9, description = "Stress_02      BI - Verify Breadcrumb")
//	public void testStressNotClickable()
//	{
//		stress.StressNotClickable();
//		
//	}
//	
//	@Test(priority = 10, description = "Stress_03      BI - Verify that user is able to navigate to other tabs")
//	public void testOtherTabs() throws InterruptedException
//	{
//		stress.ClickOnOtherTabs();
//		
//	}
//	
//	
//	
//	/*@Test(priority=13, description= "Columns should not be able to sort when the Lock button is not applied")
//	public void verifyLockSort()
//	{
//		stress.lockSort();
//	
//	}
//
//	
//	@Test(priority=14, description= "Columns should be able to sort when the Lock button is applied")
//	public void verifyunLockSort() throws InterruptedException
//	{
//		stress.unlockSort();
//	 
//	}*/
//	
//
//	
//	@Test(priority=11, description="Stress_12      BI - Verify the scenarios displayed under \"Predective Event\" in settings popup \r"
//			                     + "Stress_13      BI - Verify the scenarios displayed under \"Historic Event\" in settings popup \r"
//			                     + "Stress_15      BI - Verify the order of arrangement of Scenarios in Settings popup \r"
//			                     + "Stress_19      BI - Verify the deselect functionality in Stress scenarios ")
//	public void testSettingsPopup() throws InterruptedException
//	{
//		stress.SettingsPopup();
//	}
//	
//	@Test(priority=12, description="Stress_17     BI - Verify that user is able to add Stress scenarios")
//	public void testAddedColumn() throws InterruptedException
//	{
//		stress.newlyAddStresColumn();
//	}
//	
//	@Test(priority=13, description="Stress_18      BI - Verify the deselect functionality in Stress scenarios")
//	public void testDefaultCol() throws InterruptedException
//	{
//		stress.uncheckdefaultcolumn();
//	}
//	
//	@Test(priority=14, description="Stress_21     BUK - Verify the functionality of Export button")
//	public void testExportButton()
//	{
//		stress.exportButton();
//	}
//	
//	@Test(priority=15, description = "Stress_25      BI - Verify the filter button \r"
//									+"Stress_26      BI - Verify filters displayed \r"
//									+"Stress_32      BI - Verify the functionality of Clear all button \r"
//									+"Stress_35      BI - Verify the resulatant table after selecting a Risk profile")
//	public void testFilterButton()
//	{
//		stress.filterOptiontest();
//	}
//	
//	//Filter-Verify the Portfolio Managers displayed
//		@Test(priority=16, description = "Stress_27      BI - Verify the Portfolio Managers displayed")
//		public void testFilterPortManager() throws InterruptedException
//		{
//			
//			stress.filterPortManager();
//		}
//		
//		@Test(priority=17, description = "Stress_28      BI - Verify the Strategy displayed")
//		public void testFilterstrategy() throws InterruptedException
//		{
//			stress.filterstrategy();
//		}
//		@Test(priority=18, description = "Stress_29      BI - Verify the Risk profile displayed")
//		public void testFilterRP()
//		{
//			stress.filterRiskProfile();
//		}
		
		@Test(priority=19, description = "Stress_31      BI - Verify the Category displayed"
									   + "Stress_37      BI - Verify the Category Filter option selection")
		public void testFiltercategory() throws InterruptedException
		{
			stress.filtercategory();
		}
		
//		@Test(priority=20, description = "Stress_39,Stress_40      BI - Verify search option in filter")
//									
//		public void testFiltersearch() throws InterruptedException
//		{
//			stress.filterSearch();
//		}
//	
//	
//	@Test(priority=21, description = "Asset_01      BI - Verify the Asset page")
//	public void testNavigateToAssetPage() throws InterruptedException
//	{
//		stress.assetPage();
//		}
//	
//	
//	@Test(priority=23, description="Asset page - Verify settings popup")
//	public void testAssetSettingsPopup() throws InterruptedException
//	{
//		
//		stress.SettingsPopup();
//	}
//	
//	@Test(priority=24, description="Asset_15      BI - Verify the presence of Ellipsis ")
//	public void testAssetEllipsisExport() throws InterruptedException
//	{
//		
//		stress.exportButton();
//	}
//	
//	@Test(priority=25, description="Asset_12      BI - Verify that user is able to add Stress scenarios ")
//	public void testAssetAddedColumn() throws InterruptedException
//	{
//		
//		stress.assetNewlyAddStresColumn();
//	}
//	
//	@Test(priority=26, description="Asset_13      BI - Verify the deselect functionality in Stress scenarios ")
//	public void testAssetDefaultCol() throws InterruptedException
//	{
//		stress.assetuncheckdefaultcolumn();
//	}
//	
//		
//	@Test(priority=27, description = "Asset_24      BUK - Verify the filter button")
//	public void testAssetFilterButton()
//	{
//		
//		stress.assetfilterOptiontest();
//	}
//	
//	@Test(priority=28, description = "Asset_02      BI - Verify the Asset page layout \r"
//									+"Asset_18      BI - Verify the Functionality of Expand  button \r"
//									+"Asset_20      BI - Verify the Functionality of Collapse  button")
//	public void testAssetPageLayout() throws InterruptedException, IOException
//	{
//		stress.assetPageLayout();
//	}
//	
//	@Test(priority=29, description = "Asset_26      BI - Verify the Portfolio Managers displayed \r"
//									+"Asset_28      BI - Verify the resulatant table after selecting a Portfolio Manager \r"
//									+"Asset_29      BI - Verify the filter option deselection")
//	public void testFilterPortManagerAsset() throws InterruptedException, IOException
//	{
//		stress.filterPortManager();
//	}
//	
//	@Test(priority=30, description = "Asset_30      BUK - Verify search option in filter \r" + 
//									 "Asset_31      BUK - Verify search option in filter")
//	public void testFilterSearch() throws InterruptedException
//	{
//		stress.filterSearch();
//	}
//	
//	@Test(priority=31, description = "Asset_27      BI - Verify the functionality of Clear all button")
//	public void testFilterClearAll() throws InterruptedException
//	{
//		stress.testAssetFilterClearAll();
//	}
//	
//	@Test(priority=32, description = "Stress_04      BI - Verify the columns in Stress table")
//	public void testStressTableCol() throws InterruptedException, AWTException, IOException
//	{
//		stress.StressTableCols();
//
//	}
//	
//	@Test(priority=33, description = "Stress_06 - BI - Verify that user is able to view the complete table using scroll")
//	public void testCompleteTable() throws AWTException, InterruptedException
//	{
//		stress.viewCompleteTable();
//
//	}
//	
//	@Test(priority=34, description="Stress_11      BI - Verify that user is able to drag the columns")
//	public void testAbletoDragColumns() throws InterruptedException
//	{
//		stress.abletoDragColumn();
//	}
//	
//	@Test(priority=35, description="Stress_09      BI - Verify that user is not able to drag the columns")
//	public void testNotAbletoDragColumns() throws InterruptedException
//	{
//		stress.notAbletoDragColumn();
//		
//	}
//	
//	@Test(priority = 36, description = "BI - Close Application")
//	public void closeApplication() throws InterruptedException {
//		driver.quit();
//		extent.flush();
//		
//		test.log(Status.INFO, "Browser is closed !!!");
//	}
		
}
