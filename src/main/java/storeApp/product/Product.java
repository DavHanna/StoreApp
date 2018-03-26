package storeApp.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import storeApp.brand.Brand;

@Entity
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int ID;
	public String name;
	public double price;
	public String category;
	public String productType;
	public int brandId;
	public int quantity;
	
	public Product() {};
	
	public Product(String name, double price, String category, String productType, int brandId)
	{
		this.name = name;
		this.price = price;
		this.category = category;
		this.productType = productType;
		this.brandId = brandId;
		
	}
	
//	@ManyToOne
//	@JoinColumn(name = "brand_id")
//	public Brand brand()
//	{
//		return brand;
//	}
}
