package storeApp.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String displayAddStoreForm() 
	{
		return "addStore";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addStore(@RequestParam("name")String name, 
			@RequestParam("address")String address,
			@RequestParam("type")String type,
			@RequestParam("location")String location)
	{
		Store s = new Store(name, address, type, location);
		storeRepo.save(s);
		// Redirect user to the home page
	}
}
