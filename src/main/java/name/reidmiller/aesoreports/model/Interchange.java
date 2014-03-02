package name.reidmiller.aesoreports.model;

public class Interchange {
	private InterchangePath interchangePath;
	private double actualFlow;

	public InterchangePath getInterchangePath() {
		return interchangePath;
	}

	public void setInterchangePath(InterchangePath interchangePath) {
		this.interchangePath = interchangePath;
	}

	public double getActualFlow() {
		return actualFlow;
	}

	public void setActualFlow(double actualFlow) {
		this.actualFlow = actualFlow;
	}
}