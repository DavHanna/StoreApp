package storeApp.product;

import javax.servlet.http.HttpServletRequest;

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
	public void create(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		double price1= Double.parseDouble(price);
		String category = request.getParameter("category");
		String productType = request.getParameter("productType");
		String brandId = request.getParameter("brandId");
		int id=Integer.parseInt(brandId);
		Product p = new Product(name, price1, category, productType, id);
		productRepo.save(p);
		// Redirect user to the home page
	}
}
