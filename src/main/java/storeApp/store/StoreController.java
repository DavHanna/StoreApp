package storeApp.store;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storeApp.store.Store;
import storeApp.store.StoreRepository;

@Controller
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	StoreRepository storeRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index() 
	{
		// Return the list of stores
		return "";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create() 
	{
		return "addStore";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void store(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		String location = request.getParameter("location");
		Store s = new Store(name, address, type, location);
		storeRepo.save(s);
		// Redirect user to the home page
	}
}
