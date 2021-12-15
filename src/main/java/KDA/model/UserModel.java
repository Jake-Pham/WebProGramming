package KDA.model;

public class UserModel {
	private int uid;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private String adrs;
	private int isSell;
	private int isAdmin;
	public UserModel() {
		super();
	}
	public UserModel(int uid, String fname, String lname, String email, String pass, String adrs, int isSell,
			int isAdmin) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.adrs = adrs;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "UserModel [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass=" + pass
				+ ", adrs=" + adrs + ", isSell=" + isSell + ", isAdmin=" + isAdmin + "]";
	}
	
}
