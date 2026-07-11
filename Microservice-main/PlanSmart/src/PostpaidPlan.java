import java.util.HashMap;
import java.util.Map;

public class PostpaidPlan extends PhonePlan {
	private String dataCarryOver;
	private String subscription;

	public PostpaidPlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType,
			String dataCarryOver) {
		super(providerName, planName, talkTime, data, smsPerDay, planType);
		this.dataCarryOver = dataCarryOver;
	}

	public String getDataCarryOver() {
		return dataCarryOver;
	}

	public void setDataCarryOver(String dataCarryOver) {
		this.dataCarryOver = dataCarryOver;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	private static final Map<String, PlanDetails> PLAN_MAP = new HashMap<>();

	static {
		// AIRTEL
		PLAN_MAP.put("AIRTEL_REGULAR-POSTPAY", new PlanDetails(399.0, "Wynk Music"));
		PLAN_MAP.put("AIRTEL_FAMILY PLAN FOR 2", new PlanDetails(599.0, "Wynk Music,Prime"));
		PLAN_MAP.put("AIRTEL_FAMILY PLAN FOR 5", new PlanDetails(999.0, "Wynk Music,Prime,Extra 5GB data"));
		PLAN_MAP.put("AIRTEL_FAMILY PLAN FOR 8", new PlanDetails(1599.0, "Wynk Music,Prime,Netflix,Extra 10GB data"));

		// JIO
		PLAN_MAP.put("JIO_REGULAR-POSTPAY", new PlanDetails(500.0, "Jio Saavn"));
		PLAN_MAP.put("JIO_FAMILY PLAN FOR 2", new PlanDetails(720.0, "Jio Saavn,Amazon Prime,Extra 3GB data"));
		PLAN_MAP.put("JIO_FAMILY PLAN FOR 5", new PlanDetails(980.0, "Jio Saavn,Amazon Prime,Jio Apps,Extra 5GB data"));
		PLAN_MAP.put("JIO_FAMILY PLAN FOR 8", new PlanDetails(1650.0, "Jio Saavn,Amazon Prime,Netflix,Jio Apps,Extra 10GB data"));
	}

	@Override
	public double findPlanAmount() {
		String key = providerName.toUpperCase() + "_" + planName.toUpperCase();

		PlanDetails details = PLAN_MAP.get(key);
		if (details == null) {
			return -1;
		}

		this.subscription = details.subscription;
		return details.cost;
	}
}

class PlanDetails {
	double cost;
	String subscription;

	PlanDetails(double cost, String subscription) {
		this.cost = cost;
		this.subscription = subscription;
	}
}