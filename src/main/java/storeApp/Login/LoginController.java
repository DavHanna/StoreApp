package storeApp.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import storeApp.User.User;
import storeApp.User.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepo;

	@GetMapping("/login")
	public String index(Model model) 
	{		
		return "auth/login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		User user = userRepo.findByUsername(username);
		
		if (user == null || user.password != password)
			return "wrongCredentials";
		
		return "redirect:/";
	}
}
