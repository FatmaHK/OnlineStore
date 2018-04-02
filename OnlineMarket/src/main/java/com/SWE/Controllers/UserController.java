package com.SWE.Controllers;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.User;
import com.SWE.Repositories.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("/onlinemarket/signup")
    public User register(Model model, @ModelAttribute User newUser){
    	model.addAttribute("newUser", new User());
    	userRepository.save(newUser);
    	System.out.println(newUser.getPassword());
    	System.out.println(newUser.getEmail());
    	return newUser ;
    }
    
    @GetMapping("/onlinemarket/signin")
    public User login(Model model, @ModelAttribute User loginUser) throws ClassNotFoundException, SQLException{
    	model.addAttribute("loginUser", new User());
    	for(User us : userRepository.findAll()) {
    		if(us.getUsername().equals(loginUser.getUsername()) && us.getPassword().equals(loginUser.getPassword())) {
    			System.out.println("Successfully login! ");
    			return us;
    		}
    	}
    	System.out.println("Try again! ");
    	return null;
    }
    
}