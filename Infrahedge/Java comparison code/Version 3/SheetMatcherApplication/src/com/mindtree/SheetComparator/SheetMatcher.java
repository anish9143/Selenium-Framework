package com.mindtree.SheetComparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SheetMatcher {

	static ArrayList<String> listOfUISheets;
	static ArrayList<String> listODBSheets;
	static Properties propFile;
	static String sheetKey;
	static XSSFWorkbook myUIWorkBook;
	static int uiSheetCount;

	static XSSFWorkbook myDBWorkBook;
	static int dbSheetCount;

	static XSSFWorkbook outputWorkBook;

	public static void main(String[] args) {
		// Map to hold DB values
		Map<String, Double[]> DBMap = new LinkedHashMap<String, Double[]>();
		// Map to hold UI values
		Map<String, Double[]> UIMap = new LinkedHashMap<String, Double[]>();
		initialize();

		String UISheetName, DBSheetName;
		
		//Traverse UI and DB excels(whichever sheet count is greater) sheet by sheet 
		if (uiSheetCount >= dbSheetCount) {
			for (int i = 0; i < uiSheetCount; i++) {
				UISheetName = myUIWorkBook.getSheetAt(i).getSheetName();

				for (int j = 0; j < dbSheetCount; j++) {
					DBSheetName = myDBWorkBook.getSheetAt(j).getSheetName();

					if (UISheetName.equals(DBSheetName)) {						
						UIMap = traverseUISheet(j);
						DBMap = traverseDBSheet(j);
						compareSheets(UIMap, DBMap, j);
					}
				}
			}
		} else {
			for (int i = 0; i < dbSheetCount; i++) {
				DBSheetName = myDBWorkBook.getSheetAt(i).getSheetName();

				for (int j = 0; j < uiSheetCount; j++) {
					UISheetName = myUIWorkBook.getSheetAt(j).getSheetName();

					if (UISheetName.equals(DBSheetName)) {
						UIMap = traverseUISheet(j);
						DBMap = traverseDBSheet(j);

						compareSheets(UIMap, DBMap, j);
					}
				}
			}
		}

	}

	private static void initializeOutputWorkbook() {

		int numCols, outRowId = 0;
		XSSFSheet outSheet, uiSheet;
		XSSFRow outRow = null;
		Cell UIcell, outCell;
		String UIcellValue;
		outputWorkBook = new XSSFWorkbook();

		// Create output workbook, sheets, column header

		for (int i = 0; i < uiSheetCount; i++) {
			uiSheet = myUIWorkBook.getSheetAt(i);
			String sheetName = uiSheet.getSheetName();
			outSheet = outputWorkBook.createSheet(sheetName);

			XSSFRow UIRow = uiSheet.getRow(0);
			numCols = uiSheet.getRow(0).getLastCellNum();

			outRow = outSheet.createRow(outRowId);
			
			//populate column header
			for (int j = 0, outCellId = 0; j < numCols; j++) {
				UIcell = UIRow.getCell(j);
				UIcellValue = String.valueOf(UIcell);
				outCell = outRow.createCell(outCellId++);
				outCell.setCellValue(UIcellValue);
			}
		}

		writeToOutputWorkbook();
		String outWorkbookName = propFile.getProperty("outFileName");
		System.out.println("Output Workbook name: "+outWorkbookName);
	}

	private static void writeToOutputWorkbook() {
		FileOutputStream out;
		//save data in output workbook
		try {
			String outFileName = propFile.getProperty("outFileName");
			out = new FileOutputStream(new File(outFileName));
			
			File file = new File(outFileName);			
			outputWorkBook.write(out);
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void compareSheets(Map<String, Double[]> UIMap,
			Map<String, Double[]> DBMap, int sheetIndex) {
		int outRowId = 1, outCellId = 0, i = 0;
		XSSFSheet outSheet;
		Cell outCell;
		XSSFRow outRow;

		Map<String, ArrayList<String>> matchedOutputMap = new LinkedHashMap<String, ArrayList<String>>();
		Map<String, String> unmatchedOutputMap = new LinkedHashMap<String, String>();

		// Compare UIMap with DBMap
		for (Map.Entry<String, Double[]> entry : UIMap.entrySet()) {
			String keyUI = entry.getKey();
			ArrayList<String> resultList = new ArrayList<String>();

			// If key Matches
			if (DBMap.containsKey(keyUI)) {
				Double[] UIDataRow = entry.getValue();
				Double[] DBDataRow = DBMap.get(keyUI);

				int count = 0;

				for (i = 0; i < UIDataRow.length; i++) {
					double diff = Math.abs(UIDataRow[i] - DBDataRow[i]);

					DecimalFormat df = new DecimalFormat("####0.00");
					Double FormattedDiff = Double.parseDouble(df.format(diff));

					double tol = 0.000000000001;
					if (FormattedDiff > tol) {

						resultList.add(" UnMatched ");
					} else {

						resultList.add(" Matched ");
					}
				}

				matchedOutputMap.put(keyUI, resultList);
			} else {

				unmatchedOutputMap.put(keyUI, " UnMatched");
			}
		}

		// Compare DBMap with UIMap
		for (Map.Entry<String, Double[]> entryDB : DBMap.entrySet()) {
			String keyDB = entryDB.getKey();
			if (!UIMap.containsKey(keyDB)) {

				unmatchedOutputMap.put(keyDB, " UnMatched");
			}
		}

		int rowid = 1;
		outSheet = outputWorkBook.getSheetAt(sheetIndex);
		for (Map.Entry<String, ArrayList<String>> entry : matchedOutputMap
				.entrySet()) {
			outRow = outSheet.createRow(outRowId++);
			ArrayList<String> arrStr = entry.getValue();
			int cellId = 0;

			// Break keys to get set of keys
			StringTokenizer st = new StringTokenizer(entry.getKey(), "|");

			while (st.hasMoreTokens()) {
				outCell = outRow.createCell(cellId++);
				outCell.setCellValue(st.nextToken());

			}
			for (String str : arrStr) {
				outCell = outRow.createCell(cellId++);
				outCell.setCellValue(str);
			}

		}

		for (Map.Entry<String, String> entry : unmatchedOutputMap.entrySet()) {

			outRow = outSheet.createRow(outRowId++);
			int cellId = 0;

			StringTokenizer st = new StringTokenizer(entry.getKey(), "|");

			while (st.hasMoreTokens()) {
				outCell = outRow.createCell(cellId++);
				outCell.setCellValue(st.nextToken());

			}

			outCell = outRow.createCell(cellId++);
			outCell.setCellValue(entry.getValue());
		}

		writeToOutputWorkbook();

	}

	private static void initialize() {
		propFile = new Properties();
		InputStream propInStream;
		String uiFileName, dbFileName;
		FileInputStream uiFis = null;

		// Initialize UI File

		try {
			propInStream = new FileInputStream("mappingsheet.properties");
			propFile.load(propInStream);

			// Initialize UI File
			uiFileName = propFile.getProperty("uiFileName");
			File myUiFile = new File(uiFileName);
			uiFis = new FileInputStream(myUiFile);
			myUIWorkBook = new XSSFWorkbook(uiFis);
			uiSheetCount = myUIWorkBook.getNumberOfSheets();

			// Initialize DB File
			dbFileName = propFile.getProperty("dbFileName");
			File myDbFile = new File(dbFileName);
			FileInputStream dbFis = new FileInputStream(myDbFile);
			myDBWorkBook = new XSSFWorkbook(dbFis);
			dbSheetCount = myDBWorkBook.getNumberOfSheets();

			initializeOutputWorkbook();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Map traverseUISheet(int UIsheetIndex) {
		Map<String, Double[]> UIMap = new LinkedHashMap<String, Double[]>();
		String value;
		int numRows, numCols;
		Cell cell;
		
		//traverse sheet to create a map of each UI sheet. Key of Map= key in UI sheet, Value of Map = Data for corresponding key	
		XSSFSheet mySheet = myUIWorkBook.getSheetAt(UIsheetIndex);
		String sheetName = mySheet.getSheetName();

		sheetKey = sheetName + ".noOfKeys";
		int noOFSheetKey = Integer.parseInt(propFile.getProperty(sheetKey));
		numRows = mySheet.getLastRowNum() + 1;
		numCols = mySheet.getRow(0).getLastCellNum();
		
		//Traverse each row of UI sheet
		for (int i = 1; i < numRows; i++) {
			Row row = mySheet.getRow(i);
			
			//data array to hold row wise data value
			Double[] arrUI = new Double[numCols - noOFSheetKey];
			int k = 0;
			for (int j = noOFSheetKey; j < numCols; j++) {
				cell = row.getCell(j);

				value = String.valueOf(cell);
				//Fix to ignore '%' and '-'
				if (value.contains("%"))
					value = String.valueOf(cell).replace("%", "0");
				if (value.equals("-"))
					value = String.valueOf(cell).replace("-", "0");

				arrUI[k] = Double.parseDouble(value);
				k++;
			}

			String rowKey = "";
			for (int j = 0; j < noOFSheetKey; j++) {
				rowKey += row.getCell(j) + "|";
			}
			//put key and data in UIMap
			UIMap.put(rowKey, arrUI);
		}
		return UIMap;
	}

	private static Map traverseDBSheet(int DBSheetIndex) {
		int numDbRows, numDbCols;
		Cell cell;
		Map<String, Double[]> DBMap = new LinkedHashMap<String, Double[]>();

		//traverse sheet to create a map of each DB sheet. Key of Map= keys in DB sheet, Value of Map = Data for corresponding key
		XSSFSheet myDbSheet = myDBWorkBook.getSheetAt(DBSheetIndex);

		String dbSheetName = myDbSheet.getSheetName();
		String dbKey = "";
		dbKey = dbSheetName + ".noOfKeys";
		int noOFDBSheetKey = Integer.parseInt(propFile.getProperty(dbKey));
		numDbRows = myDbSheet.getLastRowNum() + 1;
		numDbCols = myDbSheet.getRow(0).getLastCellNum();

		//Traverse each row of DB sheet
		for (int i = 1; i < numDbRows; i++) {
			Row row = myDbSheet.getRow(i);
			//data array to hold row wise data value
			Double[] arrDB = new Double[numDbCols - noOFDBSheetKey];
			int k = 0;
			for (int j = noOFDBSheetKey; j < numDbCols; j++) {
				cell = row.getCell(j);
				String value1 = String.valueOf(cell);
				arrDB[k] = Double.valueOf(value1);
				k++;
			}
			
			String rowKey = "";
			for (int j = 0; j < noOFDBSheetKey; j++) {
				rowKey += row.getCell(j) + "|";
			}
			//put key and data in UIMap
			DBMap.put(rowKey, arrDB);
			
		}
		return DBMap;

	}

}
