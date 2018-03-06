package storeApp.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import storeApp.User.User;
import storeApp.User.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserRepository userRepo;

	@RequestMapping(method=RequestMethod.GET)
	public String index() 
	{
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public int login(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		User user = userRepo.findByUsername(username);
		if (user == null)
			return -1;
		
		if (user.password != password)
			return 0;
		
		return 1;
		// Redirect user to the home page
	}
}
