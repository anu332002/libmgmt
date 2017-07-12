package edu.neu.dao;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import edu.neu.user.Book;
import edu.neu.user.BorrowBook;

@Repository(value="borrowbookdao")
public class BorrowBookDAO implements BaseDAO<BorrowBook>{
	
	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(BorrowBook object) {
		if(object==null){
			System.out.println("ERROR");
		}
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		System.out.println("borrowbookdao after session");
	}

	@Override
	public void update(BorrowBook newObject) {		
	}

	@Override
	public List<BorrowBook> getAll() {	
		return null;
	}

	@Override
	public Long queryCount(BorrowBook object) {
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
		System.out.println("BorrowBookDAO"+"bookId is "+bookId+" userId is "+userId);
		//status 0 means returned , status 1 means in borrowing 
		//in reservbook, 0 means already reserved but not take, 1 means already take,means in borrowing
		List<Long> list = null;
		List<Integer> listnum = null;
		List<Long> resnum = null;
		
		String q = "select borrowbook.borrowbookId from BorrowBook borrowbook where borrowbook.bookId='"+bookId+"'"+"and borrowbook.status='1'";
		String s = "select book.num from Book book where book.bookId='"+bookId+"'";
		String r = "select reservebook.reservebookId from ReserveBook reservebook where reservebook.booksId='"+bookId+"'"+"and reservebook.status='0'"; 
		
		int count = 0; //count the num of this book in borrowing
		int num = 0; //the total num of this book
		int reserve = 0;
		
		Date date = new Date();
		
		BorrowBook borrowbook = new BorrowBook();
		try{
			Session session = sessionFactory.getCurrentSession();
			
			Query query = session.createQuery(q);
			Query querynum = session.createQuery(s);
			Query queryres = session.createQuery(r);
			
			System.out.println("#######");
			
			list = query.list();
			for(Long u:list){
				count++;
			}
			
			resnum = queryres.list();
			for(Long u:resnum){
				reserve++;
			}
			
			listnum = querynum.list();
			for(Integer u:listnum){
				num = u.intValue();
			}
			
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		if(list.isEmpty() || (count+reserve)<num){
			//insert this record into table borrowbook
			borrowbook.setBorrowDate(date);			
			borrowbook.setBookId(bookId);
			borrowbook.setUserId(userId);
			borrowbook.setStatus(1);
			
			insert(borrowbook);
			
			return true;
		}
		return false;
	}

	@Override
	public List<BorrowBook> getAllReturn(Long userId) {
		List<BorrowBook> list = null;
		
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from BorrowBook borrowbook where borrowbook.userId='"+userId+"' and borrowbook.status='1'";
			Query query = session.createQuery(q);
			list = query.list();
			
			for(BorrowBook u:list){
				System.out.println("$$$$$$$$$$BORROW BOOK ID IS : "+u.getBorrowbookId());
			}

		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	@Override
	public boolean changeStatus(Long id) {
		
		int result = 0;
		try{
			
			Session session = sessionFactory.getCurrentSession();
			String q = "update BorrowBook borrowbook set borrowbook.status='0' where borrowbook.borrowbookId='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***in BorrowBookDAO, result is***"+result);
			
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean updateName(Long id, String st) {
		return false;
	}

	@Override
	public boolean updatePassword(Long id, String st) {
		return false;
	}

	@Override
	public boolean updateEmail(Long id, String st) {
		return false;
	}

	@Override
	public List<BorrowBook> getBorrowHis(Long id) {
			List<BorrowBook> list = null;
		
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from BorrowBook borrowbook where borrowbook.userId='"+id+"'";
			Query query = session.createQuery(q);
			list = query.list();
			
			for(BorrowBook u:list){
				System.out.println("History-----BORROW BOOK ID IS : "+u.getBorrowbookId());
			}

		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
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
	public List<BorrowBook> queryForPage(int offset, int length) {
		List<BorrowBook> list = null;
		try{
			
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Book book");
			query.setFirstResult(offset);
			query.setMaxResults(length);
			list = query.list();
		}catch(RuntimeException e){
			throw e;
		}
		return list;
	}

	@Override
	public int getAllRowCount() {
		// TODO Auto-generated method stub
		return 0;
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
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update ReserveBook reservebook set reservebook.status='1' where reservebook.reservebookId='"+rid+"'";
			Query query = session.createQuery(q);
			int result = query.executeUpdate();
			System.out.println("**in ReserveBookDAO, result is**"+result);
			
			Date date = new Date();
			BorrowBook borrowbook = new BorrowBook();
			//status 0 means returned , status 1 means in borrowing 
			//in reservbook, 0 means already reserved but not take, 1 means already take,means in borrowing
			borrowbook.setBorrowDate(date);			
			borrowbook.setBookId(bid);
			borrowbook.setUserId(uid);
			borrowbook.setStatus(1);
			insert(borrowbook);
			
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
