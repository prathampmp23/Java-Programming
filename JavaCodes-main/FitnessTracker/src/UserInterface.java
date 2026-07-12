import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter user name:");
		String userName = sc.nextLine();
		System.out.println("Enter weight in kg:");
		double weight = sc.nextDouble();
		System.out.println("Enter number of steps taken:");
		int stepsTaken = sc.nextInt();
		System.out.println("Enter distance covered in km:");
		double distanceCovered = sc.nextDouble();
		System.out.println("Is the user running?(true/false):");
		boolean runningStatus = sc.nextBoolean();

		UserFitnessData uf = new UserFitnessData(userName, weight, stepsTaken, distanceCovered, runningStatus);
		System.out.println("User Name: " + userName);
		System.out.println("Weight: " + weight + " kg");
		System.out.println("Steps Taken: " + stepsTaken);
		System.out.println("Distance Covered: " + distanceCovered + " km");
		System.out.println("Running: " + runningStatus);
		System.out.println("Fitness Level: " + uf.findFitnessLevel());
		System.out.println("Calories Burnt: " + FitnessMonitor.calculateCaloriesBurnt(weight, distanceCovered, runningStatus));
		sc.close();
	}
}
