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
import com.SWE.Controllers.StatisticsCommand;
import com.SWE.Controllers.maxSoldBrand;
import com.SWE.Controllers.maxSoldProduct;
import com.SWE.Controllers.minSoldBrand;
import com.SWE.Controllers.minSoldProduct;
import com.SWE.Entities.Product;
import com.SWE.Entities.StatResult;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.ActionRepo;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreActionsRepo;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserRepository;

import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_MinSoldBrand extends ProjectTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private ProductRepository productRepository;
	
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
	public void test1_minSoldBrand_storeExist() throws Exception {
		
		StatisticsCommand stat = new minSoldBrand(sbRepo);
		StatResult result = stat.execute(1);
		Assert.assertEquals("b3", result.statEntity);
	}
	
	@Test
	public void test2_minSoldBrand_notExistingStore() throws Exception {
		StatisticsCommand stat = new minSoldBrand(sbRepo);
		StatResult result = stat.execute(33);
		Assert.assertEquals(null, result);
	}
	
	@Test
	public void test3_minSoldBrand_storeWithNoBrands() throws Exception {
		StatisticsCommand stat = new minSoldBrand(sbRepo);
		StatResult result = stat.execute(12);
		Assert.assertEquals(null, result);
	}
	
}