package storeApp.brand;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import storeApp.product.Product;

@Entity
public class Brand {
	
	@Id
	public int ID;
	public String name;
//	public Set<Product> products;
	
	public Brand() {};
	
	public Brand(int ID, String name)
	{
		this.ID = ID;
		this.name = name;		
	}
	
//	@OneToMany(mappedBy="brand_id", cascade = CascadeType.ALL)
//	public Set<Product> getProducts()
//	{
//		return products;
//	}

}
