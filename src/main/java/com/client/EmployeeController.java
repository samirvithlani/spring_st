package com.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.bean.EmployeeBean;

public class EmployeeController {

	public static void main(String[] args) {

		FileSystemResource res = new FileSystemResource("src/main/resources/spring.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);

		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring.xml");

		// prototype
		// singleTon ->

		//EmployeeBean employeeBean1 = new EmployeeBean();
		//EmployeeBean employeeBean2 = new EmployeeBean();

		 EmployeeBean employeeBean1 = (EmployeeBean) factory.getBean("emp");
		 EmployeeBean employeeBean2 = factory.getBean("emp", EmployeeBean.class);

		// System.out.println(employeeBean1);
		// System.out.println(employeeBean2);

		EmployeeBean employeeBean3 = (EmployeeBean) ctx.getBean("emp");

		employeeBean3.display();

	}
}
