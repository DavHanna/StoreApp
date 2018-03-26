package storeApp.product;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import storeApp.brand.Brand;
import storeApp.order.Order;
import storeApp.store.Store;

@Entity
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int ID;
	public String name;
	public double price;
	public String category;
	public String productType;
	@ManyToOne
    @JoinColumn(name = "brand_id")
	public Brand brand;
	public int quantity;
	@ManyToMany(mappedBy = "products")
	public Set<Order> orders;
	@ManyToMany(mappedBy = "products")
	public Set<Store> stores;
	
	public Product() {};
	
	public Product(String name, double price, String category, String productType, Brand brand)
	{
		this.name = name;
		this.price = price;
		this.category = category;
		this.productType = productType;
		this.brand = brand;
		
	}
	
}
