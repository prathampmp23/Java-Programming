
public class Order {
	private String dressCode;
	private String style;
	private String material;
	private String size;
	private double price;

	public String getDressCode() {
		return dressCode;
	}

	public void setDressCode(String dressCode) {
		this.dressCode = dressCode;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order() {
		super();
	}

//	With Default size XL
	public Order(String dressCode, String style, String material, double price) {
		super();
		this.dressCode = dressCode;
		this.style = style;
		this.material = material;
		this.size = "XL";
		this.price = price;
	}

//	Other size than XL
	public Order(String dressCode, String style, String material, String size, double price) {
		super();
		this.dressCode = dressCode;
		this.style = style;
		this.material = material;
		this.size = size;
		this.price = price;

	}

}
