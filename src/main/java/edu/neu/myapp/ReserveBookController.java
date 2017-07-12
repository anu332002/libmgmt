package edu.neu.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.service.BaseService;
import edu.neu.user.*;

@Controller
@RequestMapping(value="/reservebookcontrol")
public class ReserveBookController {
	
	@Autowired
	private BaseService<ReserveBook> reserveBookService;
	
	@Autowired
	private BaseService<BorrowBook> borrowBookService;
	
	@RequestMapping(value="reservebookcheck/{bookId}/{userId}",method = RequestMethod.POST)
	public String reservebookcheck(@PathVariable long bookId,@PathVariable long userId,HttpServletRequest request, Model model){
		System.out.println("reserve book ID is "+bookId +" reserve user Id is "+userId);
		boolean checkre = reserveBookService.checkBorrow(bookId, userId);
		if(checkre){
			return "reservebooksuccess";
		}
		return "reservebookfail";
	}
	
	@RequestMapping(value="reservedbook/{userId}",method = RequestMethod.POST)
	public String reservedBook(@PathVariable long userId, HttpServletRequest request,Model model){
		System.out.println("Reserve user id is "+userId);
		// in this func to display all reserved book
		List<ReserveBook> list = reserveBookService.getAllReturn(userId);
//		if(!list.isEmpty()){
//			for(ReserveBook u:list){
//			System.out.println("****IN borrowbookController*****: "+u.getReservebookId());
//			}
//		}
		model.addAttribute("list", list);
		System.out.println("Controller ^^^ display all not returned books");
		return "reservedbook";
	}
	
	@RequestMapping(value="takebook/{reserveId}/{booksId}/{userId}",method = RequestMethod.POST)
	public String takeBook(@PathVariable long reserveId,@PathVariable long booksId,@PathVariable long userId, HttpServletRequest request,Model model ){
		System.out.println("ReserveBook id is "+reserveId);
		System.out.println("Take Book book id is "+booksId);
		System.out.println("Take Book user id is "+userId);
		
		boolean result = borrowBookService.takebook(reserveId, booksId, userId);
		if(result){
		return "takebooksuccess";
		}
		return "fail";
	}
	
	@RequestMapping(value="checkreserve/{userId}",method = RequestMethod.POST)
	public String checkReserve(@PathVariable long userId, HttpServletRequest request,Model model ){
		System.out.println("Take Book user id is "+userId);
		List<ReserveBook> list = reserveBookService.getAll();
		model.addAttribute("list",list);
		return "admincheckreserve";
	}
	
	@RequestMapping(value="/removereserve/{reserveId}",method = RequestMethod.POST)
	public String removeReserve(@PathVariable long reserveId, HttpServletRequest request,Model model,ReserveBook reservebook ){
		System.out.println("Remove Reservation id is "+ reserveId);
		boolean result = reserveBookService.delete(reserveId);
		return "removereserve";
	}
}
