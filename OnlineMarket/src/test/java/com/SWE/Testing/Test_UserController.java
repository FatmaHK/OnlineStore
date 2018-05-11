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

import com.SWE.Entities.User;
import com.SWE.Repositories.UserRepository;

import org.junit.Assert;
import net.minidev.json.JSONObject;

public class Test_UserController extends ProjectTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UserRepository userRepository;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test1_signup_normlSignup() throws Exception {
		for(User user: userRepository.findAll()) {
			if(user.getEmail().equals("l@a.com")) {
				userRepository.delete(user);
			}
		}
		
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("name", "Lamiaa");
		jsonObj.put("username", "Lamiaa");
		jsonObj.put("email", "l@a.com");
		jsonObj.put("password", "963");
		jsonObj.put("type", "Admin");
		String message = jsonObj.toString();
		System.out.println(message);
		mockMvc.perform(get("/onlinemarket/signup?name=" + jsonObj.getAsString("name") + "&username=" + jsonObj.getAsString("username")
		+ "&email=" + jsonObj.getAsString("email") + "&password=" + jsonObj.getAsString("password")
		+ "&type=" + jsonObj.getAsString("type"))).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("name").value("Lamiaa"))
				.andExpect(jsonPath("username").value("Lamiaa")).andExpect(jsonPath("email").value("l@a.com"))
				.andExpect(jsonPath("password").value("963")).andExpect(jsonPath("type").value("Admin"));

	}
	
	
	@Test
	public void test2_signup_signupWithExectingUser() throws Exception {
		
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("name", "Lamiaa");
		jsonObj.put("username", "Lamiaa");
		jsonObj.put("email", "l@a.com");
		jsonObj.put("password", "963");
		jsonObj.put("type", "Admin");
		String message = jsonObj.toString();
		System.out.println(message);
		MvcResult result = mockMvc.perform(get("/onlinemarket/signup?name=" + jsonObj.getAsString("name") + "&username=" + jsonObj.getAsString("username")
		+ "&email=" + jsonObj.getAsString("email") + "&password=" + jsonObj.getAsString("password")
		+ "&type=" + jsonObj.getAsString("type"))).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("", content);

	}
	
	@Test
	public void test3_signup_signupMessingData() throws Exception {
		
		User user = new User();
		user.setName("John");
		user.setUsername("");
		user.setEmail("");
		user.setPassword("963");
		user.setType("Buyer");
		
		MvcResult result = mockMvc.perform(get("/onlinemarket/signup?name=" + user.getName() + "&username=" + user.getUsername()
		+ "&email=" + user.getEmail() + "&password=" + user.getPassword()
		+ "&type=" + user.getType())).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();

		userRepository.delete(userRepository.findByEmail(""));
		Assert.assertEquals("", content);

	}
	
	@Test
	public void test1_login_signWithValidAccount_ByUsername() throws Exception {
		String username = "Fatma";
		String password = "123";
		mockMvc.perform(get("/onlinemarket/signin?username=" + username + "&password=" + password))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("name").value("Fatma"))
				.andExpect(jsonPath("username").value("Fatma")).andExpect(jsonPath("email").value("f@h.com"))
				.andExpect(jsonPath("password").value("123")).andExpect(jsonPath("type").value("store owner"));
		
	}
	
	@Test
	public void test2_login_signWithValidAccount_ByEmail() throws Exception {
		String email = "f@h.com";
		String password = "123";
		mockMvc.perform(get("/onlinemarket/signin?email=" + email + "&password=" + password))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("name").value("Fatma"))
				.andExpect(jsonPath("username").value("Fatma")).andExpect(jsonPath("email").value("f@h.com"))
				.andExpect(jsonPath("password").value("123")).andExpect(jsonPath("type").value("store owner"));

	}
	
	@Test
	public void test1_login_signWithInValidAccount() throws Exception {
		String username = "xwz";
		String password = "fff1";
		MvcResult result = mockMvc.perform(get("/onlinemarket/signin?username=" + username + "&password=" + password))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		Assert.assertEquals("", content);

		
	}

}