//package com.student.db;

public class student 
{
private String email;
private String password;
//private String status;
 public student(String email,String password)
 {
	 this.email=email;
	 this.password=password;
	// this.status=status;
 }
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
/*public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status=status;
}*/
}
