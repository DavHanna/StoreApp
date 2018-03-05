package storeApp.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int ID;
	public String username;
	public String password;
	public String type;
	
	public User() {};
	
	public User(String username, String password, String type)
	{
		this.username = username;
		this.password = password;
		this.type = type;
		
	}
	
}
