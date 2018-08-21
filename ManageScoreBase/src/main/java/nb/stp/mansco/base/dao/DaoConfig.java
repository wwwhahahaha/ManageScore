package nb.stp.mansco.base.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import nb.stp.mansco.findpasswd.dao.Column;
import nb.stp.mansco.findpasswd.dao.Timestamp;

@Configuration
@ComponentScan(basePackages = "nb2.stp.mansco")
public class DaoConfig {

}
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
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}