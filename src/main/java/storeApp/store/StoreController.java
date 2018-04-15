package storeApp.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storeApp.User.User;
import storeApp.User.UserRepository;
import storeApp.store.Store;
import storeApp.store.StoreRepository;

@Controller
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	StoreRepository storeRepo;
	
	@Autowired
	UserRepository userRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) 
	{
		model.addAttribute("stores", storeRepo.findAll());
		return "stores/index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(HttpSession session, Model model) 
	{
		if(session.getAttribute("user_id") == null || !session.getAttribute("user_type").equals("Store Owner")) {
			model.addAttribute("message", "Only store owners are authorized to do this operation!");
			return "message";
		}
		
		return "stores/create";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String store(HttpServletRequest request, HttpSession session, Model model)
	{
		if(session.getAttribute("user_id") == null || !session.getAttribute("user_type").equals("Store Owner")) {
			model.addAttribute("message", "Only store owners are authorized to do this operation!");
			return "message";
		}
		
		// Get the store owner
		User owner = userRepo.findOne( (Integer) session.getAttribute("user_id"));
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		String location = request.getParameter("location");
		Store s = new Store(owner, name, address, type, location);
		storeRepo.save(s);

		return "redirect:/stores";
	}
}
