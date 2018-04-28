package storeApp.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import storeApp.User.User;
import storeApp.User.UserRepository;
import storeApp.action.ActionController;
import storeApp.product.ProductRepository;
import storeApp.store.Store;
import storeApp.store.StoreRepository;

public class ActionTests {

	@Mock private HttpSession mockHttpSession;
	@Mock private Model mockModel;
	@Mock private UserRepository userRepo;
	@Mock private ProductRepository productRepo;
	@Mock private StoreRepository storeRepo;
	
	@InjectMocks
	@Resource
    private ActionController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testLogin() {
		User user = new User("khalid", "secret", "Store Owner");
		user.ID = 1;
		Store store = new Store(user, "name", "address", "Onsite", "location");
		store.id = 1;
		when(storeRepo.findOne(store.id)).thenReturn(store);
		when(mockHttpSession.getAttribute("user_id")).thenReturn(user.ID);
		String result = this.ctrl.index(mockModel, mockHttpSession, store.id);
		assertEquals("actions/index", result);
	}

}
