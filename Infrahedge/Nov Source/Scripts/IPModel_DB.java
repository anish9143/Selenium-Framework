package com.Infrahedge.Scripts;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;

public class IPModel_DB {

	@Test

	public void testModelData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();

		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP1Model", "Exec [USP_GET_KPI] 'IP1','Model','Vol'");

		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP2Model", "Exec [USP_GET_KPI] 'IP2','Model','Vol'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP3Model", "Exec [USP_GET_KPI] 'IP3','Model','Vol'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP4Model", "Exec [USP_GET_KPI] 'IP4','Model','Vol'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VolatilityIP5Model", "Exec [USP_GET_KPI] 'IP5','Model','Vol'");
		
		
		//VaR Data
		
		connect.fetchDBData("IP1",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP1Model", "Exec [USP_GET_KPI] 'IP1','Model','VaR'");
		connect.fetchDBData("IP2",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP2Model", "Exec [USP_GET_KPI] 'IP2','Model','VaR'");
		connect.fetchDBData("IP3",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP3Model", "Exec [USP_GET_KPI] 'IP3','Model','VaR'");
		connect.fetchDBData("IP4",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP4Model", "Exec [USP_GET_KPI] 'IP4','Model','VaR'");
		connect.fetchDBData("IP5",
				"Y:\\TFS\\Infrahedge Maintenance\\TestAutomation\\Infrahedge_V0.1\\TestData\\test.xlsx",
				"VaRIP5Model", "Exec [USP_GET_KPI] 'IP5','Model','VaR'");

	}
}
