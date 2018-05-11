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

import com.SWE.Controllers.StatisticsCommand;
import com.SWE.Controllers.maxSoldProduct;
import com.SWE.Entities.Product;
import com.SWE.Entities.Statistic;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StatisticsRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserRepository;

import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_StatisticsCommand extends ProjectTests {

	@Autowired
	private StatisticsRepo statRepo;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StatisticsRepo statRepository;
	
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
	public void test1_enableStatistics_notEnabled() throws Exception {
		StatisticsCommand.statRepo = statRepo;
		StatisticsCommand.enableStatistics("Max sold brand");
		Statistic s = statRepository.findOne(2);
		Assert.assertEquals(s.isEnabled(), 1);
	}
	
	@Test
	public void test2_enableStatistics_allreadyEnabled() throws Exception {
		StatisticsCommand.statRepo = statRepo;
		StatisticsCommand.enableStatistics("Max sold brand");
		Statistic s = statRepository.findOne(2);
		Assert.assertEquals(s.isEnabled(), 1);
	}
	
	@Test
	public void test3_enableStatistics_notExist() throws Exception {
		StatisticsCommand.statRepo = statRepo;
		boolean result = StatisticsCommand.enableStatistics("Max offer");
		Assert.assertEquals("false", result);
	}
	
	@Test
	public void test1_disableStatistics_notEnabled() throws Exception {
		StatisticsCommand.statRepo = statRepo;
		StatisticsCommand.enableStatistics("Max sold brand");
		Statistic s = statRepository.findOne(2);
		Assert.assertEquals(s.isEnabled(), 0);
	}
	
	@Test
	public void test2_disableStatistics_allreadyEnabled() throws Exception {
		StatisticsCommand.statRepo = statRepo;
		StatisticsCommand.enableStatistics("Max sold brand");
		Statistic s = statRepository.findOne(2);
		Assert.assertEquals(s.isEnabled(), 0);
	}
	
	@Test
	public void test3_disableStatistics_notExist() throws Exception {
		StatisticsCommand.statRepo = statRepo;
		boolean result = StatisticsCommand.enableStatistics("Max offer");
		Assert.assertEquals("false", result);
	}
	
}