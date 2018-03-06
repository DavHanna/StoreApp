package storeApp.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import storeApp.User.User;
import storeApp.User.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserRepository userRepo;

	@RequestMapping(method=RequestMethod.GET )
	public String index() 
	{
		return "register";
		// Render the register view
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type)
	{
		User user = new User(username, password, type);
		userRepo.save(user);
		// Redirect user to the home page
		return "redirect:/login";
	}
}
