package storeApp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import storeApp.User.User;
import storeApp.User.UserRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index() 
	{
		return "productIndex";
		// Render the products list
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String product() 
	{
		return "addProduct";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void register(@RequestParam("name")String name, 
			@RequestParam("price")double price,
			@RequestParam("category")String category,
			@RequestParam("productType")String productType,
			@RequestParam("brandId")int brandId)
	{
		Product p = new Product(name, price, category, productType, brandId);
		productRepo.save(p);
		// Redirect user to the home page
	}
}
