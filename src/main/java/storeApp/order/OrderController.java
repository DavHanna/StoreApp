package storeApp.order;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storeApp.User.UserRepository;
import storeApp.product.Product;
import storeApp.product.ProductRepository;
import storeApp.store.Store;
import storeApp.store.StoreRepository;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	StoreRepository storeRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) 
	{
		model.addAttribute("orders", orderRepo.findAll());
		return "orders/index";
	}
	
	@RequestMapping(value="/create/{storeId}/{productId}", method=RequestMethod.GET)
	public String create(Model model, @PathVariable("storeId") int storeId, @PathVariable("productId") int productId) 
	{
		model.addAttribute("product", productRepo.findOne(productId));
		model.addAttribute("store", storeRepo.findOne(storeId));
		return "orders/create";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String store(HttpServletRequest request)
	{
		int productId = Integer.parseInt(request.getParameter("productId"));
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Product product = productRepo.findOne(productId);
		Store store = storeRepo.findOne(storeId);

		Set<Product> products = new HashSet<Product>();
		products.add(product);
		
		Order o = new Order(store, products, product.price * quantity, request.getParameter("shipping-address"));

		orderRepo.save(o);

		return "redirect:/orders";
		
	}
	
}
