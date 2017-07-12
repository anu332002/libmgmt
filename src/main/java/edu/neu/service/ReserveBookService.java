package edu.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.dao.BaseDAO;
import edu.neu.user.Page;
import edu.neu.user.ReserveBook;

@Service
public class ReserveBookService implements BaseService<ReserveBook>{

	@Autowired
	private BaseDAO<ReserveBook> reservebookdao;
	
	@Override
	@Transactional(readOnly=false)
	public void insert(ReserveBook object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=false)
	public void update(ReserveBook newObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReserveBook> getAll() {
		return reservebookdao.getAll();
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
		// check reservation
		System.out.println("ReserveBookService");
		return reservebookdao.checkBorrow(bookId, userId);
	}

	@Override
	public List<ReserveBook> getAllReturn(Long userId) {
		return reservebookdao.getAllReturn(userId);
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
		return reservebookdao.delete(id);
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
	public Page queryForPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReserveBook getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReserveBook> getbyParam(String st, int a) {
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
		return reservebookdao.takebook(rid,bid, uid);
	}

}
