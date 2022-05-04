package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import com.pojo.Classes;
import com.pojo.Student;
import com.pojo.Subject;
import com.pojo.Teacher;


public class HibernateUtil 
{
	public static SessionFactory sessionfactory;
	
	public static SessionFactory getSessionFactory() 
	{
		if (sessionfactory == null)
		{
			try
			{
		
	
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Classes.class)
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Subject.class)
					.addAnnotatedClass(Teacher.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
			
			System.out.println("Hibernate Java Config serviceRegistry created");
			sessionfactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionfactory;
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
		return sessionfactory;
		
	}
}

	


