package edu.neu.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.service.BaseService;
import edu.neu.service.UserService;
import edu.neu.user.User;

@Controller
@RequestMapping(value="/") //databind
public class HomeController {
	
	@Autowired
	private BaseService<User> userService;
	
	@RequestMapping(value="/modelautobind", method = RequestMethod.GET)
	public String modelAutoBind(HttpServletRequest request, Model model){  
//	    model.addAttribute("user", new User());
	    return "modelautobind"; 
	}

	//HttpServletRequest request,Model model, User user
	@RequestMapping(value="/modelautobind", method = RequestMethod.POST)
	public String modelAutoBind(Model model, @Valid @ModelAttribute("user") User user,BindingResult result){  	    
//		model.addAttribute("user", user);
//	    userService.insert(user);
//	    System.out.println(user.getUsername() +" "+ user.getPassword());
//	    return "registersuccess";//change modelautobindresult to registersuccess
		if(result.hasErrors()){
			return "modelautobind";
		}else{
			model.addAttribute("user", user);
			userService.insert(user);
			System.out.println(user.getUsername() +" "+ user.getPassword());
			return "registersuccess";
		}
	}
	
	 @ModelAttribute("user")
	 public User getUser(){
			User user=new User();
			return user;
	}

}
