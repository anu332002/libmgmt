package edu.neu.dao;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import edu.neu.user.Book;
import edu.neu.user.User;

@Repository(value="bookdao")
public class BookDAO implements BaseDAO<Book>{

	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Book object) {
		if(object==null){
			System.out.println("ERROR!");
		}
		System.out.println("BookDAO");
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		System.out.println("BookDAO after session");
	}

	@Override
	public void update(Book newObject) {		
	}

	@Override
	public List<Book> getAll() {
		
		List<Book> list = null;
		try{
			Session session = sessionFactory.getCurrentSession();			
			list = session.createQuery("from Book book").list();	
			Iterator it = list.iterator();
			while(it.hasNext()){
				Book book = (Book)it.next();
				System.out.println(book.getBookId()+" "+book.getBookName());
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


	@SuppressWarnings("unchecked")
	@Override
	public List<Book> queryForPage(int offset, int length) {
		List<Book> list = null;
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
	public Long queryCount(Book object) {
		return null;
	}

	@Override
	public boolean logIn(Book object) {
		return false;
	}

	@Override
	public long getCurId(Book object) {
		return 0;
	}

	@Override
	public boolean checkBorrow(long bookId, long userId) {
		return false;
	}

	@Override
	public List<Book> getAllReturn(Long userId) {
		return null;
	}

	@Override
	public boolean changeStatus(Long id) {
		return false;
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
	public List<Book> getBorrowHis(Long id) {
		return null;
	}

	@Override
	public boolean delete(long id) {
		int result = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update Book book set book.num='0' where book.bookId='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***BookDAO, result is***"+result);
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updatePrice(long id, String st) {
		int result = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update Book book set book.price='"+st+"' where book.bookId='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***BookDAO, result is***"+result);
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateNum(long id, int num) {
		int result = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update Book book set book.num='"+num+"' where book.bookId='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***BookDAO, result is***"+result);
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int getAllRowCount() {
		int count = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "select count(*) from Book book";
			Query query = session.createQuery(q);
			count = ((Number)query.uniqueResult()).intValue();
			System.out.println("Total book row number is "+count);
		}catch(DataAccessException e){
			e.printStackTrace();
			return 0;
		}
		return count;
	}

	@Override
	public Book getOne(long id) {
		List<Book> list = null;
		Book book = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from Book book where book.bookId='" + id +"'";
			Query query = session.createQuery(q);
			list = query.list();
				for(Book u:list){
					book = u;
					System.out.println("in bookdaoIMP, user id is "+ u.getBookId());
				}
		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		return book;
	}

	@Override
	public List<Book> getbyParam(String st,int a) {
		List<Book> list = null;
		try{
			Session session = sessionFactory.getCurrentSession();
				if(a==1){
					String q = "from Book book where book.bookName like ?";			
					Query query = session.createQuery(q);
					query.setString(0, "%"+st+"%");
					list = query.list();
						for(Book u:list){
							System.out.println("Search by book name KEYWORDS, book id is "+ u.getBookId());
						} 
				}else if(a==2){
					String q = "from Book book where book.bookAuthor like ?";			
					Query query = session.createQuery(q);
					query.setString(0, "%"+st+"%");
					list = query.list();
						for(Book u:list){
							System.out.println("Search by book author KEYWORDS, book id is "+ u.getBookId());
						} 
				}	
		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Book> getPrice(String min, String max) {
		List<Book> list = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from Book book where book.price+0 >="+ min+"+0" +"and book.price+0 <="+max+"+0";			
			Query query = session.createQuery(q);
			list = query.list();
			for(Book u:list){
				System.out.println("Search by book PRICE, book id is "+ u.getBookId());
			}
		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public boolean takebook(long rid,long bid, long uid) {
		// TODO Auto-generated method stub
		return false;
	}

}
