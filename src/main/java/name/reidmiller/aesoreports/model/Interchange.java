package name.reidmiller.aesoreports.model;

public class Interchange {
	private InterchangePath interchangePath;
	private double actualFlow;
	
	@Override
	public String toString() {
		StringBuffer stringBuf = new StringBuffer();
		stringBuf.append("\"Interchange\": {");
		stringBuf.append("\"interchangePath\": " + this.interchangePath + ", ");
		stringBuf.append("\"actualFlow\": " + this.actualFlow + "}");
		return stringBuf.toString();
	}

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