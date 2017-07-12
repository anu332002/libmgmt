package edu.neu.dao;

import java.util.List;

import edu.neu.user.User;

public interface BaseDAO<T> {
	
	public void insert(T object);
	public void update(T newObject);
	public List<T> getAll();
	public Long queryCount(T object);
	public boolean logIn(T object);	
	public long getCurId(T object);
	public boolean checkBorrow(long bookId,long userId);
	public List<T> getAllReturn(Long userId);
	public boolean changeStatus(Long id);
	public boolean updateName(Long id,String st);
	public boolean updatePassword(Long id,String st);
	public boolean updateEmail(Long id,String st);
	public List<T> getBorrowHis(Long id);
	public boolean delete(long id);
	public boolean updatePrice(long id, String st);
	public boolean updateNum(long id,int num);
	public List<T> queryForPage(int offset,int length);
	public int getAllRowCount();
	public T getOne(long id);
	public List<T> getbyParam(String st,int a);
	public List<T> getPrice(String min,String max);
	public boolean takebook(long rid,long bid,long uid);
}
