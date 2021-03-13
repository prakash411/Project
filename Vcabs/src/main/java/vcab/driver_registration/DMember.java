package vcab.driver_registration;

public class DMember {
	
	private String uname, phone, email,vpn, password;

	
	public DMember() {
		super();
	}

	public DMember(String uname, String phone, String email,String vpn, String password) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.email = email;
		this.vpn=vpn;
		this.password = password;
	}

	

	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
