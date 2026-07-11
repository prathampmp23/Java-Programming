import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the network provider name:");
		String provider = sc.nextLine();

		System.out.println("Enter the plan name:");
		String planName = sc.nextLine();

		System.out.println("Enter the talk time plan:");
		String talkTime = sc.nextLine();

		System.out.println("Enter the data plan(in GB):");
		int data = sc.nextInt();

		System.out.println("Enter the SMS plan(per/day):");
		int sms = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter the plan type:");
		String planType = sc.nextLine();

		if (planType.equalsIgnoreCase("prepaidPlan")) {

			System.out.println("Enter the validity(in days):");
			int validity = sc.nextInt();

			System.out.println("Enter the extra data provided(in GB):");
			double extraData = sc.nextDouble();

			PrepaidPlan p = new PrepaidPlan(provider, planName, talkTime, data, sms, planType, validity, extraData);

			double amount = p.findPlanAmount();

			if (amount == -1) {
				System.out.println("Invalid prepaid plan Details");
				sc.close();
				return;
			}

			System.out.println("Provider Name - " + provider);
			System.out.println("Plan Name - " + planName);
			System.out.println("Talk Time - " + talkTime);
			System.out.println("Data for the plan (per day) - " + data + " GB");
			System.out.println("SMS for the plan - " + sms + " SMS per day");
			System.out.println("Plan type - " + planType);
			System.out.println("Validity for the plan - " + validity + " days");
			System.out.println("Extra data for the plan - " + extraData + " GB");
			System.out.printf("Plan Amount to be paid for %s plan is Rs %.1f", planName, amount);

		} else if (planType.equalsIgnoreCase("postpaidplan")) {

			System.out.println("Do you want to roll over unused data");
			String rollover = sc.nextLine();

			PostpaidPlan p = new PostpaidPlan(provider, planName, talkTime, data, sms, planType, rollover);

			double amount = p.findPlanAmount();

			if (amount == -1) {
				System.out.println("Invalid postpaid plan Details");
				sc.close();
				return;
			}

			System.out.println("Provider Name - " + provider);
			System.out.println("Plan Name - " + planName);
			System.out.println("Talk Time - " + talkTime);
			System.out.println("Data for the plan (per day) - " + data + " GB");
			System.out.println("SMS for the plan - " + sms + " SMS per day");
			System.out.println("Plan type - " + planType);
			System.out.println("want to roll over unused data - " + rollover);
			System.out.println("Subscription for the plan - " + p.getSubscription());
			System.out.printf("Plan Amount to be paid for %s plan is Rs %.1f", planName, amount);
		} else {
			System.out.println("Please provide a valid plan details");
		}
		sc.close();
	}
}