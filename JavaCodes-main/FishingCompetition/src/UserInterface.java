import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the details");
		String details = sc.nextLine();

		String detailsArr[] = details.split(":");
		String name = detailsArr[0];
		int age = Integer.parseInt(detailsArr[1]);
		if (age <= 17) {
			System.out.println(age + " is an invalid age");
			sc.close();
			return;
		}
		if (Integer.parseInt(detailsArr[2]) < 0) {
			System.out.println(detailsArr[2] + " is an invalid input");
			sc.close();
			return;
		}
		if (Integer.parseInt(detailsArr[3]) < 0) {
			System.out.println(detailsArr[3] + " is an invalid input");
			sc.close();
			return;
		}
		if (Integer.parseInt(detailsArr[4]) < 0) {
			System.out.println(detailsArr[4] + " is an invalid input");
			sc.close();
			return;
		}

		int bigFish = Integer.parseInt(detailsArr[2]) * 10;
		int mediumFish = Integer.parseInt(detailsArr[3]) * 6;
		int smallFish = Integer.parseInt(detailsArr[4]) * 3;

		int totalPoints = bigFish + mediumFish + smallFish;
		System.out.println(name + " scored " + totalPoints + " points");
		sc.close();
	}

}
