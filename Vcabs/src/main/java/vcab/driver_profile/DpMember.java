package vcab.driver_profile;

public class DpMember {

	private String uname, phone, email,password,vpn;

	public DpMember() {
		super();
	}

	public DpMember(String uname, String phone, String email, String password,String vpn) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.email = email;
		this.password=password;
		this.vpn=vpn;
	}
	
	
	
	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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
}
