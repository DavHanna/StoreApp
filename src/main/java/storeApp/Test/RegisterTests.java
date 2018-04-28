package storeApp.Test;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import storeApp.Register.RegisterController;
import storeApp.User.UserRepository;

public class RegisterTests {

	@Mock private HttpSession mockHttpSession;
	@Mock private UserRepository userRepo;
	
	@InjectMocks
	@Resource
    private RegisterController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testRegister() {
		String result = this.ctrl.register("khalid", "secret", "Store Owner");
		assertEquals("redirect:/login", result);
	}

}
