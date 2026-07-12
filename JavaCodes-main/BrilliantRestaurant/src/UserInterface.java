import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name");
		String name = sc.next();
		System.out.println("Enter the Order Number");
		int orderNumber = sc.nextInt();
		System.out.println("Enter the Delivery Type");
		String deliveryType = sc.next();
		if (!deliveryType.equals("HomeDelivery") && !deliveryType.equals("Parcel")
				&& !deliveryType.equals("NormalOrder")) {
			System.out.println("Invalid Order Type");
			sc.close();
			return;
		}
		System.out.println("Enter the Food Name");
		String foodName = sc.next();
		System.out.println("Enter the Phone Number");
		long phonenumber = sc.nextLong();
		Restaurant restaurant = new Restaurant(name, orderNumber, deliveryType, foodName, phonenumber);

		System.out.println("Enter the price of the item");
		double cost = sc.nextDouble();
		Double BilTotal = restaurant.calculateTotalBill(cost);
		System.out.println("Name " + name);
		System.out.println("Order Number " + orderNumber);
		System.out.println("Delivery Type " + deliveryType);
		System.out.println("Food Name " + foodName);
		System.out.println("Phone Number " + phonenumber);
		System.out.println("Bill Amount " + BilTotal);
		sc.close();
	}

}
