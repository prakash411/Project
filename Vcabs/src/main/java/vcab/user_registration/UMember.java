package vcab.user_registration;

import java.io.FileInputStream;

public class UMember {
	
	private String uname, phone, email, password;
	
	public UMember() {
		super();
	}

	public UMember(String uname, String phone, String email, String password) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.email = email;
		this.password = password;
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
