package KDA.model;

public class ShipModel {
	private int id;
	private String city;
	private int price;
	public ShipModel(int id, String city, int price) {
		super();
		this.id = id;
		this.city = city;
		this.price = price;
	}
	public ShipModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ShipModel [id=" + id + ", city=" + city + ", price=" + price + "]";
	}
	
}
