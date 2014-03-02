package name.reidmiller.aesoreports.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import name.reidmiller.aesoreports.AesoPublicReportClientConfig;
import name.reidmiller.aesoreports.model.SupplyDemand;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class CurrentSupplyDemandClientTest {
	private Logger logger = LogManager.getLogger(this.getClass());

	@Test
	public void testGetDefaultCurrentSupplyDemand() {
		CurrentSupplyDemandClient currentSupplyDemandClient = AesoPublicReportClientConfig
				.currentSupplyDemandClient();
		SupplyDemand currentSupplyDemand = currentSupplyDemandClient
				.getDefaultCurrentSupplyDemand();
		
		logger.debug("Current Supply Demand in testGetDefaultCurrentSupplyDemand = " + currentSupplyDemand);

		// Last Update
		assertNotNull("Last Update could not be parsed",
				currentSupplyDemand.getLastUpdate());
		assertTrue("Last Update is not less than current instant",
				currentSupplyDemand.getLastUpdate().before(new Date()));

		// Summary
		assertTrue("Net generation is not greater than 0", currentSupplyDemand
				.getSummary().getAlbertaTotalNetGeneration() > 0);
		assertTrue("Internal load is not greater than 0", currentSupplyDemand
				.getSummary().getAlbertaInternalLoad() > 0);

		// Generation Groups
		assertNotNull("List of GenerationGroup objects is null",
				currentSupplyDemand.getGenerationGroups());
		assertTrue(
				"List size of GenerationGroup objects is not greater than zero",
				currentSupplyDemand.getGenerationGroups().size() > 0);

		// Interchanges
		assertNotNull("List of Interchange objects is null",
				currentSupplyDemand.getInterchanges());
		assertTrue("List size of Interchange objects is not greater than zero",
				currentSupplyDemand.getInterchanges().size() > 0);
	}
}
