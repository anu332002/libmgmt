package edu.neu.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.service.BaseService;
import edu.neu.user.Book;
import edu.neu.user.Page;
import edu.neu.user.User;

@Controller
@RequestMapping(value="/usercontrol")
public class UserController {
	@Autowired
	private BaseService<User> userService;
	
	@RequestMapping(value="/updatename/{userId}/{role}", method = RequestMethod.GET)
	public String updatenameone(@PathVariable long userId,@PathVariable int role,HttpServletRequest request, Model model){
		model.addAttribute("user",new User());
		return "updatename";
	}
	
	@RequestMapping(value="/updatename/{userId}/{role}",method = RequestMethod.POST)
	public String updateName(@PathVariable long userId,@PathVariable int role,HttpServletRequest request, Model model,User user){
		model.addAttribute("user",user);
		System.out.println("###########UserController");
		System.out.println("@@@@@@@"+userId);
		System.out.println("@@@@@@@"+user.getUsername());
		String name = user.getUsername();
		boolean result = userService.updateName(userId,name);
		if(result){
			return "updatename";
		}
			return "fail";
	}
	
	@RequestMapping(value="/updatepassword/{userId}/{role}", method = RequestMethod.GET)
	public String updatePass(@PathVariable long userId,@PathVariable int role,HttpServletRequest request, Model model){
		model.addAttribute("user",new User());
		return "updatepassword";
	}
	
	@RequestMapping(value="/updatepassword/{userId}/{role}",method = RequestMethod.POST)
	public String updatePassword(@PathVariable long userId,@PathVariable int role,HttpServletRequest request, Model model,User user){
		model.addAttribute("user",user);
		System.out.println("###########UserController");
		System.out.println("@@@@@@@"+userId);
		System.out.println("@@@@@@@"+user.getPassword());
		String pass = user.getPassword();
		boolean result = userService.updatePassword(userId, pass);
		if(result){
			return "updatepassword";
		}
			return "fail";
	}
	
	@RequestMapping(value="/updateemail/{userId}/{role}", method = RequestMethod.GET)
	public String updateEmail(@PathVariable long userId,@PathVariable int role,HttpServletRequest request, Model model){
		model.addAttribute("user",new User());
		return "updateemail";
	}
	
	@RequestMapping(value="/updateemail/{userId}/{role}",method = RequestMethod.POST)
	public String updateEmailone(@PathVariable long userId,@PathVariable int role,HttpServletRequest request, Model model,User user){
		model.addAttribute("user",user);
		System.out.println("###########UserController");
		System.out.println("@@@@@@@"+userId);
		System.out.println("@@@@@@@"+user.getEmail());
		String email = user.getEmail();
		boolean result = userService.updateEmail(userId, email);
		if(result){
			return "updateemail";
		}
			return "fail";
	}
	
	@RequestMapping(value="/queryreaderinfo/{userId}",method=RequestMethod.POST)
	public String queryReaderInfo(@PathVariable long userId,HttpServletRequest request, Model model,User user){
		System.out.println("Admin Query Readers Info, admin Id is "+userId);
		return "queryreaderinfo";
	}
	
	@RequestMapping(value="/searchreaders/{userId}",method=RequestMethod.POST)
	public String searchAllReaders(HttpServletRequest request, Model model,User user){
		try{
			String pageNo = request.getParameter("pageNo");
			if(pageNo==null){
				pageNo="1";
			}
			Page page = userService.queryForPage(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<User> pagelist = page.getList();
			request.setAttribute("pagelist", pagelist);								
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "searchreaders";
	}
	
	@RequestMapping(value="/searchreaderbyid",method = RequestMethod.POST)
	public String searchBookByIdText(@RequestParam("id") long id, HttpServletRequest request, Model model){
		System.out.println("Search By User ID, User id is "+ id);
		User user = userService.getOne(id);
		model.addAttribute("user", user);
		return "searchreaderbyid";
	}
	
	@RequestMapping(value="/searchreaderbyname",method = RequestMethod.POST)
	public String searchBookByPrice(@RequestParam("username") String username, HttpServletRequest request, Model model,Book book){
		System.out.println("in controller, Search By READER NAME, keyword is "+ username);
		List<User> list = userService.getbyParam(username,1);
		model.addAttribute("list", list);
		return "searchreaderbyname";
	}
	
	@RequestMapping(value="/deletereader/{userId}",method = RequestMethod.POST)
	public String deleteReader(@PathVariable long userId,HttpServletRequest request, Model model,User user){
		System.out.println("in controller, Delete user id is  "+ userId);
		boolean result = userService.delete(userId);
		if(result){
		return "deleteusersuccess";
		}
		return "fail";
	}
}
