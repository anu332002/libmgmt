package edu.neu.user;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private long id;
	
	@Column(name="name",length=60)
	@NotEmpty(message="user name can not be empty")
	private String username;
	
	@Column(name="password",length=15)
	@NotEmpty(message="password can not be empty")
	@Length(min=6,max=15,message="password length should be 5-15")
    private String password;
	
	@Column(name="email",length=60)
	@NotEmpty(message="email can not be empty")
	@Email(message="email format is not correct")
    private String email;
	
	@Column(name="role")
    private int role;
	
    public static AtomicLong idCounter = new AtomicLong(); //assign unique id
    
	public final long getId() {
		return id;
	}
	public final void setId(long id) {
		this.id = id;
	}
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
    public long assignId(){
    	return idCounter.incrementAndGet();
    }
}
