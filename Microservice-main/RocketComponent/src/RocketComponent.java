
public class RocketComponent {

	private String name;
	private double weight;
	private final double accelerationDueToGravity = 9.8;
	private String material;
	private double costOfProduction;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getCostOfProduction() {
		return costOfProduction;
	}

	public void setCostOfProduction(double costOfProduction) {
		this.costOfProduction = costOfProduction;
	}

	public double getAccelerationDueToGravity() {
		return accelerationDueToGravity;
	}
	
	public RocketComponent() {
	}

	public RocketComponent(String name, double weight, String material, double costOfProduction) {
		super();
		this.name = name;
		this.weight = weight;
		this.material = material;
		this.costOfProduction = costOfProduction;
	}

	public double calculateMassOfRocketComponent(double weight) {
		if(weight > 1) {
			double Mass = weight / accelerationDueToGravity;
			return Math.round(Mass * 100.0) / 100.0;
		} 
		return -1;
	}
}
