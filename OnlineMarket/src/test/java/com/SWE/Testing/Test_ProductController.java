package com.SWE.Testing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserRepository;

import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_ProductController extends ProjectTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreProductRepo spRepo;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test1_addProduct_NotExist() throws Exception {
		Product product = new Product();
		product.setName("product1");
		product.setPrice(18);
		product.setBrand("b2");
		product.setQuantity(40);
		product.setType("laptop");
		
		mockMvc.perform(get("/onlinemarket/addproduct?name=" + product.getName() + "&price=" + product.getPrice()
		+ "&brand=" + product.getBrand() + "&quantity=" + product.getQuantity()
		+ "&type=" + product.getType())).andExpect(status().isOk());
		
		Product p = productRepository.findByName("product1");
		Assert.assertEquals(product.getName(), p.getName());
		Assert.assertEquals(product.getPrice(), p.getPrice(), 0.001);
		Assert.assertEquals(product.getBrand(), p.getBrand());
		Assert.assertEquals(product.getQuantity(), p.getQuantity());
		Assert.assertEquals(product.getType(), p.getType());
		
	}
	
	@Test
	public void test2_addProduct_ExistingProduct() throws Exception {
		
		Product p = productRepository.findByName("product1");
		
		Product product = new Product();
		product.setName("product1");
		product.setPrice(18);
		product.setBrand("b2");
		product.setQuantity(40);
		product.setType("laptop");
		
		mockMvc.perform(get("/onlinemarket/addproduct?name=" + product.getName() + "&price=" + product.getPrice()
		+ "&brand=" + product.getBrand() + "&quantity=" + product.getQuantity()
		+ "&type=" + product.getType())).andExpect(status().isOk());
		
		Product p2 = productRepository.findByName("product1");
		Assert.assertEquals(p.getQuantity() + product.getQuantity(), p2.getQuantity());
	}
	
	@Test
	public void test3_addProduct_WithUnExistingBrand() throws Exception {
		Product product = new Product();
		product.setName("product2");
		product.setPrice(18);
		product.setBrand("b11");
		product.setQuantity(40);
		product.setType("laptop");
		
		MvcResult result = mockMvc.perform(get("/onlinemarket/addproduct?name=" + product.getName() + "&price=" + product.getPrice()
		+ "&brand=" + product.getBrand() + "&quantity=" + product.getQuantity()
		+ "&type=" + product.getType())).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
		
		Product p = productRepository.findByName("product2");
		Assert.assertEquals(p, null);
		
	}
	
	@Test
	public void test1_buyProduct_NormalBuyer_sold2Items() throws Exception{
//		Product p = productRepository.findByName("product1");
//		Store s = storeRepository.findByName("s1");
//		StoreProduct sp = new StoreProduct();
//		sp.setStore(s);
//		sp.setProduct(p);
//		sp.setQuantity(100);
//		sp.setPrice(30);
//		sp.setNumberOfSoldItems(5);
//		sp.setNumberOfViewers(15);
//		spRepo.save(sp);
		
		MvcResult result = mockMvc.perform(get("/onlinemarket/buyproduct/eee/s1/product1/2"))
				.andExpect(status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println("ddddd " + content + " zzzzzzzzzzz");
		Assert.assertEquals("54", content);
	}
	
	@Test
	public void test2_buyProduct_storeOwner_sold1Item() throws Exception{
		
		MvcResult result = mockMvc.perform(get("/onlinemarket/buyproduct/Fatma/s1/product2/1"))
				.andExpect(status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println("ddddd " + content + " rrrrrrrrr");
		Assert.assertEquals("25.5", content);
	}
	
	@Test
	public void test3_buyProduct_storeOwner_sold2Item() throws Exception{
		MvcResult result = mockMvc.perform(get("/onlinemarket/buyproduct/eee/s1/product1/2"))
				.andExpect(status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println("ddddd " + content + " rrrrrrrrr");
		Assert.assertEquals("45", content);
	}
	
}