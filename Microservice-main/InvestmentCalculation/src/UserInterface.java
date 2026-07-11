import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of company shares you bought");
		int n = sc.nextInt();

		System.out.println("Enter total number of shares");
		int totalShares = sc.nextInt();

		Investment.setNoOfShares(totalShares);

		for (int i = 1; i <= n; i++) {

			Investment inv = new Investment();

			System.out.println("Enter the company id");
			inv.setCompanyId(sc.nextInt());

			System.out.println("Enter the company name");
			inv.setCompanyName(sc.next());

			System.out.println("Enter the number of shares you bought");
			int sharesBought = sc.nextInt();

			System.out.println("Enter the value of one share");
			inv.setValueOfOneShare(sc.nextDouble());

			System.out.println("Total number of shares=" + Investment.getNoOfShares());

			double totalAmount = inv.calculateTotalAmountOfInvestment(sharesBought);

			if (totalAmount == -1) {
				System.out.println("Shares not available");
				return;
			}

			System.out.println("Total amount of investment=" + totalAmount);
			System.out.println("Remaining Available shares=" + Investment.getNoOfShares());
		}

		sc.close();
	}
}