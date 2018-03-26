package storeApp.brand;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	BrandRepository brandRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) 
	{
		model.addAttribute("brands", brandRepo.findAll());
		return "brands/index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create() 
	{
		return "brands/create";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String store(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		Brand b = new Brand(name , category);
		brandRepo.save(b);

		return "redirect:/brands";
	}
}
