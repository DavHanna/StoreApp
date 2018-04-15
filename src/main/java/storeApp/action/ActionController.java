package storeApp.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import storeApp.User.UserRepository;
import storeApp.product.ProductRepository;
import storeApp.store.Store;
import storeApp.store.StoreRepository;

@Controller
@RequestMapping("/actions")
public class ActionController {

	@Autowired
	StoreRepository storeRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@RequestMapping(value="/{storeId}", method=RequestMethod.GET)
	public String index(Model model, HttpSession session, @PathVariable("storeId") int storeId) 
	{
		// Get current store
		Store store = storeRepo.findOne(storeId);
		if (store == null) {
			model.addAttribute("message", "Invalid store!");
			return "message";
		}
		
		if(session.getAttribute("user_id") == null || (Integer) session.getAttribute("user_id") != store.owner.ID) {
			model.addAttribute("message", "Unauthorized operation!");
			return "message";
		}
		
		model.addAttribute("store", store);
		
		return "actions/index";
	}
}
