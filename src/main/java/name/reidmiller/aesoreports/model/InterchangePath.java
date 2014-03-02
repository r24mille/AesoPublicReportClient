package name.reidmiller.aesoreports.model;

public enum InterchangePath {
	BRITISH_COLUMBIA, MONTANA, SASKATCHEWAN;
	
	/**
	 * PATH values from CSV data have spaces and mixed case, which does not
	 * translate well to the default {@link #valueOf(String)} method. This
	 * method performs appropriate String manipulations before calling
	 * {@link #valueOf(String)}.
	 * 
	 * @param str
	 *            CATEGORY String from Current Supply Demand Report CSV.
	 * @return InterchangePath appropriate for provided String.
	 */
	public static InterchangePath valueOfPath(String str) {
		return InterchangePath.valueOf(str.toUpperCase().replaceAll(" ", "_"));
	}
}
