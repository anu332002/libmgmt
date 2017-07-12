package edu.neu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.user.Book;
import edu.neu.user.User;


@Repository(value="usersdao")
public class UserDAOimp implements BaseDAO<User>{

	@Autowired
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(User object) {
		if(object==null){
		}
		System.out.println("UserDAO");
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		System.out.println("UserDAO after session");
	}

	@Override
	public void update(User newObject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long queryCount(User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean logIn(User object) {
		String username = object.getUsername();
		String password = object.getPassword();
		String email = object.getEmail();
		int role = object.getRole();
		
		if(username==null){
			username="";
		}
		if(password==null){
			password="";
		}
		List<User> list = null;
		//the attribute correspond to class attribute NOT DATABASE!!! from CLASS.NAME
		String q = "select user.username, user.password, user.email, user.role from User user where user.username='"+username+"' and user.password='"+password
				        +"' and user.email='"+email+"' and user.role='"+role+"'";
				 
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(q);
			System.out.println("@@@@@@@userDAO login func");
			list = query.list();
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		if(list.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public long getCurId(User object) {
		String username = object.getUsername();
		String password = object.getPassword();
		String email = object.getEmail();
		int role = object.getRole();
		long id = 0;
		List<Long> list = null;
		String q = "select user.id from User user where user.username='"+username+"' and user.password='"+password
		        +"' and user.email='"+email+"' and user.role='"+role+"'";
		
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(q);
			list = query.list();
			for(Long u:list){
				id = u.longValue();
			}
		}catch(DataAccessException e){
			e.printStackTrace();
			return 0;
		}
		return id;
	}

	@Override
	public boolean checkBorrow(long bookId, long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllReturn(Long userId) {
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
		int result = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update User user set user.username='"+st+"' where user.id='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***UserDAO, result is***"+result);
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updatePassword(Long id, String st) {
		int result = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update User user set user.password='"+st+"' where user.id='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***UserDAO, result is***"+result);
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean updateEmail(Long id, String st) {
		int result = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "update User user set user.email='"+st+"' where user.id='"+id+"'";
			Query query = session.createQuery(q);
			result = query.executeUpdate();
			System.out.println("***UserDAO, result is***"+result);
		}catch(DataAccessException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public List<User> getBorrowHis(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		
		String q ="delete User user where user.id='"+id+"'";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryForPage(int offset, int length) {
		List<User> list = null;
		try{
			
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from User user where user.role='1'");
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
		int count = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "select count(*) from User user where user.role='1'";
			Query query = session.createQuery(q);
			count = ((Number)query.uniqueResult()).intValue();
			System.out.println("Total user row number is "+count);
		}catch(DataAccessException e){
			e.printStackTrace();
			return 0;
		}
		return count;
	}

	@Override
	public User getOne(long id) {
		List<User> list = null;
		User user = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from User user where user.id='" + id +"'";
			Query query = session.createQuery(q);
			list = query.list();
			for(User u:list){
				user = u;
				System.out.println("in userdaoIMP, user id is "+ u.getId());
			}
			
		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		return user;
	}

	@Override
	public List<User> getbyParam(String st,int p) {
		List<User> list = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			String q = "from User user where user.username like ?";			
			Query query = session.createQuery(q);
			query.setString(0, "%"+st+"%");
			list = query.list();
			for(User u:list){
				System.out.println("Search by USER name KEYWORDS, user id is "+ u.getId());
			} 
		}catch(DataAccessException e){
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<User> getPrice(String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean takebook(long rid,long bid, long uid) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
