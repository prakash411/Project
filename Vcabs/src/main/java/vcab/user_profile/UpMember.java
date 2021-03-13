package vcab.user_profile;

public class UpMember {

	private String uname,  email,password;

	public UpMember() {
		super();
	}

	public UpMember(String uname, String email, String password) {
		super();
		this.uname = uname;
		this.email = email;
		this.password=password;
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

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
