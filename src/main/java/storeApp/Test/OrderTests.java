package storeApp.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import storeApp.User.User;
import storeApp.brand.Brand;
import storeApp.order.OrderController;
import storeApp.order.OrderRepository;
import storeApp.product.Product;
import storeApp.product.ProductRepository;
import storeApp.store.Store;
import storeApp.store.StoreRepository;

public class OrderTests {

	@Mock private HttpServletRequest mockRequest;
	@Mock private HttpSession mockHttpSession;
	@Mock private Model mockModel;
	@Mock private StoreRepository storeRepo;
	@Mock private ProductRepository productRepo;
	@Mock private OrderRepository orderRepo;
	
	@InjectMocks
	@Resource
    private OrderController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testCreate() {
		when(productRepo.findOne(1)).thenReturn(null);
		when(storeRepo.findOne(1)).thenReturn(null);
		String result = this.ctrl.create(mockModel, 1, 1);
		assertEquals("orders/create", result);
	}
	
	@Test
	public void testStore() {
		when(mockRequest.getParameter("productId")).thenReturn("1");
		when(mockRequest.getParameter("storeId")).thenReturn("1");
		when(mockRequest.getParameter("quantity")).thenReturn("1");
		when(productRepo.findOne(anyInt())).thenReturn(new Product("product name", 10, "category", "onsite", new Brand("name", "description")));
		when(storeRepo.findOne(anyInt())).thenReturn(new Store(new User(), "store name", "address", "onsite", "location"));
		when(mockRequest.getParameter("category")).thenReturn("Category name");
		
		String result = this.ctrl.store(mockRequest);
		assertEquals("redirect:/orders", result);
	}

}
