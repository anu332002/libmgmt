package edu.neu.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.neu.service.BaseService;
import edu.neu.user.*;

@Controller
@RequestMapping(value="/bookcontrol")
public class BookController {
	
	@Autowired
	private BaseService<Book> bookService;
	
	@RequestMapping(value="/addbook", method = RequestMethod.GET)
	public String modelAutoBind(HttpServletRequest request, Model model){  
	    model.addAttribute("book", new Book());
	    return "addbook";
	}
	
	@RequestMapping(value="/addbook",method = RequestMethod.POST)
	public String modelAutoBind(HttpServletRequest request, Model model, Book book){
		model.addAttribute("book",book);
		return "addbook";
	}
	
	@RequestMapping(value="/addsuccess",method = RequestMethod.POST)
	public String modelAutoBinds(HttpServletRequest request, Model model, Book book){
		model.addAttribute("book",book);
		bookService.insert(book);
		System.out.println(book.getBookName()+" "+book.getBookAuthor());
		return "addsuccess";
	}
	
	@RequestMapping(value="/searchallbooks/{userId}",method = RequestMethod.POST)
	public String searchAll(@PathVariable long userId,HttpServletRequest request,HttpServletResponse response, Model model, Book book){
//		model.addAttribute("book",book);
//		List<Book> list = bookService.getAll();
//		model.addAttribute("list", list);
		System.out.println("Search All Books, admin ID is "+userId);
		try{
			String pageNo = request.getParameter("pageNo");
			if(pageNo==null){
				pageNo="1";
			}
			Page page = bookService.queryForPage(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Book> pagelist = page.getList();
			request.setAttribute("pagelist", pagelist);								
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "searchallbooks";
	}
	
	@RequestMapping(value="/usersearchallbooks/{userId}",method = RequestMethod.POST)
	public String usersearchAll(@PathVariable long userId, HttpServletRequest request, Model model, Book book){
		//model.addAttribute("book",book);
//		List<Book> list = bookService.getAll();
//		model.addAttribute("list", list);
		System.out.println("Search All Books, userId is "+userId);
		try{
			String pageNo = request.getParameter("pageNo");
			if(pageNo==null){
				pageNo="1";
			}
			Page page = bookService.queryForPage(Integer.valueOf(pageNo), 10);
			request.setAttribute("page", page);
			List<Book> pagelist = page.getList();
			request.setAttribute("pagelist", pagelist);								
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "usersearchallbooks";
	}
	
	@RequestMapping(value="/searchsomebooks",method = RequestMethod.POST)
	public String searchSomeBooks(HttpServletRequest request,HttpServletResponse response, Model model, Book book){
		List<Book> list = bookService.getAll();
		model.addAttribute("list", list);
		System.out.println("Search All Books");
		 		return "searchsomebooks";
	}

	@RequestMapping(value="/deletebooks/{bookId}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable long bookId, HttpServletRequest request, Model model, Book book){
		System.out.println("Delete book ID is " +bookId);
		boolean result = bookService.delete(bookId);
		if(result){
		return "deletebooksuccess";
		}
		return "fail";
	}
	
	@RequestMapping(value="/updatebook/{bookId}/{price}/{num}",method = RequestMethod.POST)
	public String updateBook(@PathVariable long bookId,@PathVariable int price,@PathVariable int num,HttpServletRequest request, Model model, Book book){
		System.out.println("Update book Info is " +bookId+" "+price+" "+num);
		return "updatebook";
	}
	
	@RequestMapping(value="/updateprice/{bookId}",method = RequestMethod.GET)
	public String updatePriceOne(@PathVariable long bookId,HttpServletRequest request, Model model){
		model.addAttribute("book",new Book());
		return "updateprice";
	}
	
	@RequestMapping(value="/updateprice/{bookId}",method = RequestMethod.POST)
	public String updatePrice(@PathVariable long bookId,HttpServletRequest request, Model model, Book book){
		model.addAttribute("book",book);
		System.out.println("###########BookController");
		System.out.println("@@@@@@@"+bookId);
		System.out.println("@@@@@@@"+book.getPrice());
		String price = book.getPrice();
		boolean result = bookService.updatePrice(bookId, price);
		if(result){
			return "updateprice";
		}
		return "fail";
		
	}
	
	@RequestMapping(value="/updatenum/{bookId}",method = RequestMethod.GET)
	public String updateNumOne(@PathVariable long bookId,HttpServletRequest request, Model model){
		model.addAttribute("book",new Book());
		return "updatenumber";
	}
	
	@RequestMapping(value="/updatenum/{bookId}",method = RequestMethod.POST)
	public String updateNum(@PathVariable long bookId,HttpServletRequest request, Model model, Book book){
		model.addAttribute("book", book);
		System.out.println("###########BookController");
		System.out.println("@@@@@@@"+bookId);
		System.out.println("@@@@@@@"+book.getNum());
		int num = book.getNum();
		boolean result = bookService.updateNum(bookId, num);
		if(result){
			return "updatenumber";
		}
		return "fail";
	}
	
	@RequestMapping(value="/searchbookbyid/{userId}",method = RequestMethod.POST)
	public String searchBookById(@PathVariable long userId,HttpServletRequest request, Model model, Book book){
		
		return "searchbookbyid";
	}
	
	@RequestMapping(value="/searchbyid",method = RequestMethod.POST)
	public String searchBookByIdText(@RequestParam("bookId") long bookId, HttpServletRequest request, Model model){
		System.out.println("Search By Book ID, book id is "+ bookId);
		Book book = bookService.getOne(bookId);
		model.addAttribute("book", book);
		return "searchbyid";
	}
	
	@RequestMapping(value="/adminsearchbyid",method = RequestMethod.POST)
	public String searchBookByIdA(@RequestParam("bookId") long bookId, HttpServletRequest request, Model model){
		System.out.println("Search By Book ID, book id is "+ bookId);
		Book book = bookService.getOne(bookId);
		model.addAttribute("book", book);
		return "adminsearchbyid";
	}
	
	@RequestMapping(value="/searchbyprice",method = RequestMethod.POST)
	public String searchBookByBookName(@RequestParam("minprice") String minprice,@RequestParam("maxprice") String maxprice, HttpServletRequest request, Model model,Book book){
		System.out.println("in controller, Search By PRICE, minprice is "+ minprice);
		System.out.println("in controller, Search By PRICE, maxprice is "+ maxprice);
		List<Book> list = bookService.getPrice(minprice, maxprice);
		model.addAttribute("list", list);
		return "searchbyprice";
	}
	
	@RequestMapping(value="/searchbyname",method = RequestMethod.POST)
	public String searchBookByPrice(@RequestParam("bookName") String bookName, HttpServletRequest request, Model model,Book book){
		System.out.println("in controller, Search By Book NAME, keyword is "+ bookName);
		List<Book> list = bookService.getbyParam(bookName,1);
		model.addAttribute("list", list);
		return "searchbyname";
	}
	
	@RequestMapping(value="/adminsearchbyname",method = RequestMethod.POST)
	public String searchBookByPriceA(@RequestParam("bookName") String bookName, HttpServletRequest request, Model model,Book book){
		System.out.println("in controller, Search By Book NAME, keyword is "+ bookName);
		List<Book> list = bookService.getbyParam(bookName,1);
		model.addAttribute("list", list);
		return "adminsearchbyname";
	}
	
	@RequestMapping(value="/adminsearchbyauthor",method = RequestMethod.POST)
	public String searchBookByAuthor(@RequestParam("bookAuthor") String bookAuthor, HttpServletRequest request, Model model,Book book){
		System.out.println("in controller, Search By Book AUTHOR, keyword is "+ bookAuthor);
		List<Book> list = bookService.getbyParam(bookAuthor,2);
		model.addAttribute("list", list);
		return "adminsearchbyauthor";
	}
	
	@RequestMapping(value="/borrowhistoryid/{bookId}",method = RequestMethod.POST)
	public String borrowhisId(@PathVariable long bookId, HttpServletRequest request, Model model){
		System.out.println("Search By Book ID, book id is "+ bookId);
		Book book = bookService.getOne(bookId);
		model.addAttribute("book", book);
		return "borrowhistoryid";
	}
	
	@RequestMapping(value="/borrowcheckhistoryid/{bookId}",method = RequestMethod.POST)
	public String checkborrowhisId(@PathVariable long bookId, HttpServletRequest request, Model model){
		System.out.println("Search By Book ID, book id is "+ bookId);
		Book book = bookService.getOne(bookId);
		model.addAttribute("book", book);
		return "borrowcheckhistoryid";
	}
	
}
