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

import com.SWE.Controllers.AddProduct;
import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreBrand;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.ActionRepo;
import com.SWE.Repositories.BrandRepository;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreActionsRepo;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserRepository;

import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_DeleteBrand extends ProjectTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreBrandRepo sbRepo;
	@Autowired
	public StoreActionsRepo saRepository;
	@Autowired
	public ActionRepo actionRepository;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test1_deleteBrand_Exist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/deleteBrandFromStore/s1/b4"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("true", actual);
	}
	
	@Test
	public void test2_deleteBrand_notExist() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/deleteBrandFromStore/s1/b5"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		
		Assert.assertEquals("false", actual);
	}
	
	@Test
	public void test3_deleteBrand_unExistStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/deleteBrandFromStore/s11/b4"))
				.andExpect(status().isOk()).andReturn();
		
		String actual = result.getResponse().getContentAsString();
		Assert.assertEquals("false", actual);
	}
	
}