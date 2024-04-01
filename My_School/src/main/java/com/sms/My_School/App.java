package com.sms.My_School;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
    	App obj=new App();
        System.out.println( "WELCOME TO MY SCHOOL" );
        //obj.insertData();
       // obj.getStudentById();
        //obj.UpdateData();
        obj.deleteData();
        obj.getAllRecords();
    }
    
    public void insertData()
    {
    	Session session=HibernateUtil.getSession();
    	Student s=new Student();
    	System.out.println("Enter Student Name:");
    	s.setStud_name(sc.next());
    	System.out.println("Enter Student Email");
    	s.setStud_email(sc.next());
    	Transaction tx=session.beginTransaction();
    	session.save(s);
    	System.out.println(s);
    	tx.commit();
    	session.close();
    }
    public void getStudentById()
    {
    	Session session=HibernateUtil.getSession();
    	Transaction tx=session.beginTransaction();
    	System.out.println("Enter student ID");
    	int id=sc.nextInt();
    	Student s1=session.get(Student.class, id);
    	System.out.println("Student ID:"+s1.getStud_id());
    	System.out.println("Name:"+s1.getStud_name());
    	System.out.println("Gmail"+s1.getStud_email());
    	tx.commit();
    	session.close();
    	
    }
    public void getAllRecords()
    {
    	Session session=HibernateUtil.getSession();
    	Transaction tx=session.beginTransaction();
    	Query qur=session.createQuery("from Student");
    	
    	List<Student> list_students=qur.getResultList();
    	for(Student s:list_students)
    	{
    		System.out.println("Student ID:"+s.getStud_id());
        	System.out.println("Name:"+s.getStud_name());
        	System.out.println("Gmail"+s.getStud_email());
    	}
    	tx.commit();
    	session.close();
    	
    }
    public void UpdateData()
    {
    	Session session=HibernateUtil.getSession();
    	Transaction tx=session.beginTransaction();
    	System.out.println("Enter student ID");
    	int id=sc.nextInt();
    	Student s1=session.get(Student.class, id);
    	
    	System.out.println("Enter Student Email");
    	s1.setStud_email(sc.next());
    	
    	session.saveOrUpdate(s1);
    	tx.commit();
    	session.close();
    }
    
    public void deleteData()
    {
    	Session session=HibernateUtil.getSession();
    	Transaction tx=session.beginTransaction();
    	System.out.println("Enter student ID");
    	int id=sc.nextInt();
    	Student s1=session.get(Student.class, id);
    	
    	session.delete(s1);
    	
    	tx.commit();
    	session.close();
    }
}
