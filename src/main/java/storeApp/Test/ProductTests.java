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

import storeApp.brand.Brand;
import storeApp.brand.BrandRepository;
import storeApp.product.ProductController;
import storeApp.product.ProductRepository;

public class ProductTests {

	@Mock private HttpServletRequest mockRequest;
	@Mock private HttpSession mockHttpSession;
	@Mock private Model mockModel;
	@Mock private BrandRepository brandRepo;
	@Mock private ProductRepository productRepo;
	
	@InjectMocks
	@Resource
    private ProductController ctrl;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testCreate() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		String result = this.ctrl.create(mockHttpSession, mockModel);
		assertEquals("products/create", result);
	}
	
	@Test
	public void testStore() {
		when(mockHttpSession.getAttribute("user_id")).thenReturn(1);
		when(mockHttpSession.getAttribute("user_type")).thenReturn("Admin");
		when(mockRequest.getParameter("name")).thenReturn("Product name");
		when(mockRequest.getParameter("price")).thenReturn("90");
		when(mockRequest.getParameter("category")).thenReturn("Product category");
		when(mockRequest.getParameter("productType")).thenReturn("Product type");
		when(mockRequest.getParameter("brandId")).thenReturn("1");
		Brand brand = new Brand("Brand name", "Description");
		brand.ID = 1;
		when(brandRepo.findOne(anyInt())).thenReturn(brand);
		
		String result = this.ctrl.store(mockRequest, mockHttpSession, mockModel);
		assertEquals("redirect:/products", result);
	}

}
