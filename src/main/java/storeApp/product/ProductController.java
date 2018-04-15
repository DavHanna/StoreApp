package storeApp.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storeApp.brand.BrandRepository;



@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	@Autowired
	BrandRepository brandRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) 
	{
		model.addAttribute("products", productRepo.findAll());
		return "products/index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(HttpSession session, Model model) 
	{
		if(session.getAttribute("user_id") == null || !session.getAttribute("user_type").equals("Admin")) {
			model.addAttribute("message", "Only admins are authorized to do this operation!");
			return "message";
		}
		
		model.addAttribute("brands", brandRepo.findAll());
		return "products/create";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String store(HttpServletRequest request, HttpSession session, Model model)
	{
		if(session.getAttribute("user_id") == null || !session.getAttribute("user_type").equals("Admin")) {
			model.addAttribute("message", "Only admins are authorized to do this operation!");
			return "message";
		}
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		double price1= Double.parseDouble(price);
		String category = request.getParameter("category");
		String productType = request.getParameter("productType");
		String brandId = request.getParameter("brandId");
		int id=Integer.parseInt(brandId);
		Product p = new Product(name, price1, category, productType, brandRepo.findOne(id));
		productRepo.save(p);

		return "redirect:/products";
		
	}
}
