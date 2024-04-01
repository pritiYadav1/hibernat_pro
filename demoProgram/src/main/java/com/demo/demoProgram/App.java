package com.demo.demoProgram;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       // Configuration cfg=new Configuration();
     //   cfg.configure("hibernate.cfg.xml");
     //   SessionFactory factory=cfg.buildSessionFactory();
      //  System.out.println(factory);
        //System.out.println(factory.isClosed());
  /*      
        Student st=new Student();
        st.setId(13);
        st.setName("Priti");
        st.setEmail("pra@gmail.com");
        
       // System.out.println(st);
        
        Student st1=new Student();
        st1.setId(12);
        st1.setName("Anuj");
        st1.setEmail("anuj@gmail.com");
        
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(st1);
        tx.commit();
        session.close();
        */
        
        
        Session session=HibernateUtil.getSession();
       
        Student st1=new Student();
        st1.setId(14);
        st1.setName("Priya");
        st1.setEmail("priya@gmail.com");
        
        Transaction tx=session.beginTransaction();
        session.save(st1);
        tx.commit();
        session.close();
        
        
        
    }
}
