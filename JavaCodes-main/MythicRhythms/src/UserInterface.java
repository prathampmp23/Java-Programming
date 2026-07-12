
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Customer Details");
		String customerDetails = sc.nextLine();

		System.out.println("Enter the musical Instrument Details");
		String instrumentDetails = sc.nextLine();

		String custDetails[] = customerDetails.split(":");
		String instDetails[] = instrumentDetails.split(":");

		if (!instDetails[5].equals("Nylon")  && !instDetails[5].equals("Steel")) {
			System.out.println("Invalid Input");
			sc.close();
			return;
		}
		Customer customer = new Customer(Integer.parseInt(custDetails[0]), custDetails[1],
				Long.parseLong(custDetails[2]));
		StringInstrument si = new StringInstrument(Integer.parseInt(instDetails[0]), instDetails[1], instDetails[2],
				Double.parseDouble(instDetails[3]), customer, Integer.parseInt(instDetails[4]), instDetails[5]);

		if (Double.parseDouble(instDetails[3]) > 20000) {
			System.out.println("You have a discount! and your Total Bill is " + si.calculateTotalBill());
		} else {
			System.out.println("Total Bill is " + si.calculateTotalBill());
		}
		sc.close();
	}
}
