package storeApp.order;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import storeApp.User.User;
import storeApp.product.Product;
import storeApp.store.Store;

@Entity
@Table(name="orders")
public class Order {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int ID;
	@ManyToOne
    @JoinColumn(name = "user_id")
	public User user;
	@ManyToOne
    @JoinColumn(name = "store_id")
	public Store store;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	public Set<Product> products;
	public double total;
	
	public Order()
	{
		
	}
	
	public Order(User user, Set<Product> products, double total)
	{
		this.user = user;
		this.products = products;
		this.total = total;
	}
	
}
