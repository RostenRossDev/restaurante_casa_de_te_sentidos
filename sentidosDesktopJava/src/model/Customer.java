package model;

public class Customer {

	public String name;
    public String lastname;
    public String username;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", lastname=" + lastname + ", username=" + username + "]";
	}
    
    
}
