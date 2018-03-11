package storeApp.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String name;
	public String address;
	public String type;
	public String location;
	public boolean accepcted;
	
	
	public Store() {}
	
	public Store(String name, String address, String type, String location) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.location = location;
		this.accepcted = false;
	}
	

}
