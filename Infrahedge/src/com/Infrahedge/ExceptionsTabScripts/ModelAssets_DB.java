package com.Infrahedge.ExceptionsTabScripts;

import org.testng.annotations.Test;

import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.IAutoConstant;

public class ModelAssets_DB implements IAutoConstant {

	@Test

	public void testModelData() {
		DatabaseConnectivity connect = new DatabaseConnectivity();
		try {
			// Vol Data
			connect.fetchDBData("IP1", DB_EXCEL_PATH, "VolatilityIP1Model", "Exec [USP_GET_KPI] 'IP1','Model','Vol'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "VolatilityIP2Model", "Exec [USP_GET_KPI] 'IP2','Model','Vol'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "VolatilityIP3Model", "Exec [USP_GET_KPI] 'IP3','Model','Vol'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "VolatilityIP4Model", "Exec [USP_GET_KPI] 'IP4','Model','Vol'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "VolatilityIP5Model", "Exec [USP_GET_KPI] 'IP5','Model','Vol'");

			// VaR Data

			connect.fetchDBData("IP1", DB_EXCEL_PATH, "VaRIP1Model", "Exec [USP_GET_KPI] 'IP1','Model','VaR'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "VaRIP2Model", "Exec [USP_GET_KPI] 'IP2','Model','VaR'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "VaRIP3Model", "Exec [USP_GET_KPI] 'IP3','Model','VaR'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "VaRIP4Model", "Exec [USP_GET_KPI] 'IP4','Model','VaR'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "VaRIP5Model", "Exec [USP_GET_KPI] 'IP5','Model','VaR'");

			// TE Data

			connect.fetchDBData("IP1", DB_EXCEL_PATH, "TEIP1Model", "Exec [USP_GET_KPI] 'IP1','Model','TE'");
			connect.fetchDBData("IP2", DB_EXCEL_PATH, "TEIP2Model", "Exec [USP_GET_KPI] 'IP2','Model','TE'");
			connect.fetchDBData("IP3", DB_EXCEL_PATH, "TEIP3Model", "Exec [USP_GET_KPI] 'IP3','Model','TE'");
			connect.fetchDBData("IP4", DB_EXCEL_PATH, "TEIP4Model", "Exec [USP_GET_KPI] 'IP4','Model','TE'");
			connect.fetchDBData("IP5", DB_EXCEL_PATH, "TEIP5Model", "Exec [USP_GET_KPI] 'IP5','Model','TE'");

		} catch (Exception e) {
			System.out.println("No data found in DB !!");
		}
	}
}
