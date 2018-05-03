package storeApp.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import storeApp.Register.RegisterController;
import storeApp.User.User;
import storeApp.User.UserRepository;

public class RegisterTests {

	@Mock private HttpSession mockHttpSession;
	@Mock private UserRepository userRepo;
	@Mock private Model model;
	
	@InjectMocks
	@Resource
    private RegisterController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testRegister() {
		String result = this.ctrl.register("khalid", "secret", "Store Owner", model);
		assertEquals("redirect:/login", result);
	}
	
	@Test
	public void testInvalidRegister() {
		when(userRepo.findByUsername(anyString())).thenReturn(new User());
		String result = this.ctrl.register("khalid", "secret", "Store Owner", model);
		assertEquals("message", result);
	}

	@Test
	public void testEmptyRegister() {
		String result = this.ctrl.register("", "", "", model);
		assertEquals("message", result);
	}

}
