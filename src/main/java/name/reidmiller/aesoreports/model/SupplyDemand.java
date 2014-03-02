package name.reidmiller.aesoreports.model;

import java.util.Date;
import java.util.List;

public class SupplyDemand {
	private Date lastUpdate;
	private Summary summary;
	private List<GenerationGroup> generationGroups;
	private List<Interchange> interchanges;
	private List<GenerationUnit> generationUnits;

	@Override
	public String toString() {
		StringBuffer stringBuf = new StringBuffer();
		stringBuf.append("\"Summary\": {");
		stringBuf.append("\"lastUpdate\": \"" + this.lastUpdate + "\", ");
		stringBuf.append("\"summary\": {" + this.summary.toString() + "}, ");
		
		if (this.generationGroups != null) {
			stringBuf.append("\"generationGroups\": [");
			for (GenerationGroup generationGroup : this.generationGroups) {
				stringBuf.append("{" + generationGroup.toString() + "}, ");
			}
			stringBuf.append("], ");
		} else {
			stringBuf.append("\"generationGroups\": \"null\", ");
		}
		
		if (this.interchanges != null) {
			stringBuf.append("\"interchanges\": [");
			for (Interchange interchange : this.interchanges) {
				stringBuf.append("{" + interchange.toString() + "}, ");
			}
			stringBuf.append("], ");
		} else {
			stringBuf.append("\"interchanges\": \"null\", ");
		}
		
		if (this.generationUnits != null) {
			stringBuf.append("\"generationUnits\": [");
			for (GenerationUnit generationUnit : this.generationUnits) {
				stringBuf.append("{" + generationUnit.toString() + "}, ");
			}
			stringBuf.append("]");
		} else {
			stringBuf.append("\"generationUnits\": \"null\"");
		}
		
		stringBuf.append("}");
		return stringBuf.toString();
	}

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