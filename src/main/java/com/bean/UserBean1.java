package com.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user1")
@Scope("prototype")
public class UserBean1 {

	private int uId;
	private String uName;

	@Autowired
	private Date date;

	@Autowired
	private UserDetail userDetail;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public void test() {

		System.out.println(date.getDate());
		System.out.println(userDetail.getUserContact());

	}

	@PostConstruct
	public void init() {

		userDetail.setUserContact("+91 8460224296");
	}

	@PreDestroy
	public void destroy() {

		System.out.println("destroy called...");
		userDetail = null;
	}
}
