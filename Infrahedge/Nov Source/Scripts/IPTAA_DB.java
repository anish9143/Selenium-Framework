package com.Infrahedge.Scripts;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;

public class IPTAA_DB {

	@Test

	public void testTAAData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();

		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP1TAA", "Exec [USP_GET_KPI] 'IP1','TAA','Vol'");

		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP2TAA", "Exec [USP_GET_KPI] 'IP2','TAA','Vol'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP3TAA", "Exec [USP_GET_KPI] 'IP3','TAA','Vol'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP4TAA", "Exec [USP_GET_KPI] 'IP4','TAA','Vol'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP5TAA", "Exec [USP_GET_KPI] 'IP5','TAA','Vol'");
		
		
		//VaR Data
		
		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP1TAA", "Exec [USP_GET_KPI] 'IP1','TAA','VaR'");
		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP2TAA", "Exec [USP_GET_KPI] 'IP2','TAA','VaR'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP3TAA", "Exec [USP_GET_KPI] 'IP3','TAA','VaR'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP4TAA", "Exec [USP_GET_KPI] 'IP4','TAA','VaR'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP5TAA", "Exec [USP_GET_KPI] 'IP5','TAA','VaR'");
		
		

		//TE Data
		
		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"TEIP1TAA", "Exec [USP_GET_KPI] 'IP1','TAA','TE'");
		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"TEIP2TAA", "Exec [USP_GET_KPI] 'IP2','TAA','TE'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"TEIP3TAA", "Exec [USP_GET_KPI] 'IP3','TAA','TE'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"TEIP4TAA", "Exec [USP_GET_KPI] 'IP4','TAA','TE'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"TEIP5TAA", "Exec [USP_GET_KPI] 'IP5','TAA','TE'");

	}
}
