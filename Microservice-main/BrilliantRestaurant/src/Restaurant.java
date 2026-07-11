
public class Restaurant {
	private String customerName;
	private int orderNumber;
	private String deliveryType;
	private String foodName;
	private long phoneNumber;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Restaurant(String customerName, int orderNumber, String deliveryType, String foodName, long phoneNumber) {
		super();
		this.customerName = customerName;
		this.orderNumber = orderNumber;
		this.deliveryType = deliveryType;
		this.foodName = foodName;
		this.phoneNumber = phoneNumber;
	}

	public double calculateTotalBill(double cost) {

		if (this.deliveryType.equals("HomeDelivery")) {
			cost = cost + (cost * 0.8);
		} else if (this.deliveryType.equals("Parcel")) {
			cost = cost + (cost * 0.5);
		} else if (this.deliveryType.equals("NormalOrder")) {
			cost = cost + (cost * 0.3);
		}

		return cost;
	}
}
