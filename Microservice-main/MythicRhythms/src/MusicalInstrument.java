
abstract public class MusicalInstrument {

	private int instrumentId;
	private String instrumentName;
	private String instrumentType;
	private double price;
	private Customer customerObj;

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomerObj() {
		return customerObj;
	}

	public void setCustomerObj(Customer customerObj) {
		this.customerObj = customerObj;
	}
	
	public MusicalInstrument() {
		super();
	}

	public MusicalInstrument(int instrumentId, String instrumentName, String instrumentType, double price,
			Customer customerObj) {
		super();
		this.instrumentId = instrumentId;
		this.instrumentName = instrumentName;
		this.instrumentType = instrumentType;
		this.price = price;
		this.customerObj = customerObj;
	}

	abstract public double calculateTotalBill();
}
