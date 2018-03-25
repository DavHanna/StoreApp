package storeApp.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeApp.brand.Brand;
import storeApp.brand.BrandRepository;
import storeApp.product.Product;
import storeApp.product.ProductRepository;

@RestController
public class HomeController {
	
	@Autowired
	private ProductRepository productRepo; 
	@Autowired
	private BrandRepository brandRepo;

	@RequestMapping("/")
	public String index()
	{
		return "Index";
	}
	
}
