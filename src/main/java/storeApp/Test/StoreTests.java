package storeApp.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.HashSet;

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
import storeApp.User.UserRepository;
import storeApp.action.Action;
import storeApp.product.Product;
import storeApp.product.ProductRepository;
import storeApp.store.Store;
import storeApp.store.StoreController;
import storeApp.store.StoreRepository;

public class StoreTests {
	
	@Mock private HttpServletRequest mockRequest;
	@Mock private HttpSession mockHttpSession;
	@Mock private Model mockModel;
	@Mock StoreRepository storeRepo;
	@Mock UserRepository userRepo;
	@Mock ProductRepository productRepo;
	
	@InjectMocks
	@Resource
    private StoreController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testCreate()
	{
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		String result = this.ctrl.create(mockHttpSession, mockModel);
		assertEquals("stores/create", result);
	}
	
	@Test
	public void testStore() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		when(mockRequest.getParameter("name")).thenReturn("Store name");
		when(mockRequest.getParameter("address")).thenReturn("address");
		when(mockRequest.getParameter("location")).thenReturn("location");
		when(mockRequest.getParameter("type")).thenReturn("onsite");
		when(userRepo.findOne(anyInt())).thenReturn(new User());
		
		String result = this.ctrl.store(mockRequest, mockHttpSession, mockModel);
		assertEquals("redirect:/stores", result);
	}
	
	@Test
	public void testShowProducts() {
		when(storeRepo.findOne(anyInt())).thenReturn(new Store());
		
		String result = this.ctrl.showProducts(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("stores/products", result);
	}
	
	@Test
	public void testAddProduct() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		User user = new User();
		user.ID = 1;
		Store store = new Store();
		store.owner = user;
		when(storeRepo.findOne(anyInt())).thenReturn(store);
		String result = this.ctrl.addProduct(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("stores/addProduct", result);
	}
	
	@Test
	public void testStoreProduct() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		when(mockRequest.getParameter("name")).thenReturn("Store name");
		when(mockRequest.getParameter("address")).thenReturn("address");
		when(mockRequest.getParameter("location")).thenReturn("location");
		when(mockRequest.getParameter("type")).thenReturn("onsite");
		when(userRepo.findOne(anyInt())).thenReturn(new User());
		when(mockRequest.getParameter("product-id")).thenReturn("1");
		when(productRepo.findOne(anyInt())).thenReturn(new Product());
		User user = new User();
		user.ID = 1;
		Store store = new Store();
		store.id = 1;
		store.owner = user;
		store.products = new HashSet<Product>();
		store.actions = new HashSet<Action>();
		when(storeRepo.findOne(anyInt())).thenReturn(store);
		
		String result = this.ctrl.storeProduct(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("redirect:/stores/" + store.id + "/products", result);
	}

	@Test
	public void testDeleteProduct() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		User user = new User();
		user.ID = 1;
		Store store = new Store();
		store.owner = user;
		when(storeRepo.findOne(anyInt())).thenReturn(store);
		String result = this.ctrl.deleteProduct(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("stores/deleteProduct", result);
	}

	@Test
	public void testDestroyProduct() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		when(mockRequest.getParameter("name")).thenReturn("Store name");
		when(mockRequest.getParameter("address")).thenReturn("address");
		when(mockRequest.getParameter("location")).thenReturn("location");
		when(mockRequest.getParameter("type")).thenReturn("onsite");
		when(userRepo.findOne(anyInt())).thenReturn(new User());
		when(mockRequest.getParameter("product-id")).thenReturn("1");
		when(productRepo.findOne(anyInt())).thenReturn(new Product());
		User user = new User();
		user.ID = 1;
		Store store = new Store();
		store.id = 1;
		store.owner = user;
		store.products = new HashSet<Product>();
		store.actions = new HashSet<Action>();
		when(storeRepo.findOne(anyInt())).thenReturn(store);
		
		String result = this.ctrl.destroyProduct(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("redirect:/stores/" + store.id + "/products", result);
	}

	@Test
	public void testAddCollaborator() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		User user = new User();
		user.ID = 1;
		Store store = new Store();
		store.owner = user;
		when(storeRepo.findOne(anyInt())).thenReturn(store);
		String result = this.ctrl.addCollaborator(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("stores/addCollaborator", result);
	}
	
	@Test
	public void testStoreCollaborator() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(userRepo.findOne(anyInt())).thenReturn(new User());
		when(mockRequest.getParameter("user-id")).thenReturn("1");
		when(productRepo.findOne(anyInt())).thenReturn(new Product());
		User user = new User();
		user.ID = 1;
		Store store = new Store();
		store.id = 1;
		store.owner = user;
		store.collaborators = new HashSet<User>();
		when(storeRepo.findOne(anyInt())).thenReturn(store);
		
		String result = this.ctrl.storeCollaborator(mockRequest, mockHttpSession, mockModel, 1);
		assertEquals("redirect:/stores/" + store.id + "/products", result);
	}
	
}
