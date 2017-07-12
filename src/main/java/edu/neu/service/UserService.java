package edu.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.dao.BaseDAO;
import edu.neu.dao.UserDAOimp;
import edu.neu.user.Book;
import edu.neu.user.Page;
import edu.neu.user.User;


@Service
//@Transactional
public class UserService implements BaseService<User> {
	@Autowired    //@Resource
	//@Qualifier("usersdao")
	private BaseDAO<User> userdao;

	public BaseDAO<User> getUserdao() {
		return userdao;
	}

	public void setUserdao(BaseDAO<User> userdao) {
		this.userdao = userdao;
	}

	@Override
	@Transactional(readOnly=false)
	public void insert(User user) {
		System.out.println("UserService");
		userdao.insert(user);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(User newObject) {		
	}
	
	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public boolean logIn(User object) {
		boolean login = userdao.logIn(object);
		if(login){
			return true;
		}
		return false;
	}

	@Override
	public long getCurId(User object) {
		return userdao.getCurId(object);
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
		return userdao.updateName(id, st);
	}

	@Override
	public boolean updatePassword(Long id, String st) {
		return userdao.updatePassword(id, st);
	}

	@Override
	public boolean updateEmail(Long id, String st) {
		return userdao.updateEmail(id, st);
	}

	@Override
	public List<User> getBorrowHis(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		return userdao.delete(id);
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
		int allRow = userdao.getAllRowCount();
		int offset = page.countOffset(currentPage, pageSize);
		List<User> list = userdao.queryForPage(offset, pageSize);
		
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setList(list);
		
		return page;
	}

	@Override
	public User getOne(long id) {
		return userdao.getOne(id);
	}

	@Override
	public List<User> getbyParam(String st, int a) {
		return userdao.getbyParam(st, a);
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
