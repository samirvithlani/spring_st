package com.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.UserBean;
import com.config.Config;
import com.dao.UserDao;

public class UserController {

	static UserDao userDao;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		/*
		 * UserBean userBean1 = (UserBean) ctx.getBean("user"); UserBean userBean2 =
		 * (UserBean) ctx.getBean("user"); System.out.println(userBean1);
		 * System.out.println(userBean2); userBean1.test(); ctx.close();
		 */

		userDao = (UserDao) ctx.getBean("user");
		System.out.println(userDao.addUser());

		List<UserBean> list = userDao.fetchUsers();
		for (UserBean u : list) {

			System.out.println(u.getuId() + "-" + u.getuName());
		}

		//System.out.println(userDao.getUsersById(10).getuName());

	}
}
