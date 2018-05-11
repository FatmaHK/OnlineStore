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

public class Test_PanelController extends ProjectTests {

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
	public void test1_addStatistic_NotExist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addStatistics/Most%20Buyer")).andExpect(status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("true", content);
	}
	
	@Test 
	public void test2_removeStatistic_NotExist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/removeStatistics/Most%20Buyer")).andExpect(status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("true", content);
	}
	
	
	
}