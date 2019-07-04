package com.Infrahedge.generic;

import java.io.FileOutputStream;
import java.sql.*;

import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatabaseConnectivity {

	@Test

	public void fetchDBData(String riskProfile, String filePath, String sheetName, String query) {

		String connectionURL = "jdbc:sqlserver://172.30.3.227:1433;"
				+ "databaseName=INFRAHEDGE_DAS;integratedSecurity=true;";

		Connection connect = null;
		Statement statement = null;
		ResultSet result = null;

		Xls_Reader reader = new Xls_Reader(filePath, sheetName);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Loaded Successfully !!");
			connect = DriverManager.getConnection(connectionURL);
			System.out.println("Connected to SQL server DB");

			statement = connect.createStatement();

			XSSFSheet sheet;

			// if sheet exists do the below
			sheet = reader.workbook.getSheet(sheetName);
			if (sheet == null) {
				sheet = reader.workbook.createSheet(sheetName);
			}

			result = statement.executeQuery(query);
			System.out.println(result);

			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println(rsmd.getColumnLabel(1));
			System.out.println(columnCount);

			for (int i = 1; i <= columnCount; i++) {

				String columnName = rsmd.getColumnName(i);
				System.out.println(columnName);

				XSSFRow row = sheet.getRow(0);
				if (row == null) {
					row = sheet.createRow(0);
				}

				XSSFCell cell = row.getCell(i - 1);
				if (cell == null) {
					cell = row.createCell(i - 1);
				}
				cell.setCellValue(columnName);
				System.out.println("column name in excel" + columnName);

			}

			FileOutputStream fileOut = new FileOutputStream(filePath);
			reader.workbook.write(fileOut);
			fileOut.close();

			reader.workbook.getSheet(filePath);

			int rowNumber = 1;

			while (result.next()) {

				int columnindex = 0;

				XSSFRow row = sheet.getRow(rowNumber);
				if (row == null) {
					row = sheet.createRow(rowNumber);
				}
				XSSFCell cell;

				for (int i = 0; i < columnCount; i++) {

					cell = row.getCell(i);
					if (cell == null) {
						cell = row.createCell(i);
					}
					cell.setCellValue(result.getString(i + 1));
					System.out.println(result.getString(i + 1));
					columnindex++;
				}

				rowNumber++;
			}

			fileOut = new FileOutputStream(filePath);
			reader.workbook.write(fileOut);
			fileOut.close();

		}

		catch (Exception e) {
			System.out.println("Driver not loaded");
			e.printStackTrace();
		}
	}

}