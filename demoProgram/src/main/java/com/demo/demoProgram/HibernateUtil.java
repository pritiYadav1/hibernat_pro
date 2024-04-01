package com.demo.demoProgram;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	private static final SessionFactory sessionFactory = getSessionFactory();
	
	private static SessionFactory  getSessionFactory()
	{
		
		try
		{
			return new Configuration().
					configure("hibernate.cfg.xml").
					addAnnotatedClass(Student.class).buildSessionFactory();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	public static Session getSession()
	{
		return sessionFactory.openSession();
		
	}

}
