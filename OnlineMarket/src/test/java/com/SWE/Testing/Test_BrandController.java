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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.SWE.Entities.Brand;
import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.BrandRepository;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserRepository;

import org.junit.After;
import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_BrandController extends ProjectTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreBrandRepo sbRepo;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test1_addBrand_NotExist() throws Exception {
		
		MvcResult result = mockMvc.perform(get("/onlinemarket/addbrand?name=b6&category=www")).andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("true", actual);
		
		Brand b = brandRepository.findByName("b6");
		Assert.assertEquals(b.getName(), "b6");
		Assert.assertEquals(b.getCategory(), "www");
	}
	
	@Test
	public void test2_addBrand_allreadyExist() throws Exception {
		
		MvcResult result = mockMvc.perform(get("/onlinemarket/addbrand?name=b6&category=www")).andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("false", actual);
	}
	
	@Test
	public void test3_addBrand_WithMissingData() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addbrand")).andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("false", actual);
		
	}
	
	@After
	public void afterMethod() {
		Brand b = brandRepository.findByName("b6");
		brandRepository.delete(b);
	}
	
	
}