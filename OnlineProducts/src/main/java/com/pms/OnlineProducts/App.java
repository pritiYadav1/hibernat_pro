package com.pms.OnlineProducts;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pms.OnlineProducts.dao.OnlineProductDAO;
import com.pms.OnlineProducts.entity.OnlineProduct;
import com.pms.OnlineProducts.entity.ProductDetails;
import com.pms.OnlineProducts.entity.Supplier;
import com.pms.OnlineProducts.utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
	Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    	ProductDetails pd1=new ProductDetails();
    	pd1.setProductDescription("This my new product11");
    	
    	OnlineProduct p1=new OnlineProduct();
    	p1.setProductName("Itemno11");
    	p1.setProductBrand("Brandno11");
    	p1.setProductCatagory("CataNo11");
    	p1.setProductPrice(150);
    	p1.setProductQuantity(10);
    	p1.setDetails(pd1);
        
    	ProductDetails pd2=new ProductDetails();
    	pd2.setProductDescription("This my new product22");
    	
    	OnlineProduct p2=new OnlineProduct();
    	p2.setProductName("Itemno22");
    	p2.setProductBrand("Brandno22");
    	p2.setProductCatagory("CataNo22");
    	p2.setProductPrice(170);
    	p2.setProductQuantity(8);
    	p2.setDetails(pd2);
    	
    	ProductDetails pd3=new ProductDetails();
    	pd3.setProductDescription("This my new product33");
    	
    	OnlineProduct p3=new OnlineProduct();
    	p3.setProductName("Itemno33");
    	p3.setProductBrand("Brandno33");
    	p3.setProductCatagory("CataNo33");
    	p3.setProductPrice(200);
    	p3.setProductQuantity(20);
    	p3.setDetails(pd3);
    	
    	ArrayList<OnlineProduct> l1=new ArrayList<>();
    	
    	l1.add(p1);
    	l1.add(p2);
    	l1.add(p3);
    	
    	Supplier s1=new Supplier();
    	s1.setsName("Priti");
    	s1.setsContactNo("1212");
    	s1.setsAddress("Kandivali");
    	s1.setOnlineProduct(l1);
    	
    	Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			//session.save(p1);
			//session.save(p2);
			//session.save(p3);
			session.save(s1);
			transaction.commit();
			System.out.println(s1);
			session.close();
		} 
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
    	
    	
    	
    	/*
    	App obj=new App();
    	
    	ProductDetails details=new ProductDetails("This phone is good for everage  budget");
    	OnlineProduct product=new OnlineProduct("CellpHone", "Vivo", "Electronics", 10000, 3, details);
    	
    	Transaction transaction=null;
		try(Session session=HibernateUtility.getSessionFactory().openSession()) 
		{
			transaction=session.beginTransaction();
			session.save(details);
			session.save(product);
			transaction.commit();
			System.out.println(product);
			session.close();
		} 
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
    	
    	//obj.Online_product_operation();
        */
        
    }
    
    public void Online_product_operation()
    {
    	OnlineProduct product1=new OnlineProduct();
        OnlineProductDAO productDao=new OnlineProductDAO();
        int id;
        System.out.println("Enter your choice");
        System.out.println("1:Save product");
        System.out.println("2:Delete product");
        System.out.println("3:Update product");
        System.out.println("4:Get product By ID");
        int choice=sc.nextInt();
        
        switch(choice)
        {
        case 1:
	        System.out.println("Enter product name");
	        product1.setProductName(sc.next());
	        System.out.println("Enter product brand name");
	        product1.setProductBrand(sc.next());
	        System.out.println("Enter product catagory");
	        product1.setProductCatagory(sc.next());
	        System.out.println("Enter product Price");
	        product1.setProductPrice(sc.nextInt());
	        System.out.println("Enter product Quantity");
	        product1.setProductQuantity(sc.nextInt());
	        
	        productDao.saveProduct(product1);
	        
	        System.out.println(product1);
	        
	        break;
        case 2:
        		System.out.println("Enter Product ID");
        		 id=sc.nextInt();
        		productDao.deleteProduct(id);
        		
        	break;
        case 3:
        	productDao.updateProduct();
        	break;
        case 4:
        	System.out.println("Enter Product ID");
    			 id=sc.nextInt();
    			 productDao.getProductById(id);
        	break;
        	
        }
        
    }
    
}
