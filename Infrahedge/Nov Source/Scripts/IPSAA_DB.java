package com.Infrahedge.Scripts;

import java.util.ArrayList;

import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.IAutoConstant;

public class IPSAA_DB implements IAutoConstant {

	@org.testng.annotations.Test

	public void testSAAData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();

		// String filepath=DB_EXCEL_Workbook_Path;
		//
		// ArrayList<String> riskProfile= new ArrayList<String>();
		// riskProfile.add("IP1");
		// riskProfile.add("IP2");
		// riskProfile.add("IP3");
		// riskProfile.add("IP4");
		// riskProfile.add("IP5");
		//
		// String category="SAA";

		// String sheetName="Volatility"+riskProfile+category;
		// System.out.println(sheetName+"this is the sheet addedd");
		// String query="Exec [USP_GET_KPI] 'riskProfile', 'SAA','VOL'";

		// connect.fetchDBData("IP1","Y:\\TFS\\Infrahedge
		// Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\DB_Category_Data.xlsx",
		// "VolatilityIP1SAA", query);

		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP1SAA", "Exec [USP_GET_KPI] 'IP1','SAA','Vol'");
		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP2SAA", "Exec [USP_GET_KPI] 'IP2','SAA','Vol'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP3SAA", "Exec [USP_GET_KPI] 'IP3','SAA','Vol'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP4SAA", "Exec [USP_GET_KPI] 'IP4','SAA','Vol'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP5SAA", "Exec [USP_GET_KPI] 'IP5','SAA','Vol'");
		
		//VaR Data
		
		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP1SAA", "Exec [USP_GET_KPI] 'IP1','SAA','VaR'");
		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP2SAA", "Exec [USP_GET_KPI] 'IP2','SAA','VaR'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP3SAA", "Exec [USP_GET_KPI] 'IP3','SAA','VaR'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP4SAA", "Exec [USP_GET_KPI] 'IP4','SAA','VaR'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP5SAA", "Exec [USP_GET_KPI] 'IP5','SAA','VaR'");
		
		
		//TE Data
		
		//No data for TE in UI
		
		

	}
}
