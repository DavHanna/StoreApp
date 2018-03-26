package storeApp.brand;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import storeApp.product.Product;

@Entity
public class Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int ID;
	public String name;
	public String category;
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	public Set<Product> products;
	
	public Brand() {};
	
	public Brand(String name, String category)
	{
		this.name = name;		
		this.category = category;
	}

}
