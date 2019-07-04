package com.Infrahedge.Scripts;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;

public class IPPortfolio_DB {

	@Test

	public void testPortfolioData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();

		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP1Portfolio", "Exec [USP_GET_KPI] 'IP1','Portfolio','Vol'");

		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP2Portfolio", "Exec [USP_GET_KPI] 'IP2','Portfolio','Vol'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP3Portfolio", "Exec [USP_GET_KPI] 'IP3','Portfolio','Vol'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP4Portfolio", "Exec [USP_GET_KPI] 'IP4','Portfolio','Vol'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP5Portfolio", "Exec [USP_GET_KPI] 'IP5','Portfolio','Vol'");
		
		
		//VaR Data
		
		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP1Portfolio", "Exec [USP_GET_KPI] 'IP1','Portfolio','VaR'");
		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP2Portfolio", "Exec [USP_GET_KPI] 'IP2','Portfolio','VaR'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP3Portfolio", "Exec [USP_GET_KPI] 'IP3','Portfolio','VaR'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP4Portfolio", "Exec [USP_GET_KPI] 'IP4','Portfolio','VaR'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP5Portfolio", "Exec [USP_GET_KPI] 'IP5','Portfolio','VaR'");

	}
}
