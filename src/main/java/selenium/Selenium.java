package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium {
	
	WebDriver driver;

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmedalaa\\Documents\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		this.login();
		this.addProduct();
		this.addBrand();
		this.Login();
		this.createStore();
		this.AddProduct();
		this.addCollaborator();
		this.MakeOrder();
		this.deleteProduct();	
		}

	
	public void login()
	{
		driver.get("http://localhost:8080/login");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys( "Mariam");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("secret");
		
		driver.findElement(By.name("submit")).click();
		
		WebElement element = driver.findElement(By.tagName("body"));
		assertEquals(element.getText(), "Index");
	}
	
	public void addProduct()
	{
		driver.get("http://localhost:8080/products/create");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("New product");
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("399");
		driver.findElement(By.name("category")).clear();
		driver.findElement(By.name("category")).sendKeys("Category name");
		driver.findElement(By.name("productType")).clear();
		driver.findElement(By.name("productType")).sendKeys("ONsite");
		Select dropdown1 = new Select(driver.findElement(By.name("brandId")));
		dropdown1.selectByVisibleText("Adidas");
		
		driver.findElement(By.name("add")).click();
		
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Products list");
	}

	
	public void addBrand()
	{
		driver.get("http://localhost:8080/brands/create");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("nike");
		driver.findElement(By.name("category")).clear();
		driver.findElement(By.name("category")).sendKeys("sports");
		
		driver.findElement(By.name("add")).click();
		
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Brands list");
	}
	
	public void Login()
	{
		driver.get("http://localhost:8080/login");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys( "Khalid");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("secret");
		
		driver.findElement(By.name("submit")).click();
		
		WebElement element = driver.findElement(By.tagName("body"));
		assertEquals(element.getText(), "Index");
	}
	
	public void createStore()
	{
		driver.get("http://localhost:8080/stores/create");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Donuts");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("street 50");
		driver.findElement(By.name("type")).clear();
		driver.findElement(By.name("type")).sendKeys("onsite");
		driver.findElement(By.name("location")).clear();
		driver.findElement(By.name("location")).sendKeys("Dubai");
		
		driver.findElement(By.name("add")).click();
		
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Stores list");
	}
	
	public void AddProduct()
	{
		driver.get("http://localhost:8080/stores/1/addProduct");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Select dropdown2 = new Select(driver.findElement(By.name("product-id")));
		dropdown2.selectByVisibleText("Shoes");
		
		driver.findElement(By.name("add")).click();
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Products list");
		
	}
	
	public void addCollaborator()
	{
		driver.get("http://localhost:8080/stores/1/addCollaborator");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Select dropdown3 = new Select(driver.findElement(By.name("user-id")));
		dropdown3.selectByVisibleText("khalid");
		
		driver.findElement(By.name("add")).click();
		
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Products list");
		
	}
	

	public void deleteProduct()
	{
		driver.get("http://localhost:8080/stores/1/deleteProduct");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Select dropdown4 = new Select(driver.findElement(By.name("product-id")));
		dropdown4.selectByVisibleText("Shoes");
		
		driver.findElement(By.name("delete")).click();
		
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Products list");
		
	}
	
	public void MakeOrder()
	{
		driver.get("http://localhost:8080/stores/1/products");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		WebElement linkByPartialText = driver.findElement(By.partialLinkText("Buy"));
		linkByPartialText.click();
		
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("1");
		
		driver.findElement(By.name("shipping-address")).clear();
		driver.findElement(By.name("shipping-address")).sendKeys("street9,maadi");
		
		driver.findElement(By.name("order")).click();
		
		WebElement element = driver.findElement(By.tagName("h1"));
		assertEquals(element.getText(), "Orders list");
		
	}
}
