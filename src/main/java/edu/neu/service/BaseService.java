package edu.neu.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.user.Page;

@Transactional
public interface BaseService<T> {
				
	public void insert(T object);
	public void update(T newObject);
	public List<T> getAll();
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
	public Page queryForPage(int currentPage,int pageSize); 
	public T getOne(long id);
	public List<T> getbyParam(String st,int a);
	public List<T> getPrice(String min,String max);
	public boolean takebook(long rid,long bid,long uid);
}



