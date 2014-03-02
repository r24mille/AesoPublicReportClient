package name.reidmiller.aesoreports.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;
import name.reidmiller.aesoreports.model.GenerationGroup;
import name.reidmiller.aesoreports.model.GeneratorType;
import name.reidmiller.aesoreports.model.Interchange;
import name.reidmiller.aesoreports.model.InterchangePath;
import name.reidmiller.aesoreports.model.Summary;
import name.reidmiller.aesoreports.model.SupplyDemand;

public class CurrentSupplyDemandClient {
	public static final String CURRENT_SUPPLY_DEMAND_DATE_PATTERN = "MMM dd',' yyyy HH:mm";
	public static final TimeZone CANADA_MOUNTAIN_TIME_ZONE = TimeZone
			.getTimeZone("Canada/Mountain");
	private Logger logger = LogManager.getLogger(this.getClass());
	private String defaultUrlString;
	private SimpleDateFormat simpleDateFormat;

	public CurrentSupplyDemandClient(String defaultUrlString) {
		this.defaultUrlString = defaultUrlString;
		this.simpleDateFormat = new SimpleDateFormat(
				CURRENT_SUPPLY_DEMAND_DATE_PATTERN);
		this.simpleDateFormat.setTimeZone(CANADA_MOUNTAIN_TIME_ZONE);
	}

	public SupplyDemand getDefaultCurrentSupplyDemand() {
		return this.getCurrentSupplyDemand(this.defaultUrlString);
	}

	public SupplyDemand getCurrentSupplyDemand(String urlString) {
		SupplyDemand supplyDemand = new SupplyDemand();
		supplyDemand.setSummary(new Summary());
		supplyDemand.setGenerationGroups(new ArrayList<GenerationGroup>());
		supplyDemand.setInterchanges(new ArrayList<Interchange>());

		try {
			URL url = new URL(urlString);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			CSVReader reader = new CSVReader(in);

			// Loop over each row of CSV report
			String[] csvLine = reader.readNext();
			for (int i = 0; csvLine != null; i++) {
				// Skip empty rows
				if (csvLine[0] != null && !csvLine[0].isEmpty()) {
					if (csvLine[0].contains("Last Update")) {
						supplyDemand.setLastUpdate(this
								.parseLastUpdate(csvLine[0]));
					} else if (csvLine[0]
							.contains("Alberta Total Net Generation")) {
						supplyDemand.getSummary().setAlbertaTotalNetGeneration(
								Double.parseDouble(csvLine[1]));
					} else if (csvLine[0].contains("Interchange")) {
						supplyDemand.getSummary().setInterchange(
								Double.parseDouble(csvLine[1]));
					} else if (csvLine[0].contains("Alberta Internal Load")) {
						supplyDemand.getSummary().setAlbertaInternalLoad(
								Double.parseDouble(csvLine[1]));
					} else if (csvLine[0]
							.contains("Alberta Load Responsibility")) {
						supplyDemand.getSummary().setAlbertaLoadResponsibility(
								Double.parseDouble(csvLine[1]));
					} else if (csvLine[0]
							.contains("Contingency Reserve Required")) {
						supplyDemand.getSummary()
								.setContingencyreserveRequired(
										Double.parseDouble(csvLine[1]));
					} else if (csvLine[0]
							.contains("Dispatched Contingency Reserve (DCR)")) {
						supplyDemand.getSummary()
								.setDispatchedContingencyReserve(
										Double.parseDouble(csvLine[1]));
					} else if (csvLine[0]
							.contains("Dispatched Contingency Reserve -Gen")) {
						supplyDemand.getSummary()
								.setDispatchedContingencyReserveGen(
										Double.parseDouble(csvLine[1]));
					} else if (csvLine[0]
							.contains("Dispatched Contingency Reserve -Other")) {
						supplyDemand.getSummary()
								.setDispatchedContingencyReserveOther(
										Double.parseDouble(csvLine[1]));
					} else if (csvLine[0].contains("LSSi Armed Dispatch")) {
						supplyDemand.getSummary().setLssiArmedDispatch(
								Double.parseDouble(csvLine[1]));
					} else if (csvLine[0].contains("LSSi Offered Volume")) {
						supplyDemand.getSummary().setLssiOfferedVolume(
								Double.parseDouble(csvLine[1]));
					} else if (csvLine[0].equals("COAL")
							|| csvLine[0].equals("GAS")
							|| csvLine[0].equals("HYDRO")
							|| csvLine[0].equals("OTHER")
							|| csvLine[0].equals("WIND")) {
						supplyDemand.getGenerationGroups().add(
								this.parseGenerationGroup(csvLine));
					} else if (csvLine[0].equals("British Columbia")
							|| csvLine[0].equals("Montana")
							|| csvLine[0].equals("Saskatchewan")) {
						supplyDemand.getInterchanges().add(
								this.parseInterchange(csvLine));
					}
					// TODO Find flexible way to parse GenerationUnit objects
				}

				// Step to next line
				csvLine = reader.readNext();
			}

			reader.close();
		} catch (MalformedURLException e) {
			logger.warn("Could not create " + URL.class + " from \""
					+ urlString + "\"");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return supplyDemand;
	}

	private Interchange parseInterchange(String[] csvLine) {
		Interchange interchange = new Interchange();
		interchange.setInterchangePath(InterchangePath.valueOfPath(csvLine[0]));
		interchange.setActualFlow(Double.parseDouble(csvLine[1]));
		return interchange;
	}

	private GenerationGroup parseGenerationGroup(String[] csvLine) {
		GenerationGroup genGroup = new GenerationGroup();
		genGroup.setGeneratorType(GeneratorType.valueOf(csvLine[0]));
		genGroup.setMaximumCapability(Double.parseDouble(csvLine[1]));
		genGroup.setTotalNetGeneration(Double.parseDouble(csvLine[2]));
		genGroup.setDispatchedContingencyReserve(Double.parseDouble(csvLine[3]));
		return genGroup;
	}

	/**
	 * Converts the "Last Update" string from CSV file into a proper
	 * {@link Date} object using {@link #CANADA_MOUNTAIN_TIME_ZONE} via
	 * {@link #simpleDateFormat}.
	 * 
	 * @param csvColumnString
	 * @return {@link Date}
	 */
	private Date parseLastUpdate(String csvColumnString) {
		csvColumnString = csvColumnString.replace("Last Update : ", "");
		csvColumnString = csvColumnString.trim();
		Date lastUpdate = null;
		try {
			return simpleDateFormat.parse(csvColumnString);
		} catch (ParseException e) {
			logger.error("Could not parse Last Update String: "
					+ e.getLocalizedMessage());
		}
		return lastUpdate;
	}
}
