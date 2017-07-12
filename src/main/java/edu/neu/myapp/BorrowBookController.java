package edu.neu.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.service.*;
import edu.neu.user.Book;
import edu.neu.user.BorrowBook;
import edu.neu.user.Page;
import edu.neu.user.User;

@Controller
@RequestMapping(value="/borrowbookcontrol")
public class BorrowBookController {

	@Autowired
	private BaseService<BorrowBook> borrowBookService;
	@Autowired
	private BaseService<User> userService;
	
	@RequestMapping(value="/borrowbookcheck/{bookId}/{userId}", method = RequestMethod.POST)
	public String borrowBookCheck(@PathVariable long bookId,@PathVariable long userId,HttpServletRequest request, Model model){
		System.out.println(bookId +" "+userId);
		boolean checkborrow = borrowBookService.checkBorrow(bookId, userId);
		System.out.println("--------");
		if(checkborrow){
			return "borrowbooksuccess";
		}
			return "borrowbookfail";
	}
	
	@RequestMapping(value="/returnbook/{userId}",method = RequestMethod.POST)
	public String returnBook(@PathVariable long userId,HttpServletRequest request,Model model){		
		System.out.println("userId is "+userId);
		List<BorrowBook> list = borrowBookService.getAllReturn(userId);
		
//		if(!list.isEmpty()){
//			for(BorrowBook u:list){
//				System.out.println("****IN borrowbookController*****: "+u.getBorrowbookId());
//			}		
//		}
		model.addAttribute("list",list);
		System.out.println("Controller ^^^ display all not returned books");
		return "returnbook";
	}
	
	@RequestMapping(value="/choosereturnbook/{borrowbookId}",method = RequestMethod.POST)
	public String chooseReturnBook(@PathVariable long borrowbookId,HttpServletRequest request,Model model){
		System.out.println("In chooseReturnFunc, borrowbook ID is " + borrowbookId);
		//change status=1 to status=0
		boolean result = borrowBookService.changeStatus(borrowbookId);
		if(result){
		return "userreturnbooksuccess";
		}else{
			return "fail"; //fail return book
		}
	}
	
	@RequestMapping(value="/updateuserinfo/{userId}/{role}",method= RequestMethod.GET)
	public String updateUserInfoGet(@PathVariable long userId,@PathVariable int role,HttpServletRequest request,Model model){
		User user = userService.getOne(userId);
		model.addAttribute("user", user); //change
		System.out.println("--user id is "+ userId);
		System.out.println("--user role is " + role);
		return "updateuserinfo";
	}
	
	@RequestMapping(value="/updateuserinfo/{userId}/{role}",method= RequestMethod.POST)
	public String updateUserInfo(@PathVariable long userId,@PathVariable int role,HttpServletRequest request,Model model,User user){	
		System.out.println("%%%%%%BorrowBookController updateUserInfo Func*****");
		user = userService.getOne(userId);
		model.addAttribute("user", user);
		System.out.println(userId+"^^^^"+role);
		return "updateuserinfo";
	}
	
	@RequestMapping(value="/userborrowhistory/{userId}",method= RequestMethod.GET)
	public String userBorrowHist(@PathVariable long userId,HttpServletRequest request,Model model){
		model.addAttribute("borrowbook", new BorrowBook());
		System.out.println("borrow history user id is "+ userId);
		return "userborrowhistory";
	}
	
	@RequestMapping(value="/userborrowhistory/{userId}",method= RequestMethod.POST)
	public String userBorrowHis(@PathVariable long userId,HttpServletRequest request,Model model,BorrowBook borrowbook){
		model.addAttribute("borrowbook", borrowbook);
		System.out.println("borrow history &&&&&&&& " + userId );
		List<BorrowBook> list = borrowBookService.getBorrowHis(userId);
		// NullPointerException
//		for(BorrowBook u:list){ 
//			System.out.println("****IN borrowbookController*****: "+u.getBorrowbookId());
//		}	
		model.addAttribute("list",list);
		System.out.println("Controller ^^^ display BORROW HISTORY");		
		return "userborrowhistory";
	}
	
	@RequestMapping(value="/admincheckborrowhistory/{userId}",method= RequestMethod.POST)
	public String adminCheckBorrowHis(@PathVariable long userId,HttpServletRequest request,Model model,BorrowBook borrowbook){
		model.addAttribute("borrowbook", borrowbook);
		System.out.println("borrow history &&&&&&&& " + userId );
		List<BorrowBook> list = borrowBookService.getBorrowHis(userId);
		// NullPointerException
//		for(BorrowBook u:list){ 
//			System.out.println("****IN borrowbookController*****: "+u.getBorrowbookId());
//		}	
		model.addAttribute("list",list);
		System.out.println("Controller ^^^ display BORROW HISTORY");		
		return "admincheckborrowhistory";
	}
}
