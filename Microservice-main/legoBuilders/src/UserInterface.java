import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product Id");
		String id = sc.next();
		System.out.println("Enter the Product Type");
		String type = sc.next();

		if (type.equals("ElectricalItem")) {
			System.out.println("Enter the Product Name");
			String name = sc.next();
			System.out.println("Enter the Quantity");
			int quantity = sc.nextInt();
			System.out.println("Enter the Price");
			double price = sc.nextDouble();

			ElectricalItemDetails eid = new ElectricalItemDetails(id, type, name, quantity, price);
			double totalBill = eid.calculateTotalBill();
			if (totalBill != 0) {
				System.out.println("Bill Amount is " + totalBill);
				sc.close();
				return;
			} else {
				System.out.println("Product not available");
			}
		} else if (type.equals("PlumbingItem")) {
			System.out.println("Enter the Product Name");
			String name = sc.next();
			System.out.println("Enter the Quantity");
			int quantity = sc.nextInt();
			System.out.println("Enter the Price");
			double price = sc.nextDouble();

			PlumbingItemDetails pid = new PlumbingItemDetails(id, type, name, quantity, price);
			double totalBill = pid.calculateTotalBill();
			if (totalBill != 0) {
				System.out.println("Bill Amount is " + totalBill);
				sc.close();
				return;
			} else {
				System.out.println("Product not available");
			}
		} else {
			System.out.println(type + " is an invalid product type");
			sc.close();
			return;
		}
		sc.close();
	}
}
