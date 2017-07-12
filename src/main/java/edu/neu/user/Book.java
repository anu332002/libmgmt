package edu.neu.user;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookId")
	private long bookId;
	@Column(name="bookName",length=100)
	private String bookName;
	@Column(name="bookAuthor",length=100)
	private String bookAuthor;
	@Column(name="price",length=10)
	private String price;
	@Column(name="num",length=11)
	private int num;
	
	public static AtomicLong idCounter = new AtomicLong(); 
	
	public final long getBookId() {
		return bookId;
	}
	public final void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public long assignId(){
    	return idCounter.incrementAndGet();
    }
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
