import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the component name ");
		String name = sc.next();
		System.out.println("Enter the component weight on earth ");
		double weight = sc.nextDouble();
		
		RocketComponent rc = new RocketComponent();
		double mass = rc.calculateMassOfRocketComponent(weight);
		if(mass == -1) {
			System.out.println(weight + " Newton is an invalid weight");
			sc.close();
			return;
		}
		System.out.println("Enter the material used ");
		String material = sc.next();
		System.out.println("Enter the cost of production ");
		double cost = sc.nextDouble();
		
		rc = new RocketComponent(name, weight, material, cost);
		System.out.println("Rocket Component");
		System.out.println("Name : " + name);
		System.out.println("Weight : " + weight + " Newton");
		System.out.println(
				"Acceleration Due To Gravity : " + rc.getAccelerationDueToGravity() + " meters per second square ");
		System.out.println("Mass : " + mass + " kg");
		System.out.println("Material Used : " + material);
		System.out.println("Cost Of Production : Rs." + cost);
		sc.close();
	}

}
