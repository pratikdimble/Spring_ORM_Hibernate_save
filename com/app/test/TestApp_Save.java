package com.app.test;

import javax.transaction.TransactionManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
  
import com.app.entity.Employee;

public class TestApp_Save {

	public static void main(String[] args) {
	
		//configure the spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		//create the object of hibernate template  and get the hibernate teplate bean
		HibernateTemplate ht=(HibernateTemplate)ctx.getBean("hibernateTemplateObj");
		//TransactionManager tm=(TransactionManager)ctx.getBean("transactionManager");
		ht.setCheckWriteOperations(false);
		//create the entity class object
		Employee emp=new Employee();
			//set the values
			emp.setId(10);
			emp.setName("Pratik");
			emp.setSalary(12.36f);
			
			//save the object
			try {
			//tm.begin();
			int idval=(Integer)ht.save(emp);
			//tm.commit();
			System.out.println("\n\t\t***Object Saved With Id: "+idval);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}//main() close

}//class close
