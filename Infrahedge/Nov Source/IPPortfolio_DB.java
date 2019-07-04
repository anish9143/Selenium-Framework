package com.Infrahedge.Scripts;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.IAutoConstant;

public class IPPortfolio_DB implements IAutoConstant {

	@Test

	public void testPortfolioData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();
		try {
			// Vol Data
			connect.fetchDBData("IP1", DB_EXCEL_PATH, "VolatilityIP1Portfolio",
					"Exec [USP_GET_KPI] 'IP1','Portfolio','Vol'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "VolatilityIP2Portfolio",
					"Exec [USP_GET_KPI] 'IP2','Portfolio','Vol'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "VolatilityIP3Portfolio",
					"Exec [USP_GET_KPI] 'IP3','Portfolio','Vol'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "VolatilityIP4Portfolio",
					"Exec [USP_GET_KPI] 'IP4','Portfolio','Vol'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "VolatilityIP5Portfolio",
					"Exec [USP_GET_KPI] 'IP5','Portfolio','Vol'");

			// VaR Data

			connect.fetchDBData("IP1", DB_EXCEL_PATH, "VaRIP1Portfolio", "Exec [USP_GET_KPI] 'IP1','Portfolio','VaR'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "VaRIP2Portfolio", "Exec [USP_GET_KPI] 'IP2','Portfolio','VaR'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "VaRIP3Portfolio", "Exec [USP_GET_KPI] 'IP3','Portfolio','VaR'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "VaRIP4Portfolio", "Exec [USP_GET_KPI] 'IP4','Portfolio','VaR'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "VaRIP5Portfolio", "Exec [USP_GET_KPI] 'IP5','Portfolio','VaR'");

			// TE Data

			connect.fetchDBData("IP1", DB_EXCEL_PATH, "TEIP1Portfolio", "Exec [USP_GET_KPI] 'IP1','Portfolio','TE'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "TEIP2Portfolio", "Exec [USP_GET_KPI] 'IP2','Portfolio','TE'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "TEIP3Portfolio", "Exec [USP_GET_KPI] 'IP3','Portfolio','TE'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "TEIP4Portfolio", "Exec [USP_GET_KPI] 'IP4','Portfolio','TE'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "TEIP5Portfolio", "Exec [USP_GET_KPI] 'IP5','Portfolio','TE'");

		}

		catch (Exception e) {
			System.out.println("No data found in DB !!");
		}
	}
}