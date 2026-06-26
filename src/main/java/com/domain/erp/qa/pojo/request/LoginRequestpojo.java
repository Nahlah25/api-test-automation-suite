package com.domain.erp.qa.pojo.request;

public class LoginRequestpojo {
public LoginRequestpojo(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
String email="baithulfarahh@gmail.com";
String password="Nahlahali@25";
String role="SHOPPER";
public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public String getRole() {
	return role;
}


}
