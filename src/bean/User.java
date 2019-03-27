package bean;

public class User {

	private String username;
	private String password;

	public User() {
		System.out.println("D.C");
	}

	public User(int id, String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		System.out.println("G U");
		return username;
	}

	public void setUsername(String username) {
		System.out.println("S U");
		this.username = username;
	}

	public String getPassword() {
		System.out.println("G P");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("S P");
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
