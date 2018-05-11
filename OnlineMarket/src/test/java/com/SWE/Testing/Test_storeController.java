package com.SWE.Testing;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;

public class Test_storeController extends ProjectTests{
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private StoreProductRepo storeProductRepo;
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void test1_requestToAddStore_newStore() throws Exception {
		mockMvc.perform(get("/onlinemarket/addstore/request?name=s2&type=tv&ownerName=ahmed&location=Dokki")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
		
		boolean actual = false;
		for(Store s: storeRepository.findAll()) {
			if(s.getName().equals("s2")) {
				actual = true;
				break;
			}
		}
		assertEquals(actual, true);
	}
	
	@Test
	public void test2_requestToAddStore_existentStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/request?name=s2&type=online&ownerName=ahmed&location=Dokki")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void test3_requestToAddStore_nonexistentStoreOwner() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/request?name=s3&type=online&ownerName=khaled&location=Dokki")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();   //Bug 
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void test1_acceptStore_requestedStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/accept-request?name=s2&type=online&ownerName=ahmed&location=Dokki")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("true", content);
	}
	
	@Test
	public void test2_acceptStore_unRequestedStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/accept-request?name=s5&type=online&ownerName=ahmed&location=Dokki")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void test3_acceptStore_alreadyAcceptedOne() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/accept-request?name=s2&type=online&ownerName=ahmed&location=Dokki")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void Test1_rejectStore_alreadyRequested() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/reject-request?name=s4&type=onsite&ownerName=heba&location=Downtown")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("true", content);
	}
	
	@Test
	public void Test2_rejectStore_notRequested() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/reject-request?name=s4&type=onsite&ownerName=heba&location=Downtown")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void Test3_rejectStore_wrongStoreName() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/reject-request?name=s7&type=online&ownerName=ahmed&location=Dokki")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void Test1_getAllStoreRequests_allStores() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/addstore/get-all-request")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("[{\"id\":13,\"name\":\"s3\",\"type\":\"online\",\"ownerName\":\"khaled\",\"location\":\"Dokki\",\"isAccepted\":false,\"numberOfVisitors\":0,\"numberOfBuyers\":0,\"storeProducts\":[],\"storeBrands\":[],\"storeActions\":[],\"statistics\":[],\"users\":[]}]", content);
	}
	
	@Test
	public void Test1_addCollaborator_existentUser() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/add-collaborator/?email=lamiaa@&sName=s3")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("true", content);
	}
	
	@Test
	public void Test2_addCollaborator_nonExistentUser() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/add-collaborator/?email=ali@&sName=s3")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
		 	
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void Test3_addCollaborator_alreadyCollaboratorInThisStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/add-collaborator/?email=lamiaa@&sName=s3")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void Test1_getAllActionsOfStore_existentStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/history/s1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("[{\"id\":1,\"store\":{\"id\":1,\"name\":\"s1\",\"type\":\"online\",\"ownerName\":\"abc\",\"location\":\"xyz\",\"isAccepted\":true,\"numberOfVisitors\":2,\"numberOfBuyers\":1,\"storeProducts\":null,\"storeBrands\":null,\"storeActions\":null,\"statistics\":null,\"users\":null},\"action\":{\"id\":1,\"name\":\"add product\",\"description\":\"nice\",\"storeActions\":null},\"date\":1430517600000},{\"id\":2,\"store\":{\"id\":1,\"name\":\"s1\",\"type\":\"online\",\"ownerName\":\"abc\",\"location\":\"xyz\",\"isAccepted\":true,\"numberOfVisitors\":2,\"numberOfBuyers\":1,\"storeProducts\":null,\"storeBrands\":null,\"storeActions\":null,\"statistics\":null,\"users\":null},\"action\":{\"id\":2,\"name\":\"add brand\",\"description\":\"nice\",\"storeActions\":null},\"date\":1430517600000},{\"id\":3,\"store\":{\"id\":1,\"name\":\"s1\",\"type\":\"online\",\"ownerName\":\"abc\",\"location\":\"xyz\",\"isAccepted\":true,\"numberOfVisitors\":2,\"numberOfBuyers\":1,\"storeProducts\":null,\"storeBrands\":null,\"storeActions\":null,\"statistics\":null,\"users\":null},\"action\":{\"id\":3,\"name\":\"delete product\",\"description\":\"nice\",\"storeActions\":null},\"date\":1430517600000}]", content);
	}
	
	@Test
	public void Test2_getAllActionsOfStore_nonExistentStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/history/s5")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("[]", content);
	}
	
	@Test
	public void Test3_getAllActionsOfStore_ByStoreOwner() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/history/ahmed")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("[]", content);
	}
	
	@Test
	public void Test1_undoAction_validStoreAndAction() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/undo/1/2")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("true", content);
	}
	
	@Test
	public void Test2_undoAction_nonExistentAction() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/undo/1/5")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
	
	@Test
	public void Test3_undoAction_nonExistentStore() throws Exception {
		MvcResult result = mockMvc.perform(get("/onlinemarket/undo/2/2")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andReturn();
			
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("false", content);
	}
}
