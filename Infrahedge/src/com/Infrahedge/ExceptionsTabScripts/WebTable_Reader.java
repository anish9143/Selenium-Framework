package com.Infrahedge.ExceptionsTabScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Infrahedge.GenericPomPages.LogInPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;
import com.Infrahedge.generic.Xls_Reader;

public class WebTable_Reader extends BaseTest {
	String text18;
	String text17;
	int excelRow;

	// Making it only initilaze the wb , add col name in excel
	public void WT_Reader() throws InterruptedException {

		com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);

		// Get sheet name
		Thread.sleep(3000);
		String sheetName = driver.findElement(By.cssSelector("div.col-md-8.navBarClass"))
				.getText();
		sheetName = (sheetName.replaceAll("[^a-zA-Z0-9]", "")).substring(17);
		System.out.println(sheetName + "#############");
		reader.addSheet(sheetName);

		// Fetch the total number of rows
		List rows = driver.findElements(By.xpath("//table/tbody[1]/tr"));
		System.out.println("No of rows are : " + rows.size());

		// Column number
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("******** COL NUM=" + columns.size());

		// Column names fetching dynamically
		List<String> colNames = new ArrayList<>();
		for (int i = 1; i<columns.size(); i++) {
			WebElement colName = driver.findElement(By.xpath("//table/tbody/tr[1]/th[" + i + "]"));
			if (!colName.getText().isEmpty()) {
				// Pass it column names
				System.out.println(colName.getText());
				colNames.add(colName.getText());
				reader.addColumn(sheetName, colName.getText());
			}
		}

	}

	public void readWebtableValues() {

		com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);

		// Get sheet name
		String sheetName = driver.findElement(By.cssSelector("div.col-md-8.navBarClass"))
				.getText();
			sheetName = (sheetName.replaceAll("[^a-zA-Z0-9]", "")).substring(17);
		System.out.println(sheetName + "========");

		// Fetch the total number of rows
		List rows = driver.findElements(By.xpath("//table/tbody[1]/tr"));
		System.out.println("No of rows are : " + rows.size());

		// Column number
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("******** COL NUM=" + columns.size());

		// Column names fetching dynamically
		List<String> colNames = new ArrayList<>();
		for (int i = 1; i < columns.size(); i++) {
			WebElement colName = driver.findElement(By.xpath("//table/tbody/tr[1]/th[" + i + "]"));
			if (!colName.getText().isEmpty()) {
				// Pass it column names
				System.out.println(colName.getText());
				colNames.add(colName.getText());
			}
		}

		// Fetching table values for selected Profile

		// Get last row
		int excelRow = reader.getRowCount(sheetName);
		System.out.println(excelRow);
		//excelRow++;
		for (int k = 1; k < rows.size()- 1; k++) {
			excelRow++;
			for (int j = 1; j <= colNames.size(); j++) {
				String colData = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[" + j + "]/div/div/span"))
						.getText();
				System.out.println(colData);
				reader.setCellData(sheetName, colNames.get(j - 1), excelRow, colData);

			}

			

		}

	}

	
	//Create Asset sheet and columns method
	
	// Add column for Asset SubAsset sheet
		public void addColumnAssetSubAssetSheet(String sheetName, String category, String kpi,
				String pro ,ArrayList<String> colNames){
			XSSFSheet sheet;
			com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);
			// if sheet exists do the below
					sheet = reader.workbook.getSheet(sheetName);
					if (sheet == null) {
						reader.addSheet(sheetName);
					} 
					
					System.out.println(sheetName);

					for (String col : colNames) {
						reader.addColumn(sheetName, col);
						System.out.println("coulmAdded in Excel--->"+col);
						
					}
			
		}
	

		// Get Asset Sub Asset values
				public void getAssetSubAssetwithCol(String sheetName,String category,ArrayList<String>columnList) throws InterruptedException, AWTException {
					// Asset and SubAsset names fetching dynamically
					com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);
					

					ArrayList<String> assetList = new ArrayList<String>();
					for (int k = 4; k <= 19; k++) {
						int excelRow = reader.getRowCount(sheetName);
						System.out.println(excelRow);
						excelRow++;
						WebElement value = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[5]"));
						String elementtext = value.getText();
						reader.setCellData(sheetName,category+" Values", excelRow, elementtext);
						WebElement asset = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[2]"));
						if (!asset.getText().isEmpty()) {

							System.out.println(asset.getText());
							assetList.add(asset.getText());
							reader.setCellData(sheetName, columnList.get(1), excelRow, asset.getText());
						    System.out.println("Col size--"+columnList.size());
							for(int i=2;i<columnList.size();i++){
								WebElement data = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[" +(i+1)+ "]"));
								System.out.println(data.getText());
								reader.setCellData(sheetName, columnList.get(i), excelRow, data.getText());

							}
				

						}
						
						else {
							for(int i=2;i<=columnList.size();i++){
								WebElement data = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[" +(i+1)+"]"));
								System.out.println(data.getText());
								reader.setCellData(sheetName, columnList.get(i-1), excelRow, data.getText());

							}
				
						}
					}

					// use scroll

					try
					{
						WebElement scrollBar = driver.findElement(By.xpath("//div[@class='scrollbar-animation scrollbar-track ng-scope ng-isolate-scope vertical']//div[starts-with(@class,'scrollbar-thumb')]"));
					Actions actions = new Actions(driver);
					actions.moveToElement(scrollBar).build().perform();
					actions.click(scrollBar).build().perform();
					
					//Last But one element Before scroll
					WebElement beforeScrollAssets = driver.findElement(By.xpath("//table/tbody/tr[19]/td[2]"));
					if (!beforeScrollAssets.getText().isEmpty()) {
						text17 = beforeScrollAssets.getText();
					    System.out.println("last but one number-----"+text17);
					}
							
					else{
						WebElement lastSubAssets = driver.findElement(By.xpath("//table/tbody/tr[19]/td[3]"));
						text17= lastSubAssets.getText();
					    System.out.println("last but one number-----"+text17);
					}
					
					
					    int count=1;
					    
					    for(int i1=1;i1<=count;i1++){

					Robot robot = new Robot();
					int excelRow = reader.getRowCount(sheetName);
					System.out.println(excelRow);
					excelRow++;
					
						actions.moveToElement(scrollBar).build().perform();
						actions.click(scrollBar);
						System.out.println("Key down");
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(1000);
						System.out.println("Scroll arrow down key pressed");
											
						//Last element after scroll
						WebElement lastAssets = driver.findElement(By.xpath("//table/tbody/tr[19]/td[2]"));
						if (!lastAssets.getText().isEmpty()) {
							 text18 = lastAssets.getText();
						    System.out.println("last number----"+text18);
						}
						else{
							WebElement lastSubAssets = driver.findElement(By.xpath("//table/tbody/tr[19]/td[3]"));
							text18= lastSubAssets.getText();
						    System.out.println("last number----"+text18);
						}
						
						if (!text17.equals(text18)) {
						
						Thread.sleep(2000);
						WebElement sAAvalue = driver.findElement(By.xpath("//div[@class='col-md-8 navBarClass']/div[4] "));
						String sAAElementtext = sAAvalue.getText();
						reader.setCellData(sheetName,category+" Values", excelRow, sAAElementtext);
						// picking values after pressing down key
						WebElement assets = driver.findElement(By.xpath("//table/tbody/tr[19]/td[2]"));
						if (!assets.getText().isEmpty()) {

							System.out.println(assets.getText());
							assetList.add(assets.getText());
							reader.setCellData(sheetName, columnList.get(1), excelRow, assets.getText());
						
							for(int i=2;i<columnList.size();i++){
								WebElement data = driver.findElement(By.xpath("//table/tbody/tr[19]/td[" +(i+1)+ "]"));
								System.out.println(data.getText());
								reader.setCellData(sheetName, columnList.get(i), excelRow, data.getText());

							}
						}
						
					
						else {
							
							for(int i=2;i<=columnList.size();i++){
								WebElement data = driver.findElement(By.xpath("//table/tbody/tr[19]/td[" +(i+1)+ "]"));
								System.out.println(data.getText());
								reader.setCellData(sheetName, columnList.get(i-1), excelRow, data.getText());
							}

						}
						    count++;
							System.out.println("last number----"+text18);
							text17=text18;
							System.out.println("swapped number----"+text17);

						excelRow++;
					}
					
					else
					{
						System.out.println("Scroll completed break on matching values");
					    break;		
					}
				
					    }		
				 	
				}
					
					catch(Exception e)
					{
						System.out.println("scroll not found");
					}
				}
}
