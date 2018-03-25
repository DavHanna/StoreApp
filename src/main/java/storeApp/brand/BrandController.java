package storeApp.brand;

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
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	BrandRepository brandRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index() 
	{
		return "brandIndex";
		// Render the brands list
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String brand() 
	{
		return "addBrand";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addBrand(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		Brand b = new Brand(name , category);
		brandRepo.save(b);
		// Redirect user to the home page
	}
}
