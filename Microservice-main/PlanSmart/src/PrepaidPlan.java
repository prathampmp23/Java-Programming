import java.util.HashMap;
import java.util.Map;

public class PrepaidPlan extends PhonePlan {
	private int validity;
	private double extraData;

	public PrepaidPlan(String providerName, String planName, String talkTime, int data, int smsPerDay, String planType,
			int validity, double extraData) {
		super(providerName, planName, talkTime, data, smsPerDay, planType);
		this.validity = validity;
		this.extraData = extraData;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public double getExtraData() {
		return extraData;
	}

	public void setExtraData(double extraData) {
		this.extraData = extraData;
	}

	private static final Map<String, Double> PRICE_MAP = new HashMap<>();

	static {
		// AIRTEL
		PRICE_MAP.put("AIRTEL_2_28", 299.0);
		PRICE_MAP.put("AIRTEL_2_56", 549.0);
		PRICE_MAP.put("AIRTEL_2_84", 839.0);
		PRICE_MAP.put("AIRTEL_3_28", 399.0);
		PRICE_MAP.put("AIRTEL_3_56", 649.0);
		PRICE_MAP.put("AIRTEL_3_84", 939.0);

		// JIO
		PRICE_MAP.put("JIO_2_28", 389.0);
		PRICE_MAP.put("JIO_2_56", 620.0);
		PRICE_MAP.put("JIO_2_84", 939.0);
		PRICE_MAP.put("JIO_3_28", 400.0);
		PRICE_MAP.put("JIO_3_56", 749.0);
		PRICE_MAP.put("JIO_3_84", 839.0);
	}

	@Override
	public double findPlanAmount() {
		String key = providerName.toUpperCase() + "_" + data + "_" + validity;
		return PRICE_MAP.getOrDefault(key, -1.0);
	}
}
