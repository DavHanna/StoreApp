package storeApp.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import storeApp.brand.Brand;
import storeApp.brand.BrandController;
import storeApp.brand.BrandRepository;

public class BrandTests {
	
	@Mock private HttpServletRequest mockRequest;
	@Mock private HttpSession mockHttpSession;
	@Mock private Model mockModel;
	@Mock private BrandRepository brandRepo;
	
	@InjectMocks
	@Resource
    private BrandController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testCreate() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		String result = this.ctrl.create(mockHttpSession, mockModel);
		assertEquals("brands/create", result);
	}
	
	@Test
	public void testInvalidCreate() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Store Owner");
		String result = this.ctrl.create(mockHttpSession, mockModel);
		assertEquals("message", result);
	}
	
	@Test
	public void testEmptyCreate() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(null);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		String result = this.ctrl.create(mockHttpSession, mockModel);
		assertEquals("message", result);
	}
	
	@Test
	public void testStore() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		when(mockRequest.getParameter("name")).thenReturn("Brand name");
		when(mockRequest.getParameter("category")).thenReturn("Category name");
		
		String result = this.ctrl.store(mockRequest, mockHttpSession, mockModel);
		assertEquals("redirect:/brands", result);
	}
	
	@Test
	public void testInvalidStore() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		when(mockRequest.getParameter("name")).thenReturn("Brand name");
		when(mockRequest.getParameter("category")).thenReturn("Category name");
		when(brandRepo.findByName(anyString())).thenReturn(new Brand());
		
		String result = this.ctrl.store(mockRequest, mockHttpSession, mockModel);
		assertEquals("message", result);
	}
	
	@Test
	public void testEmptyStore() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		when(mockRequest.getParameter("name")).thenReturn("");
		when(mockRequest.getParameter("category")).thenReturn("Category name");
		
		String result = this.ctrl.store(mockRequest, mockHttpSession, mockModel);
		assertEquals("message", result);
	}

}
