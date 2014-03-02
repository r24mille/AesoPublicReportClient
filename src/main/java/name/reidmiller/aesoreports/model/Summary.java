package name.reidmiller.aesoreports.model;


public class Summary {
	private double albertaTotalNetGeneration;
	private double interchange;
	private double albertaInternalLoad;
	private double albertaLoadResponsibility;
	private double contingencyreserveRequired;
	private double dispatchedContingencyReserve;
	private double dispatchedContingencyReserveGen;
	private double dispatchedContingencyReserveOther;
	private double lssiArmedDispatch;
	private double lssiOfferedVolume;
	
	@Override
	public String toString() {
		StringBuffer stringBuf = new StringBuffer();
		stringBuf.append("\"Summary\": {");
		stringBuf.append("\"albertaTotalNetGeneration\": " + this.albertaTotalNetGeneration + ", ");
		stringBuf.append("\"interchange\": " + this.interchange + ", ");
		stringBuf.append("\"albertaInternalLoad\": " + this.albertaInternalLoad + ", ");
		stringBuf.append("\"albertaLoadResponsibility\": " + this.albertaLoadResponsibility + ", ");
		stringBuf.append("\"contingencyreserveRequired\": " + this.contingencyreserveRequired + ", ");
		stringBuf.append("\"dispatchedContingencyReserve\": " + this.dispatchedContingencyReserve + ", ");
		stringBuf.append("\"dispatchedContingencyReserveGen\": " + this.dispatchedContingencyReserveGen + ", ");
		stringBuf.append("\"dispatchedContingencyReserveOther\": " + this.dispatchedContingencyReserveOther + ", ");
		stringBuf.append("\"lssiArmedDispatch\": " + this.lssiArmedDispatch + ", ");
		stringBuf.append("\"lssiOfferedVolume\": " + this.lssiOfferedVolume);
		stringBuf.append("}");
		return stringBuf.toString();
	}

	public double getAlbertaTotalNetGeneration() {
		return albertaTotalNetGeneration;
	}

	public void setAlbertaTotalNetGeneration(double albertaTotalNetGeneration) {
		this.albertaTotalNetGeneration = albertaTotalNetGeneration;
	}

	public double getInterchange() {
		return interchange;
	}

	public void setInterchange(double interchange) {
		this.interchange = interchange;
	}

	public double getAlbertaInternalLoad() {
		return albertaInternalLoad;
	}

	public void setAlbertaInternalLoad(double albertaInternalLoad) {
		this.albertaInternalLoad = albertaInternalLoad;
	}

	public double getAlbertaLoadResponsibility() {
		return albertaLoadResponsibility;
	}

	public void setAlbertaLoadResponsibility(double albertaLoadResponsibility) {
		this.albertaLoadResponsibility = albertaLoadResponsibility;
	}

	public double getContingencyreserveRequired() {
		return contingencyreserveRequired;
	}

	public void setContingencyreserveRequired(double contingencyreserveRequired) {
		this.contingencyreserveRequired = contingencyreserveRequired;
	}

	public double getDispatchedContingencyReserve() {
		return dispatchedContingencyReserve;
	}

	public void setDispatchedContingencyReserve(
			double dispatchedContingencyReserve) {
		this.dispatchedContingencyReserve = dispatchedContingencyReserve;
	}

	public double getDispatchedContingencyReserveGen() {
		return dispatchedContingencyReserveGen;
	}

	public void setDispatchedContingencyReserveGen(
			double dispatchedContingencyReserveGen) {
		this.dispatchedContingencyReserveGen = dispatchedContingencyReserveGen;
	}

	public double getDispatchedContingencyReserveOther() {
		return dispatchedContingencyReserveOther;
	}

	public void setDispatchedContingencyReserveOther(
			double dispatchedContingencyReserveOther) {
		this.dispatchedContingencyReserveOther = dispatchedContingencyReserveOther;
	}

	public double getLssiArmedDispatch() {
		return lssiArmedDispatch;
	}

	public void setLssiArmedDispatch(double lssiArmedDispatch) {
		this.lssiArmedDispatch = lssiArmedDispatch;
	}

	public double getLssiOfferedVolume() {
		return lssiOfferedVolume;
	}

	public void setLssiOfferedVolume(double lssiOfferedVolume) {
		this.lssiOfferedVolume = lssiOfferedVolume;
	}
}
