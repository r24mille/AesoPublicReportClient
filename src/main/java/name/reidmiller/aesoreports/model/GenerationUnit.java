package name.reidmiller.aesoreports.model;

public class GenerationUnit {
	private GeneratorType generatorType;
	private String unitName;
	private double maximumCapability;
	private double totalNetGeneration;
	private double dispatchedContingencyReserve;

	public GeneratorType getGeneratorType() {
		return generatorType;
	}

	public void setGeneratorType(GeneratorType generatorType) {
		this.generatorType = generatorType;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public double getMaximumCapability() {
		return maximumCapability;
	}

	public void setMaximumCapability(double maximumCapability) {
		this.maximumCapability = maximumCapability;
	}

	public double getTotalNetGeneration() {
		return totalNetGeneration;
	}

	public void setTotalNetGeneration(double totalNetGeneration) {
		this.totalNetGeneration = totalNetGeneration;
	}

	public double getDispatchedContingencyReserve() {
		return dispatchedContingencyReserve;
	}

	public void setDispatchedContingencyReserve(
			double dispatchedContingencyReserve) {
		this.dispatchedContingencyReserve = dispatchedContingencyReserve;
	}
}