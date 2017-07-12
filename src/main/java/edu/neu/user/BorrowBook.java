package edu.neu.user;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="borrowbook")
public class BorrowBook implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="borrowbookId")
	private long borrowbookId;
	@Column(name="borrowDate")
	private Date borrowDate;	
	@Column(name="status",length=11)
	private int status;
//	private User user;
//	private Book book;
	private long userId;
	private long bookId;
	
	public static AtomicLong idCounter = new AtomicLong();
	
	public Long assignId(){
		return idCounter.incrementAndGet();
	}
	public long getBorrowbookId() {
		return borrowbookId;
	}
	public void setBorrowbookId(long borrowbookId) {
		this.borrowbookId = borrowbookId;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
//		Date currentTime = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		borrowDate = formatter.format(currentTime);
		this.borrowDate = borrowDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	
}
