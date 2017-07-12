package edu.neu.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.service.BaseService;
import edu.neu.user.User;

@Controller
@RequestMapping(value="/logincontrol")
public class LoginController {

	@Autowired
	private BaseService<User> userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String logIn(HttpServletRequest request, Model model){
	    model.addAttribute("user", new User());
	    return "login";
	}
	
	@RequestMapping(value="/logincheck", method = RequestMethod.POST) //verify
	public String logInCheck(HttpSession session, Model model, User user) throws Exception{
//	    model.addAttribute("user", user);
		long id = userService.getCurId(user);
		System.out.println("loginController: "+user.getUsername() +" "+ user.getPassword()+" USER ID is "+id);
		session.setAttribute("user", user);
		session.setAttribute("userId", id);
		if(userService.logIn(user) && user.getRole()==1){
			return "libraryhome";
		}else if(userService.logIn(user) && user.getRole()==0){
			return "libraryadminhome";
		}else{
			return "accessDenied";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) throws Exception{
		//clear session
		session.invalidate();
		return "logout"; 
	}
	
	@RequestMapping(value="/returnhomepage/{userId}/{role}")
	public String returnHomePage(@PathVariable long userId,@PathVariable int role,HttpSession session) throws Exception{
		System.out.println("Admin return homepage get ID: " +userId);
		if(role==0){
			System.out.println("User return homepage role is  " + role);
			return "libraryadminhome";
		
		}
			System.out.println("User return homepage role is  " + role);
			return "libraryhome";
	}
	
//	@RequestMapping(value="/userreturnhomepage/{role}")
//	public String returnHomePageuser(@PathVariable int role,HttpSession session) throws Exception{
//		System.out.println("User return homepage role is  " + role);
//		return "libraryhome";
//	}
//	
	@RequestMapping(value="/checkadmininfo")
	public String checkAdminInfo(HttpSession session) throws Exception{
		
		return "checkadmininfo";
	}
	
	
	
	
}
