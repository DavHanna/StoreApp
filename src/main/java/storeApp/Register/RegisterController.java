package storeApp.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "auth/register";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type,Model model)
	{
		User user= userRepo.findByUsername(username);
		if(user!= null)
		{
			model.addAttribute("message",  "Username already taken");
			return "message";
		}
		
		if(username.equals("")|| password.equals("") || type.equals(""))
		{
			model.addAttribute("message",  "please fill the form");
			return "message";
		}
	     user = new User(username, password, type);
		
		userRepo.save(user);
		// Redirect user to the home page
		return "redirect:/login";
	}
}
