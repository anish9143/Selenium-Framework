package com.Infrahedge.Scripts;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.IAutoConstant;

public class IPTAA_DB implements IAutoConstant {

	@Test

	public void testTAAData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();
		try {
			//Vol Data
			connect.fetchDBData("IP1", DB_EXCEL_PATH, "VolatilityIP1TAA", "Exec [USP_GET_KPI] 'IP1','TAA','Vol'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "VolatilityIP2TAA", "Exec [USP_GET_KPI] 'IP2','TAA','Vol'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "VolatilityIP3TAA", "Exec [USP_GET_KPI] 'IP3','TAA','Vol'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "VolatilityIP4TAA", "Exec [USP_GET_KPI] 'IP4','TAA','Vol'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "VolatilityIP5TAA", "Exec [USP_GET_KPI] 'IP5','TAA','Vol'");

			// VaR Data

			connect.fetchDBData("IP1", DB_EXCEL_PATH, "VaRIP1TAA", "Exec [USP_GET_KPI] 'IP1','TAA','VaR'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "VaRIP2TAA", "Exec [USP_GET_KPI] 'IP2','TAA','VaR'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "VaRIP3TAA", "Exec [USP_GET_KPI] 'IP3','TAA','VaR'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "VaRIP4TAA", "Exec [USP_GET_KPI] 'IP4','TAA','VaR'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "VaRIP5TAA", "Exec [USP_GET_KPI] 'IP5','TAA','VaR'");

			// TE Data

			connect.fetchDBData("IP1", DB_EXCEL_PATH, "TEIP1TAA", "Exec [USP_GET_KPI] 'IP1','TAA','TE'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "TEIP2TAA", "Exec [USP_GET_KPI] 'IP2','TAA','TE'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "TEIP3TAA", "Exec [USP_GET_KPI] 'IP3','TAA','TE'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "TEIP4TAA", "Exec [USP_GET_KPI] 'IP4','TAA','TE'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "TEIP5TAA", "Exec [USP_GET_KPI] 'IP5','TAA','TE'");

		} catch (Exception e) {
			System.out.println("No data found in DB !!");
		}
	}
}
