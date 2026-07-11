public class Investment {

	private int companyId;
	private String companyName;
	private static int noOfShares;
	private double valueOfOneShare;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public static int getNoOfShares() {
		return noOfShares;
	}

	public static void setNoOfShares(int noOfShares) {
		if (noOfShares > 0)
			Investment.noOfShares = noOfShares;
	}

	public double getValueOfOneShare() {
		return valueOfOneShare;
	}

	public void setValueOfOneShare(double valueOfOneShare) {
		this.valueOfOneShare = valueOfOneShare;
	}

	public double calculateTotalAmountOfInvestment(int sharesBought) {

		if (sharesBought <= noOfShares) {
			noOfShares -= sharesBought;
			double total = sharesBought * valueOfOneShare;
			return Math.round(total * 10.0) / 10.0;
		}

		return -1;
	}
}
