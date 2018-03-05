package storeApp.User;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
	
	public Admin() {};
	
	public Admin(String username, String password)
	{
		this.username = username;
		this.password = password;
		this.type = "admin";
		
	}
}
