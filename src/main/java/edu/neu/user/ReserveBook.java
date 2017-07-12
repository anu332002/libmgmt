package edu.neu.user;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservebook")
public class ReserveBook implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reservebookId")
	private long reservebookId;
	@Column(name="reserveDate")
	private Date reserveDate;
	@Column(name="takedueDate")
	private Date takedueDate;
	@Column(name="booksId")
	private long booksId;
	@Column(name="usersId")
	private long usersId;
	@Column(name="status")
	private int status;
	public static AtomicLong idCounter = new AtomicLong();
	
	public long assignId(){
		return idCounter.incrementAndGet();
	}
	public long getReservebookId() {
		return reservebookId;
	}
	public void setReservebookId(long reservebookId) {
		this.reservebookId = reservebookId;
	}
	public long getBooksId() {
		return booksId;
	}
	public void setBooksId(long booksId) {
		this.booksId = booksId;
	}
	public long getUsersId() {
		return usersId;
	}
	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public Date getTakedueDate() {
		return takedueDate;
	}
	public void setTakedueDate(Date takedueDate) {
		this.takedueDate = takedueDate;
	}
	
	
}
