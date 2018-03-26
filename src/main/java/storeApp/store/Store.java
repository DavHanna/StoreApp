package storeApp.store;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import storeApp.order.Order;
import storeApp.product.Product;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String name;
	public String address;
	public String type;
	public String location;
	public boolean accepted;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "store_product", joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	public Set<Product> products;
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	public Set<Order> orders;
	
	
	public Store() {}
	
	public Store(String name, String address, String type, String location) {
		this.name = name;
		this.address = address;
		this.type = type;
		this.location = location;
		this.accepted = false;
	}
	

}
