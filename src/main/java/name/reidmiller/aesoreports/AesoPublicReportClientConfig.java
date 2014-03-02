package name.reidmiller.aesoreports;

import name.reidmiller.aesoreports.client.CurrentSupplyDemandClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AesoPublicReportClientConfig {
	static Logger logger = LogManager
			.getLogger(AesoPublicReportClientConfig.class.getName());

	/**
	 * CurrentSupplyMix
	 * 
	 * @return
	 */
	public static CurrentSupplyDemandClient currentSupplyDemandClient() {
		return new CurrentSupplyDemandClient(
				"http://ets.aeso.ca/ets_web/ip/Market/Reports/CSDReportServlet?contentType=csv");
	}
}
