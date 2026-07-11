
public class StringInstrument extends MusicalInstrument {

	private int numberOfStrings;
	private String stringMaterial;

	public int getNumberOfStrings() {
		return numberOfStrings;
	}

	public void setNumberOfStrings(int numberOfStrings) {
		this.numberOfStrings = numberOfStrings;
	}

	public String getStringMaterial() {
		return stringMaterial;
	}

	public void setStringMaterial(String stringMaterial) {
		this.stringMaterial = stringMaterial;
	}

	public StringInstrument(int instrumentId, String instrumentName, String instrumentType, double price,
			Customer customerObj, int numberOfStrings, String stringMaterial) {
		super(instrumentId, instrumentName, instrumentType, price, customerObj);
		this.numberOfStrings = numberOfStrings;
		this.stringMaterial = stringMaterial;
	}

	@Override
	public double calculateTotalBill() {
		if (stringMaterial.equals("Nylon")) {
			double totalBill = super.getPrice() + (15 * numberOfStrings);
			if (super.getPrice() > 20000)
				totalBill = totalBill - (totalBill * 0.30); // 30% discount
			super.setPrice(totalBill);
			return totalBill;
		} else if (stringMaterial.equals("Steel")) {
			double totalBill = super.getPrice() + (20 * numberOfStrings);
			if (super.getPrice() > 20000)
				totalBill = totalBill - (totalBill * 0.30); // 30% discount
			super.setPrice(totalBill);
			return totalBill;
		}
		return -1;
	}
}
