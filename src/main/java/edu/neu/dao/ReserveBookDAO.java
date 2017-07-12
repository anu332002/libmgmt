package edu.neu.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import edu.neu.user.BorrowBook;
import edu.neu.user.ReserveBook;

@Repository(value="reservebookdao")
public class ReserveBookDAO implements BaseDAO<ReserveBook>{

	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(ReserveBook object) {
		if(object==null){
			System.out.println("ERROR!!!");
		}
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		System.out.println("reservebookdao after session");
	}

	@Override
	public void update(ReserveBook newObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReserveBook> getAll() {
		//status 0 means returned , status 1 means in borrowing 
		//in reservbook, 0 means already reserved but not take, 1 means already take,means in borrowing
		List<ReserveBook> list = null;
		try{
			String q = "from ReserveBook reservebook where reservebook.status='0'";
			Session session = sessionFactory.getCurrentSession();
			list = session.createQuery(q).list();		
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
	public Long queryCount(ReserveBook object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logIn(ReserveBook object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getCurId(ReserveBook object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkBorrow(long bookId, long userId) {
		System.out.println("ReserveBookDAO"+"bookId is "+bookId+" userId is "+userId);
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
		ReserveBook reservebook = new ReserveBook();
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(q);
			Query querynum = session.createQuery(s);
			Query queryres = session.createQuery(r);
			
			System.out.println("+++++++++");
			list = query.list();
				for(Long u:list){
					count++;
				}
				
				listnum = querynum.list();
				for(Integer u:listnum){
					num = u.intValue();
				}
				resnum = queryres.list();
				for(Long u:resnum){
					reserve++;
				}
			}catch(DataAccessException e){
				e.printStackTrace();
				return false;
			}
			if(list.isEmpty() || (count+reserve)<num){
			// insert this record into table reservebook
				reservebook.setReserveDate(date);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.DAY_OF_MONTH, +3);
				Date dates = calendar.getTime();
				reservebook.setTakedueDate(dates);
				
				reservebook.setBooksId(bookId);
				reservebook.setUsersId(userId);
				
				insert(reservebook);
				
				return true;
			}
		return false;
	}

	@Override
	public List<ReserveBook> getAllReturn(Long userId) {
		List<ReserveBook> list = null;
		//in reservbook, 0 means already reserved but not take, 1 means already take,means in borrowing
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from ReserveBook reservebook where reservebook.usersId='"+userId+"' and reservebook.status='0'";
			Query query = session.createQuery(q);
			list = query.list();
			
			for(ReserveBook u:list){
				System.out.println("$$$$$$$$$$BORROW BOOK ID IS : "+u.getReservebookId());
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
	public List<ReserveBook> getBorrowHis(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		String q ="delete ReserveBook reservebook where reservebook.reservebookId='"+id+"'";
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(q);
			query.executeUpdate();
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		return true;
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

	@Override
	public List<ReserveBook> queryForPage(int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReserveBook getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReserveBook> getbyParam(String st,int p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReserveBook> getPrice(String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean takebook(long rid,long bid, long uid) {
		return false;
	}
	
}
