package storeApp.User;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import storeApp.action.Action;
import storeApp.order.Order;
import storeApp.store.Store;

@Entity
@Inheritance
public class User {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int ID;
	public String username;
	public String password;
	public String type;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public Set<Order> orders;
	
	@ManyToMany(mappedBy = "collaborators")
	public Set<Store> stores;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public Set<Action> actions;
	
	public User() {};
	
	public User(String username, String password, String type)
	{
		this.username = username;
		this.password = password;
		this.type = type;
		
	}
	
}
