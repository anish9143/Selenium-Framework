package com.Infrahedge.ExceptionsTabScripts;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.IAutoConstant;

public class SAAAssets_DB implements IAutoConstant {

	@Test

	public void testSAAData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();
try{
	//Vol Data
		connect.fetchDBData("IP1", DB_EXCEL_PATH, "VolatilityIP1SAA", "Exec [USP_GET_KPI] 'IP1','SAA','Vol'");
		connect.fetchDBData("IP2", DB_EXCEL_PATH, "VolatilityIP2SAA", "Exec [USP_GET_KPI] 'IP2','SAA','Vol'");
		connect.fetchDBData("IP3", DB_EXCEL_PATH, "VolatilityIP3SAA", "Exec [USP_GET_KPI] 'IP3','SAA','Vol'");
		connect.fetchDBData("IP4", DB_EXCEL_PATH, "VolatilityIP4SAA", "Exec [USP_GET_KPI] 'IP4','SAA','Vol'");
		connect.fetchDBData("IP5", DB_EXCEL_PATH, "VolatilityIP5SAA", "Exec [USP_GET_KPI] 'IP5','SAA','Vol'");

		// VaR Data

		connect.fetchDBData("IP1", DB_EXCEL_PATH, "VaRIP1SAA", "Exec [USP_GET_KPI] 'IP1','SAA','VaR'");
		connect.fetchDBData("IP2", DB_EXCEL_PATH, "VaRIP2SAA", "Exec [USP_GET_KPI] 'IP2','SAA','VaR'");
		connect.fetchDBData("IP3", DB_EXCEL_PATH, "VaRIP3SAA", "Exec [USP_GET_KPI] 'IP3','SAA','VaR'");
		connect.fetchDBData("IP4", DB_EXCEL_PATH, "VaRIP4SAA", "Exec [USP_GET_KPI] 'IP4','SAA','VaR'");
		connect.fetchDBData("IP5", DB_EXCEL_PATH, "VaRIP5SAA", "Exec [USP_GET_KPI] 'IP5','SAA','VaR'");

		// TE Data

		// No data for TE in UI
}
catch(Exception e)
{
	System.out.println("No data found in DB !!");
}
}
	}

