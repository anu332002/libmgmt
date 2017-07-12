package edu.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.dao.BaseDAO;
import edu.neu.user.Book;
import edu.neu.user.Page;

@Service
//@Transactional
public class BookService implements BaseService<Book>{
	@Autowired
	private BaseDAO<Book> bookdao;
	
	@Override
	@Transactional(readOnly=false)
	public void insert(Book object) {	
		System.out.println("BookService");
		bookdao.insert(object);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void update(Book newObject) {	
	}

	@Override
	public List<Book> getAll() {
		System.out.println("BoookService Get All");
		return bookdao.getAll();
	}

	@Override
	public boolean logIn(Book object) {
		return false;
	}

	@Override
	public long getCurId(Book object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkBorrow(long bookId, long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getAllReturn(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeStatus(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateName(Long id, String st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(Long id, String st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmail(Long id, String st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getBorrowHis(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		return bookdao.delete(id);
	}

	@Override
	public boolean updatePrice(long id, String st) {
		return bookdao.updatePrice(id, st);
	}

	@Override
	public boolean updateNum(long id, int num) {
		return bookdao.updateNum(id, num);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page queryForPage(int currentPage, int pageSize) {
		Page page = new Page();
		int allRow = bookdao.getAllRowCount();
		int offset = page.countOffset(currentPage, pageSize);
		List<Book> list = bookdao.queryForPage(offset, pageSize);
		
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);
		
		return page;
	}

	@Override
	public Book getOne(long id) {
		return bookdao.getOne(id);
	}

	@Override
	public List<Book> getbyParam(String st,int a) {
		return bookdao.getbyParam(st,a);
	}

	@Override
	public List<Book> getPrice(String min, String max) {
		return bookdao.getPrice(min, max);
	}

	@Override
	public boolean takebook(long rid,long bid, long uid) {
		// TODO Auto-generated method stub
		return false;
	}

}
