package com.jack.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;  


@Entity  
@Table(name = "user", catalog = "flower")  
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)  
public class User implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -487907882063705307L;
	private String id;
	private int type;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	private String userOrderAddress;
    private Timestamp createDate;
	
//    public User(UserVo userVo){
//    	this.id=userVo.getId();
//    	this.userName=userVo.getUserName();
//    	this.userPassword=userVo.getUserPassword();
//    	this.userEmail=userVo.getUserEmail();
//    	this.userPhone=userVo.getUserPhone();
//    	this.userOrderAddress=userVo.getUserOrderAddress();
//    	this.createDate=userVo.getCreateDate();
//    }
    
	@Id  
    @Column(name = "id", unique = true, nullable = false, length = 36)  
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="type", nullable=false)
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "userName", nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "userPassword", nullable = false)  
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Column(name = "userEmail") 
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Column(name = "userPhone") 
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	@Column(name = "userOrderAddress") 
	public String getUserOrderAddress() {
		return userOrderAddress;
	}
	public void setUserOrderAddress(String userOrderAddress) {
		this.userOrderAddress = userOrderAddress;
	}
	
	@Column(name = "createDate") 
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
