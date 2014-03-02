package name.reidmiller.aesoreports.model;

public class GenerationGroup {
	private GeneratorType generatorType;
	private double maximumCapability;
	private double totalNetGeneration;
	private double dispatchedContingencyReserve;
	
	public GeneratorType getGeneratorType() {
		return generatorType;
	}
	public void setGeneratorType(GeneratorType generatorType) {
		this.generatorType = generatorType;
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
	public void setDispatchedContingencyReserve(double dispatchedContingencyReserve) {
		this.dispatchedContingencyReserve = dispatchedContingencyReserve;
	}
}