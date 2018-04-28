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

import storeApp.Login.LoginController;
import storeApp.User.User;
import storeApp.User.UserRepository;

public class LoginTests {
	
	@Mock private HttpSession mockHttpSession;
	@Mock private UserRepository userRepo;
	
	@InjectMocks
	@Resource
    private LoginController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testLogin() {
		User user = new User("khalid", "secret", "Store Owner");
		when(this.userRepo.findByUsername("khalid")).thenReturn(user);
		String result = this.ctrl.login("khalid", "secret", mockHttpSession);
		assertEquals("redirect:/", result);
	}

}
