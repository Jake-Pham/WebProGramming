package KDA.model;

public class InformationModel {
	private int id;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	private String adrs;
	private String city;
	public InformationModel(int id, String fname, String lname, String phone, String email, String adrs, String city) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.adrs = adrs;
		this.city = city;
	}
	public InformationModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "InformationModel [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", email="
				+ email + ", adrs=" + adrs + ", city=" + city + "]";
	}
	
}
