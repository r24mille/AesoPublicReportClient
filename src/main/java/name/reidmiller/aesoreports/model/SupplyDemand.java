package name.reidmiller.aesoreports.model;

import java.util.Date;
import java.util.List;

public class SupplyDemand {
	private Date lastUpdate;
	private Summary summary;
	private List<GenerationGroup> generationGroups;
	private List<Interchange> interchanges;
	private List<GenerationUnit> generationUnits;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public List<GenerationGroup> getGenerationGroups() {
		return generationGroups;
	}

	public void setGenerationGroups(List<GenerationGroup> generationGroups) {
		this.generationGroups = generationGroups;
	}

	public List<Interchange> getInterchanges() {
		return interchanges;
	}

	public void setInterchanges(List<Interchange> interchanges) {
		this.interchanges = interchanges;
	}

	public List<GenerationUnit> getGenerationUnits() {
		return generationUnits;
	}

	public void setGenerationUnits(List<GenerationUnit> generationUnits) {
		this.generationUnits = generationUnits;
	}
}