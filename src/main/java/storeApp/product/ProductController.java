package storeApp.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) 
	{
		model.addAttribute("products", productRepo.findAll());
		return "productIndex";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String product() 
	{
		return "addProduct";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(HttpServletRequest request)
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

		return "redirect:/products";
		
	}
}
