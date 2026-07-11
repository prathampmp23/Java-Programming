import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius");
		int radius = sc.nextInt();
		System.out.println("Enter the height");
		int height = sc.nextInt();

		if (radius <= 0 || height <= 0) {
			System.out.println("Invalid measurement");
			sc.close();
            return;

		} else {
			double Pi = 3.14;
			double total = Pi * radius * radius * height;
			double capacity = total * 0.75;
			System.out.printf("Total capacity is %.2f litres", total);
			System.out.println();
			System.out.printf("Capacity for alarm is %.2f litres", capacity);
			sc.close();
		}
	}

}
