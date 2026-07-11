import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Order order = new Order();
		System.out.println("Enter dress code");
		String orderDressCode = sc.next();
		System.out.println("Enter dress style");
		String orderStyle = sc.next();
		System.out.println("Enter dress material");
		String orderMaterial = sc.next();
		System.out.println("Enter dress price");
		double orderPrice = sc.nextDouble();
		System.out.println("Prefered size is XL(Yes/No)");
		String choice = sc.next();

		while (!choice.equalsIgnoreCase("Yes") && !choice.equalsIgnoreCase("No")) {
			System.out.println("Wrong Input");
			System.out.println("Prefered size is XL(Yes/No)");
			choice = sc.next();
		}

		if (choice.equalsIgnoreCase("Yes")) {
			order = new Order(orderDressCode, orderStyle, orderMaterial, orderPrice);
		} else if (choice.equalsIgnoreCase("No")) {
			System.out.println("Enter the dress size");
			String orderSize = sc.next();
			double finalPrice = orderPrice;
			if (orderSize.equalsIgnoreCase("XXL") || orderSize.equalsIgnoreCase("XXXL")
					|| orderSize.equalsIgnoreCase("XXXXL")) {
				finalPrice += 100;
			}
			order = new Order(orderDressCode, orderStyle, orderMaterial, orderSize, finalPrice);
		}

		System.out.println("Dress code :" + order.getDressCode());
		System.out.println("Dress Style :" + order.getStyle());
		System.out.println("Material Type :" + order.getMaterial());
		System.out.println("Dress Size :" + order.getSize());
		System.out.println("Price :" + order.getPrice());
		sc.close();
	}

}
