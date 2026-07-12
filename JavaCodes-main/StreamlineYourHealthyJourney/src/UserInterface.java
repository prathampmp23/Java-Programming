import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.nextLine();
		System.out.println("Enter your height in meters");
		float height = sc.nextFloat();
		System.out.println("Enter your weight in kilograms");
		float weight = sc.nextFloat();

		float BMI = weight / (height * height);

		System.out.printf("Hello %s, Your BMI is %.2f%n", name, BMI);

		if (BMI < 18.5) {
			System.out.println("You are under the category Under weight");
		} else if (BMI < 25) {
			System.out.println("You are under the category Normal weight");
		} else if (BMI <= 30) {
			System.out.println("You are under the category Over weight");
		} else {
			System.out.println("You are under the category Obese");
		}
		sc.close();
	}
}
