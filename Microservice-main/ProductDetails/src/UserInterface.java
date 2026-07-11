import java.util.Scanner;

public class UserInterface {

	public static boolean validateProductPrice(int price) {
		try {
			if (price < 1 || price > 20) {
				throw new InvalidPriceException("Product price is invalid");
			} else {
				return true;
			}
		} catch (InvalidPriceException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of product entries");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter product " + i + " details");
			String product = sc.next();
			String details[] = product.split(":");
			if (validateProductPrice(Integer.parseInt(details[2]))) {
				System.out.println("Stock updated");
			}
		}
		sc.close();
	}

}
