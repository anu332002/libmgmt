package edu.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.dao.BaseDAO;
import edu.neu.user.Book;
import edu.neu.user.BorrowBook;
import edu.neu.user.Page;

@Service
public class BorrowBookService implements BaseService<BorrowBook>{
	@Autowired
	private BaseDAO<BorrowBook> borrowbookdao;

	@Override
	@Transactional(readOnly=false)
	public void insert(BorrowBook object) {
		borrowbookdao.insert(object);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(BorrowBook newObject) {		
	}
	@Override
	public List<BorrowBook> getAll() {	
		return null;
	}
	@Override
	public boolean logIn(BorrowBook object) {
		return false;
	}
	@Override
	public long getCurId(BorrowBook object) {
		return 0;
	}
	@Override
	public boolean checkBorrow(long bookId,long userId){
		System.out.println("BorrowBookService");
		return borrowbookdao.checkBorrow(bookId, userId);
	}

	@Override
	public List<BorrowBook> getAllReturn(Long userId) {
		System.out.println("BorrowBookService Get All that need return");
		return borrowbookdao.getAllReturn(userId);
	}

	@Override
	public boolean changeStatus(Long id) {	
		return borrowbookdao.changeStatus(id);
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
	public List<BorrowBook> getBorrowHis(Long id) {		
		return borrowbookdao.getBorrowHis(id);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePrice(long id, String st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNum(long id, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page queryForPage(int currentPage, int pageSize) {
		Page page = new Page();
		int allRow = borrowbookdao.getAllRowCount();
		int offset = page.countOffset(currentPage, pageSize);
		List<BorrowBook> list = borrowbookdao.queryForPage(offset, pageSize);
		
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);
		
		return page;
	}

	@Override
	public BorrowBook getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowBook> getbyParam(String st,int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowBook> getPrice(String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean takebook(long rid,long bid, long uid) {
		return borrowbookdao.takebook(rid, bid, uid);
	}

}
