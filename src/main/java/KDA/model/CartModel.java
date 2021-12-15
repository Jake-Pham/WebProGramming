package KDA.model;

public class CartModel {
	private int id;
	private String name;
	private String image;
	private int unitPrice;
	private int quantity;
	private int price;
	private int billID;
	public CartModel(int id, String name, String image, int unitPrice, int quantity, int price, int billID) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.price = price;
		this.billID = billID;
	}
	public CartModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	@Override
	public String toString() {
		return "CartModel [id=" + id + ", name=" + name + ", image=" + image + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", price=" + price + ", billID=" + billID + "]";
	}
	
}
